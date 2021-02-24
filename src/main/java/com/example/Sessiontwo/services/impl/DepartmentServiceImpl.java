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

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


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


    @Override
    public Department getDepartmentById(Long id)
    {
        return  departmentRepository.findById(id).get();
    }

    @Override
    @Transactional

    public DepartmentResponseDTO updateDepartment(Long departmentId,DepartmentRequestDTO departmentRequestDTO)
    {

        Department department=departmentRepository.findById(departmentId).get();
        List<Employee> employeeList=employeeRepository.findByDepartment_Id(departmentId);

        //update Department
        department.setName(departmentRequestDTO.getName());
        Department savedDepartment =departmentRepository.save(department);




        employeeList.forEach(employee -> {employee.setCode(departmentRequestDTO.getDepartmentCode());});
        employeeRepository.saveAll(employeeList);


        //append departmentCode to employee Code



        return  null;


    }





}
