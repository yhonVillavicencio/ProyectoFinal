package com.micro.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.micro.model.Student;


import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String>{
	Mono<Student> findBynombre(String nombre);
	
}
