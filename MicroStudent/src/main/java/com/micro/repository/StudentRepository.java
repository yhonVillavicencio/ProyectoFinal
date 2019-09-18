package com.micro.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.micro.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveMongoRepository<Student, String>{
	Mono<Student> findBynombre(String nombre);
	Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion);
	Flux<Student> findByBirthdateBetween(Date birthdate,Date birthdate1);
	

}
