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

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO) {

        return departmentService.createDepartment(departmentRequestDTO);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id)
    {
        return departmentService.getDepartmentById(id);
    }






}
