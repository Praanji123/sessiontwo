package com.example.Practice.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by prateek.srivastava
 **/
@Getter
@Setter
public class EmployeeDto {

    private String employeeId;
    private String employeeName;
    private double employeeSalary;
    private DepartmentDto department;
    private int employeeExperience;


}
