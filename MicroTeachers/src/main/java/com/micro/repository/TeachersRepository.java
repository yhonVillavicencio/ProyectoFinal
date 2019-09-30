package com.micro.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.micro.model.Teachers;

public interface TeachersRepository extends ReactiveMongoRepository<Teachers, String>{

}
