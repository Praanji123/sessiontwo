package com.example.Sessiontwo.services;

import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;

public interface EmployeeService {


    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDto);

    EmployeeResponseDTO getEmployeeById(Long id);
}