package com.example.Sessiontwo.repository;

import com.example.Sessiontwo.entity.Department;
import com.example.Sessiontwo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {



    //By Method name
    List<Employee> findByDepartment(Department department);

    List<Employee> findByDepartment_Id(Long departmentId);



    //By @Query Notation

   @Query("SELECT e FROM Employee e WHERE e.department.id =?1")
    List<Employee> getEmployeeListByDepartMentId(Long departmentId);

    //By native Query

    @Query(value="SELECT * FROM employee e WHERE e.department_id=?1",nativeQuery = true)
    List<Employee>  getEmployeeListByNativeQuery(Long departmentId);



}
