package com.aapeliltd.latecommerapp.v1.backend.service;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import com.aapeliltd.latecommerapp.v1.backend.model.Fee;
import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import com.aapeliltd.latecommerapp.v1.backend.repository.EmployeeRepository;
import com.aapeliltd.latecommerapp.v1.backend.resource.Account;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeData;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public EmployeeResource findById(int id)
    {
        Optional<Employee> employees = employeeRepository.findById(id);
        EmployeeResource resource = new EmployeeResource();
        resource.setName(employees.get().getName());
        resource.setEmail(employees.get().getEmail());
        resource.setAddress(employees.get().getAddress());

        resource.setId(employees.get().getId());

        if(employees.get().getResumptions().size() > 0) {
            Account account = getAccountDetails(employees.get().getResumptions());
            resource.setMinutes(account.getLateInMinutes());
            resource.setFee(account.getFees());
        }



        return resource;

    }

    public Optional<Employee> getEmployeeById(int id) {
        return  employeeRepository.findById(id);
    }

    public EmployeeData searchEmployee(Integer pageNo, Integer pageSize, String sortBy, String search) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> employeesPage = employeeRepository.findEmployeeByNameOrEmailOrAddress(search, pageable);
        List<EmployeeResource> resources = new ArrayList<>();
        EmployeeData data = new EmployeeData();
        if(employeesPage.hasContent()) {
            employeesPage.forEach(employee -> {
                EmployeeResource resource = new EmployeeResource();
                resource.setName(employee.getName());
                resource.setEmail(employee.getEmail());
                resource.setAddress(employee.getAddress());
                resource.setId(employee.getId());
                Account account = getAccountDetails(employee.getResumptions());

                if(account != null) {
                    resource.setMinutes(account.getLateInMinutes());
                    resource.setFee(account.getFees());
                }
                resources.add(resource);
            });
            data.setTotalPages(employeesPage.getTotalPages());
            data.setEmployeeResources(resources);
        }
        return  data;
    }

    public EmployeeData getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);

        List<EmployeeResource> resources = new ArrayList<>();
        EmployeeData data = new EmployeeData();

        if(employeesPage.hasContent()) {
            employeesPage.forEach(employee -> {
                EmployeeResource resource = new EmployeeResource();
                resource.setName(employee.getName());
                resource.setEmail(employee.getEmail());
                resource.setAddress(employee.getAddress());
                resource.setId(employee.getId());
                Account account = getAccountDetails(employee.getResumptions());

                if(account != null) {
                    resource.setMinutes(account.getLateInMinutes());
                    resource.setFee(account.getFees());
                }
                resources.add(resource);
            });
            data.setTotalPages(employeesPage.getTotalPages());
            data.setEmployeeResources(resources);
            return data;
        }else
            return new EmployeeData();
    }

    public void deleteEmployeeById(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    private Account getAccountDetails(List<Resumption> resumptions) { ;
        double totalLateInMinutes = 0;
        double totalLateFees  = 0;
        if(resumptions.size() > 0) {
            for (Resumption resumption : resumptions){
                Fee commer = new Fee();
                commer = resumption.getLatecommer();
                if(commer != null) {
                    totalLateInMinutes += commer.getLateCommingInMinute();
                    totalLateFees += commer.getAmount();
                }

            }

        }
        Account account = new Account();
        account.setLateInMinutes(totalLateInMinutes);
        account.setFees(totalLateFees);

        return  account;
    }





}
