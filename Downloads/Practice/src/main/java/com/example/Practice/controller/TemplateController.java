package com.example.Practice.controller;

import com.example.Practice.constants.ApiPath;
import com.example.Practice.entity.Employee;
import com.example.Practice.templateRepository.EmployeeQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prateek.srivastava
 **/
@RestController
@RequestMapping(path = "/Template")
public class TemplateController {

    @Autowired
    private EmployeeQueryDao employeeQueryDao;

    @GetMapping(ApiPath.getAll)
    public List<Employee> getAllEmployee(){

        return employeeQueryDao.getAll();
    }

    @GetMapping(ApiPath.getEmployee)
    public Employee getEmployeeById(@RequestParam String employeeId){
        return employeeQueryDao.getEmployeeById(employeeId);
    }

    @GetMapping(ApiPath.getSalary)
    public List<Employee> getEmployeeSalarygreaterthan(double salary){
        return employeeQueryDao.getEmployeeBySalaryGreaterThan(salary);
    }


}
