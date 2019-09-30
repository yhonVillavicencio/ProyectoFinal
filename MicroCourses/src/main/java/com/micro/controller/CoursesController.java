package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.Courses;
import com.micro.model.Evaluaciones;
import com.micro.service.CoursesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CoursesController {
	
	@Autowired
	private CoursesService serv;
	
	  @GetMapping("/st")
	  public Flux<Courses> listar() {
	    return serv.findAll();
	  }
	
	@GetMapping("/st/codigo/{codigo}")
	  public Mono<Courses> findBynombre(@RequestBody Courses c, Evaluaciones e  ,@PathVariable("codigo") String codigo) {

	    return serv.obtenerPorCodigoDeCursos(codigo).flatMap(p ->{
	    p.setCodigoCurso(c.getCodigoCurso());
	    p.setNombreCurso(c.getNombreCurso());
	    p.setNumeroIdentificacionStudent(c.getNumeroIdentificacionStudent());
	    p.setNumeroIdentificacionTeacher(c.getNumeroIdentificacionTeacher());
	    p.setCodigoCurso(e.getCodigoCurso());
	    p.setNumeroIdentificacionStudent(e.getNumeroIdentificacionStudent());
	     return serv.obtenerPorCodigoDeCursos(codigo);
	    });
	    
	    
	    
	  }

}
