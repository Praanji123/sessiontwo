package com.example.Practice.templateRepository.impl;

import com.example.Practice.entity.Employee;
import com.example.Practice.templateRepository.EmployeeQueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by prateek.srivastava
 **/

@Repository
public class EmployeeQueryDaoImpl implements EmployeeQueryDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Employee> getAll() {
        System.out.println("Inside Employee Query DAO Impl's get()");
        return mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(employeeId));

        return mongoTemplate.findOne(query, Employee.class);
    }

    @Override
    public List<Employee> getEmployeeBySalaryGreaterThan(double salary) {

        Query query = new Query();
        query.addCriteria(Criteria.where("employeeSalary").gt(salary));
        query.with(Sort.by(Sort.Direction.ASC, "employeeName"));
        return mongoTemplate.find(query, Employee.class);
    }



}
