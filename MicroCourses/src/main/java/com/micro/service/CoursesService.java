package com.micro.service;

import com.micro.model.Courses;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursesService {
	
	public Mono<Courses> obtenerPorCodigoDeCursos(String codigoCurso);
	 public Flux<Courses> findAll();
}
