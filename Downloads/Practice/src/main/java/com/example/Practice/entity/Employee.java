package com.example.Practice.entity;

import com.example.Practice.dto.DepartmentDto;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by prateek.srivastava
 **/
@Data
@ToString
@Document(collection = "EmployeeService")
public class Employee {

    @Id
    private String employeeId;
    private String employeeName;
    private double employeeSalary;
    private DepartmentDto department;
    private int employeeExperience;

}
