package com.micro.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.Student;
import com.micro.repository.StudentRepository;
import com.micro.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository resp;

	@Override
	public Flux<Student> findAll() {
		return resp.findAll();
	}
	
	@Override
	public Flux<Student> findByBirthdateBetween(Date birthdate, Date birthdate1) {
		return resp.findByBirthdateBetween(birthdate, birthdate1);
	}

	@Override
	public Mono<Student> save(Student student) {
		return resp.save(student);
	}

	@Override
	public Mono<Student> findById(String id) {
		return resp.findById(id);
	}

	@Override
	public Mono<Student> findBynombre(String nombre) {
		return resp.findBynombre(nombre);
	}

	@Override
	public Mono<Void> delete(Student student) {
		return resp.delete(student);
	}

	@Override
	public Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion) {
		return resp.findBynumeroIdentificacion(numeroIdentificacion);
	}

}
