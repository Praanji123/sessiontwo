package com.example.Sessiontwo.services;

import com.example.Sessiontwo.dto.DepartmentRequestDTO;
import com.example.Sessiontwo.dto.DepartmentResponseDTO;
import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;
import com.example.Sessiontwo.entity.Department;

public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);

    Department getDepartmentById(Long id);
}
