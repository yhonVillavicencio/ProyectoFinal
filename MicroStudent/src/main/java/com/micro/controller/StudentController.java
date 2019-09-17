package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.model.Student;
import com.micro.repository.StudentRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2")
public class StudentController {
	
	
	@Autowired
	private StudentRepository serv;
	
	  @GetMapping("/st")
	  public Flux<Student> listar() {
	    return serv.findAll();	
	}
	  
	  @PostMapping("/st")
	  public Mono<Student> crear(@RequestBody Student student) {
	    return serv.save(student);
	  }

	//Busca id
	  
	  @GetMapping("/st/{id}")
	  public Mono<Student> ver(@PathVariable String id) {
	    return serv.findById(id);
	  }
	  
	  @PutMapping("/st/{id}")
	  public Mono<Student> edit(@RequestBody Student student,@PathVariable String id) {
	    return serv.findById(id).flatMap(s -> {
	      s.setTipoIdentificacion(student.getTipoIdentificacion());
	      s.setNumeroIdentificacion(student.getNumeroIdentificacion());
	      s.setNombre(student.getNombre());
	      s.setGenero(student.getGenero());
	      s.setFechaNacimiento(student.getFechaNacimiento());
	      s.setNumeroPadres(student.getNumeroPadres());
	      return serv.save(s);
	    });
	  }
	  
	  @DeleteMapping("/st/{id}")
	  public Mono<Void> eliminar(@PathVariable String id) {
	    return serv.findById(id).flatMap(s -> {
	      return serv.delete(s);
	    });
	  }
			
	  
	  }
