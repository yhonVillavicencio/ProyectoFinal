package com.micro.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
import com.micro.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v2")
public class StudentController {
	
	@Autowired
	private StudentService serv;

	
	  @GetMapping("/st")
	  public Flux<Student> listar() {
	    return serv.findAll();	
	}
	  
	  @PostMapping("/st")
	  public Mono<Student> crear(@RequestBody Student student) {
			 return serv.save(student);
	  }

	//Busca id
	  
	  @GetMapping("st/{id}")
	  public Mono<Student> ver(@PathVariable String id) {
	    return serv.findById(id);
	  }
	  
	//buscar por numero de identificacion
		@GetMapping("/st/numberId/{numeroIdentificacion}")
		public Mono<Student> dni(@PathVariable("numeroIdentificacion") String numeroIdentificacion){
			return serv.findBynumeroIdentificacion(numeroIdentificacion);
		}
		
		//buscar por nombre
		@GetMapping("/st/name/{nombre}")
		public Mono<Student> findBynombre(@PathVariable("nombre") String nombre){
			return serv.findBynombre(nombre);
		}
		
		//buscar entre fechas de nacimiento
		  @GetMapping("/st/date/{birthdate}/{birthdate1}")
		  public Flux<Student> findByBirthdate(@PathVariable("birthdate")
		      @DateTimeFormat(iso = ISO.DATE) Date birthdate,@PathVariable("birthdate1")
		      @DateTimeFormat(iso = ISO.DATE) Date birthdate1) {
		    return serv.findByBirthdateBetween(birthdate, birthdate1);
		  }
		
	  @PutMapping("/st/{id}")
	  public Mono<Student> edit(@Valid @RequestBody Student student,@PathVariable String id) {
	    return serv.findById(id).flatMap(s -> {
	      s.setTipoIdentificacion(student.getTipoIdentificacion());
	      s.setNumeroIdentificacion(student.getNumeroIdentificacion());
	      s.setNombre(student.getNombre());
	      s.setGenero(student.getGenero());
	      s.setBirthdate(student.getBirthdate());
	      s.setNumeroPadres(student.getNumeroPadres());
	      return serv.save(s);
	    });
	  }
	  
	  @DeleteMapping("/st/{id}")
	  public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id") String id) {
		    return serv.findById(id)
		    .flatMap(existingStudent ->
		 serv.delete(existingStudent)
		 .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
		 .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		  }
			
	  }
