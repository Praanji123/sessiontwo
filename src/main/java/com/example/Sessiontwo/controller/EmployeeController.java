package com.example.Sessiontwo.controller;

import com.example.Sessiontwo.dto.EmployeeRequestDTO;
import com.example.Sessiontwo.dto.EmployeeResponseDTO;
import com.example.Sessiontwo.services.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //POST - /employee
    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDto) {

        return employeeService.createEmployee(employeeRequestDto);
    }


    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable("id") Long id)
    {
        return employeeService.getEmployeeById(id);
    }


    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        return employeeService.updateEmployeeById(id,employeeRequestDTO);
    }

    @DeleteMapping("/{id}")
    public EmployeeResponseDTO deleteById(@PathVariable("id") Long id)
    {

       return employeeService.deleteById(id);

    }


    //GET -/Employee/department/{id}
    @GetMapping("/department/{id}")
    public List<EmployeeResponseDTO> getEmployeeListByDepartMent(@PathVariable("id") Long DepartmentId)
    {
        return employeeService.getEmployeeListByDepartment(DepartmentId);
    }

    @GetMapping("/mostExperienced")
    public List<EmployeeResponseDTO> getEmployeeLis()
    {
        return employeeService.getEmployeewithMostExperince();
    }







}