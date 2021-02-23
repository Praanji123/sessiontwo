package com.example.Sessiontwo.entity;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.redis.core.RedisHash;


@RedisHash
@Getter
@Setter
public class Employee {


    @Id
    private Long id;

    private String name;

    private String departmentName;


}
