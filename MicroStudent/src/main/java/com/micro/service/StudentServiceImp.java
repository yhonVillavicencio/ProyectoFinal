package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.micro.model.Student;
import com.micro.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository resp;

	@Override
	public Flux<Student> findAll() {
		// TODO Auto-generated method stub
		return resp.findAll();
	}

	@Override
	public Mono<Student> save(Student student) {
		// TODO Auto-generated method stub
		return resp.save(student);
	}

	@Override
	public Mono<Student> findById(String id) {
		// TODO Auto-generated method stub
		return resp.findById(id);
	}

	@Override
	public Mono<Student> findBynombre(String nombre) {
		// TODO Auto-generated method stub
		return resp.findBynombre(nombre);
	}

	@Override
	public Mono<Void> delete(Student student) {
		// TODO Auto-generated method stub
		return resp.delete(student);
	}

}
