package com.example.Sessiontwo.services.impl;

import com.example.Sessiontwo.dto.DepartmentResponseDTO;
import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;
import com.example.Sessiontwo.entity.Department;
import com.example.Sessiontwo.entity.Employee;
import com.example.Sessiontwo.repository.DepartmentRepository;
import com.example.Sessiontwo.repository.EmployeeRepository;
import com.example.Sessiontwo.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


   // @Override
    /*
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDto) {
        Employee employee = new Employee();

        //copy fields from dto to employee
        BeanUtils.copyProperties(employeeRequestDto, employee);


        Optional<Department> departmentOptional=departmentRepository.findById(employeeRequestDto.getDepartment().getId());
        if(departmentOptional.isPresent())
        {
            employee.setDepartment(departmentOptional.get());
        }
        else
        {
            Department department=new Department();
            department.setName(employeeRequestDto.getDepartment().getName());
            employee.setDepartment(department);
        }



        //save employee to db
        Employee savedEmployee = employeeRepository.save(employee);

        // copy from employee to response dto
        EmployeeResponseDTO responseDto = new EmployeeResponseDTO();
        BeanUtils.copyProperties(savedEmployee, responseDto);


        DepartmentResponseDTO departmentResponseDTO=new DepartmentResponseDTO();
        departmentResponseDTO.setId(savedEmployee.getDepartment().getId());
        departmentResponseDTO.setName(savedEmployee.getDepartment().getName());


        return responseDto;
    }
    */

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDto) {
        Employee employee = new Employee();

        //copy fields from dto to employee
        BeanUtils.copyProperties(employeeRequestDto, employee);

        //fetch department from db
        Optional<Department> departmentOptional =
                departmentRepository.findById(employeeRequestDto.getDepartment().getId());
        if (departmentOptional.isPresent()){
            employee.setDepartment(departmentOptional.get());
        }else {
            Department department = new Department();
            department.setName(employeeRequestDto.getDepartment().getName());
            employee.setDepartment(department);
        }

        //save employee to db
        Employee savedEmployee = employeeRepository.save(employee);

        // copy from employee to response dto
        EmployeeResponseDTO responseDto = new EmployeeResponseDTO();
        BeanUtils.copyProperties(savedEmployee, responseDto);

        responseDto.setDepartmentFromEntity(employee.getDepartment());

        return responseDto;
    }





    @Override
    public EmployeeResponseDTO getEmployeeById(Long id)
    {
        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent())
        {


            EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeOptional.get(),responseDTO);

            return responseDTO;
        }
        return  null;

    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(Long id,EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee=new Employee();

        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent())
        {
            //update Employee
            Employee employeeFromDb=employeeOptional.get();
            employeeFromDb.setName(employeeRequestDTO.getName());
            //fetch Department from Db

            Optional<Department> departmentOptional=departmentRepository.findById(employeeRequestDTO.getDepartment().getId());
            if(departmentOptional.isPresent())
            {
                employeeFromDb.setDepartment(departmentOptional.get());
            }
            else
            {
                Department department=new Department();
                department.setName(employeeRequestDTO.getDepartment().getName());
                employee.setDepartment(department);
            }

            Employee savedEmployee=employeeRepository.save(employeeFromDb);


            EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
            BeanUtils.copyProperties(savedEmployee,responseDTO);
            responseDTO.setDepartmentFromEntity(savedEmployee.getDepartment());

            return responseDTO;
        }
        return null;

    }


    @Override
    public  EmployeeResponseDTO deleteById(Long id)
    {
        Optional<Employee> employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent())
        {
            //update Employee
           // Employee employeeFromDb=employeeOptional.get();
            employeeRepository.deleteById(id);

            EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
            BeanUtils.copyProperties(employeeOptional.get(),responseDTO);

            return responseDTO;
        }
        return null;

    }

    @Override
    public List<EmployeeResponseDTO> getEmployeeListByDepartment(Long departmentId) {
        //Department department = departmentRepository.findById(departmentId).get();
       // List<Employee> employeeList = employeeRepository.findByDepartment(department);

      //  List<Employee> employeeList=employeeRepository.findByDepartment_Id(departmentId);

        List<Employee> employeeList=employeeRepository.getEmployeeListByNativeQuery(departmentId);
        List<EmployeeResponseDTO> employeeResponseDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeResponseDTO responseDto = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee, responseDto);
            responseDto.setDepartmentFromEntity(employee.getDepartment());
            employeeResponseDtoList.add(responseDto);
        }
        return employeeResponseDtoList;
    }
}