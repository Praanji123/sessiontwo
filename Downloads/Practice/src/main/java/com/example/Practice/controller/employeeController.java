package com.example.Practice.controller;

import com.example.Practice.constants.ApiPath;
import com.example.Practice.dto.EmployeeDto;
import com.example.Practice.entity.Employee;
import com.example.Practice.repository.EmployeeRepository;
import com.example.Practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by prateek.srivastava
 **/

@RestController
@RequestMapping(path = "/EmployeeDto")
public class employeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(ApiPath.addEmployee)
    public String addEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.addEmployee(employeeDto);
    }
    @GetMapping(ApiPath.getEmployee)
    public Employee getEmployeeById(@RequestParam String employeeId){

        return employeeService.getEmployeeById(employeeId);

    }
    @PutMapping(ApiPath.updateEmployee)
    public String updateEmployeeById(@RequestBody EmployeeDto employeeDto){

         return employeeService.updateEmployeeById(employeeDto);
    }
    @DeleteMapping(ApiPath.deleteEmployee)
    public String deleteById(@RequestParam String employeeId){

        return employeeService.deleteById(employeeId);
    }

}
