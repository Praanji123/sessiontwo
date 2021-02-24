package com.example.Sessiontwo.services.impl;

import com.example.Sessiontwo.dto.DepartmentRequestDTO;
import com.example.Sessiontwo.dto.DepartmentResponseDTO;
import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;
import com.example.Sessiontwo.entity.Department;
import com.example.Sessiontwo.entity.Employee;
import com.example.Sessiontwo.repository.DepartmentRepository;
import com.example.Sessiontwo.repository.EmployeeRepository;
import com.example.Sessiontwo.services.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDto) {
       Department department=new Department();

        //copy fields from dto to employee
        BeanUtils.copyProperties(departmentRequestDto,department);

        //save employee to db
        Department savedDepartment = departmentRepository.save(department);

        // copy from employee to response dto
        DepartmentResponseDTO responseDto = new DepartmentResponseDTO();
        BeanUtils.copyProperties(savedDepartment, responseDto);

        return responseDto;
    }



}
