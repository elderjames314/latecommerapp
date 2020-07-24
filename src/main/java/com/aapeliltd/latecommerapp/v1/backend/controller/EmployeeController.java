package com.aapeliltd.latecommerapp.v1.backend.controller;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeData;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeResource;
import com.aapeliltd.latecommerapp.v1.backend.service.EmployeeService;
import com.aapeliltd.latecommerapp.v1.backend.service.ResumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/latecommer/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResumptionService resumptionService;

    @GetMapping
    public ResponseEntity<EmployeeData> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {
        EmployeeData data =  employeeService.getAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResource> getEmployeeById(@PathVariable int id) {
       EmployeeResource employee = employeeService.findById(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);

    }
    @PostMapping("/{id}/resumption")
    public ResponseEntity<String> employeeClockedIn(@PathVariable int id, @RequestBody Resumption resumption) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        String response = resumptionService.employeeClockIn(employee.get(), resumption);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
//    @PostMapping
//    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
//        Employee employee1 =  employeeService.save(employee);
//        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        Optional<Employee> employee1 = employeeService.getEmployeeById(id);
        if(employee1.isPresent()) {
            employee1.get().setName(employee.getName());
            employee1.get().setEmail(employee.getEmail());
            employee1.get().setAddress(employee.getAddress());
            employeeService.save(employee1.get());
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employee1.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable int id) {
        Optional<Employee> employee1 = employeeService.getEmployeeById(id);
        if(employee1.isPresent()) {
            employeeService.deleteEmployeeById(employee1.get());
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
