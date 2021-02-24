package com.example.Sessiontwo.dto;


import com.example.Sessiontwo.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {



    private long id;
    private String name;
    private DepartmentResponseDTO department;
    private String code;


    public  void setDepartmentFromEntity(Department department)
    {
        DepartmentResponseDTO departmentResponseDTO=new DepartmentResponseDTO();
        departmentResponseDTO.setId(department.getId());
        departmentResponseDTO.setName(department.getName());
        this.department=departmentResponseDTO;
    }



}
