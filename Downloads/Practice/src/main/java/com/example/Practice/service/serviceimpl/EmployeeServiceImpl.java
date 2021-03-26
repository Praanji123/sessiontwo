package com.example.Practice.service.serviceimpl;

import com.example.Practice.dto.EmployeeDto;
import com.example.Practice.entity.Employee;
import com.example.Practice.repository.EmployeeRepository;

import com.example.Practice.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by prateek.srivastava
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String addEmployee(EmployeeDto employeeDto){

        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeRepository.save(employee);
        return "inserted Successfully";

    }

    public Employee getEmployeeById(String employeeId){

        return employeeRepository.findByEmpId(employeeId);
    }

    public String updateEmployeeById(EmployeeDto employeeDto){

        Employee employee=employeeRepository.findByEmpId(employeeDto.getEmployeeId());
        BeanUtils.copyProperties(employeeDto,employee);
        employeeRepository.save(employee);
        return "Updated Successfully";
    }

    public String deleteById(String employeeId){
        employeeRepository.deleteById(employeeId);
        return "Deleted SuccessFully";

    }






}
