package com.example.Practice.templateRepository;

import com.example.Practice.entity.Employee;

import java.util.List;

/**
 * Created by prateek.srivastava
 **/
public interface EmployeeQueryDao {

    List<Employee> getAll();
    Employee getEmployeeById(String employeeId);
    List<Employee> getEmployeeBySalaryGreaterThan(double salary);

}
