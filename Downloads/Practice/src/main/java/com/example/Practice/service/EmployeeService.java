package com.example.Practice.service;

import com.example.Practice.dto.EmployeeDto;
import com.example.Practice.entity.Employee;

import java.util.Optional;

/**
 * Created by prateek.srivastava
 **/
public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(String employeeId);
    String updateEmployeeById(EmployeeDto employeeDto);
    String deleteById(String employeeId);

}
