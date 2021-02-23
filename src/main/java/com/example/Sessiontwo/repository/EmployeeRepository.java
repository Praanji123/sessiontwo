package com.example.Sessiontwo.repository;

import com.example.Sessiontwo.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {


}
