package com.micro.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.micro.model.Courses;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursesRepository extends ReactiveMongoRepository<Courses,String >{

	 
   
	public Mono<Courses> obtenerPorCodigoDeCursos(String codigoCurso);
}
