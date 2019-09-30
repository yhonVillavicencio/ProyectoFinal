package com.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.Courses;
import com.micro.repository.CoursesRepository;
import com.micro.service.CoursesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoursesServiceImpl implements CoursesService{
	
	@Autowired
	private CoursesRepository serv;

	@Override
	public Mono<Courses> obtenerPorCodigoDeCursos(String codigoCurso) {
		return serv.obtenerPorCodigoDeCursos(codigoCurso);
	}

	@Override
	public Flux<Courses> findAll() {
		// TODO Auto-generated method stub
		return serv.findAll();
	}

}
