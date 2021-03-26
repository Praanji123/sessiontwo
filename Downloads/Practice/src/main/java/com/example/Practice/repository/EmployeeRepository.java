package com.example.Practice.repository;

import com.example.Practice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by prateek.srivastava
 **/
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    @Query(value = "{_id : ?0}")
    Employee findByEmpId(String employeeId);



}
