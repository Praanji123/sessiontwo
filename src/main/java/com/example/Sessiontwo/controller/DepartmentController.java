package com.example.Sessiontwo.controller;


import com.example.Sessiontwo.dto.DepartmentRequestDTO;
import com.example.Sessiontwo.dto.DepartmentResponseDTO;
import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;
import com.example.Sessiontwo.entity.Department;
import com.example.Sessiontwo.services.DepartmentService;
import com.example.Sessiontwo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO) {

        return departmentService.createDepartment(departmentRequestDTO);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id)
    {
        return departmentService.getDepartmentById(id);
    }


    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentRequestDTO departmentRequestDTO)
    {
        return departmentService.updateDepartment(departmentId,departmentRequestDTO);
    }

    @GetMapping("/{id}/employee/mostexperienced")
    public List<EmployeeResponseDTO> getEmployeewithmostExperienceinDepartment(@PathVariable("id") Long departmentId)
    {
        return  employeeService.getEmployeewithMostExperinceinDepartment(departmentId);
    }







}
