package com.micro.service;

import com.micro.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

	public Flux<Student> findAll();
	
	public Mono<Student> save(Student student);
	
	public Mono<Student> findById(String id);
	
	public Mono<Student> findBynombre(String nombre);
	public Mono<Void> delete(Student student);
}
