package com.aapeliltd.latecommerapp.v1.frontend.controller;

import com.aapeliltd.latecommerapp.v1.backend.model.Employee;
import com.aapeliltd.latecommerapp.v1.backend.model.Resumption;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeData;
import com.aapeliltd.latecommerapp.v1.backend.resource.EmployeeResource;
import com.aapeliltd.latecommerapp.v1.backend.resource.ResumptionResource;
import com.aapeliltd.latecommerapp.v1.backend.service.EmployeeService;
import com.aapeliltd.latecommerapp.v1.backend.service.ResumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResumptionService resumptionService;

    @GetMapping
    public ModelAndView index(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {
        EmployeeData data = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("data", data);
        mv.addObject("currentPage", pageNo);
        mv.addObject("today", new Date());
        return mv;
    }
    @GetMapping("frontend/search")
    public ModelAndView search(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam String search) {
       EmployeeData data = employeeService.searchEmployee(pageNo, pageSize, sortBy, "%"+search+"%");
       ModelAndView mv = new ModelAndView("index");
       mv.addObject("data", data);
       return mv;
    }

    @GetMapping("frontend/employees")
    @ResponseBody
    public EmployeeResource findOne(Integer id) {
        EmployeeResource employeeResource =  employeeService.findById(id);
        //System.out.println(employeeResource.getId());
        return employeeResource;
    }

    @PostMapping("frontend/save")
    public String save(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("frontend/delete-employees")
    public String deleteEmp(Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(employee.get());
        return "redirect:/";
    }
    @PostMapping("frontend/employee/clockin")
    public String clockInEmployee(ResumptionResource resumptionResource) throws ParseException {

        Optional<Employee> employee = employeeService.getEmployeeById(resumptionResource.getId());
        Resumption resumption = new Resumption();
        //set settings
        LocalDateTime now = LocalDateTime.now();
        int hours = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();
        String timeNow = hours+":"+minutes+":"+seconds;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date thresholdDate = sdf.parse(timeNow);
        resumption.setClockIn(thresholdDate);
        resumptionService.employeeClockIn(employee.get(), resumption);
        return "redirect:/";
    }



}
