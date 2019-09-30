package com.micro.controller;

import javax.validation.Valid;

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

import com.micro.model.Teachers;
import com.micro.service.TeachersService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class TeachersController {
	
	@Autowired
	private TeachersService serv;
	
	@GetMapping("/tc")
	  public Flux<Teachers> listar() {
	    return serv.findAll();
	  }
	  
	  @PostMapping("/tc")
	  public Mono<Teachers> crear(@Valid @RequestBody Teachers teachers) {
	    return serv.save(teachers);
	  }
	  
	  //Find id
	  @GetMapping("tc/{id}")
	  public Mono<Teachers> ver(@PathVariable String id) {
	    return serv.findById(id);
	  }
	  
	  /**
	    *  modificar.
	    */
	  
	  @PutMapping("/tc/{id}")
	  public Mono<Teachers> edit(@Valid @RequestBody Teachers teachers,@PathVariable String id) {
	    return serv.findById(id).flatMap(s -> {
	      s.setTipoIdentificacion(teachers.getTipoIdentificacion());
	      s.setNumeroIdentificacion(teachers.getNumeroIdentificacion());
	      s.setNombre(teachers.getNombre());
	      s.setGenero(teachers.getGenero());
	      return serv.save(s);
	    });
	  }
	  /**
	  * eliminar.
	  */
	  
	  @DeleteMapping("/cs/{id}")
	  public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id") String id) {
	    return serv.findById(id)
	    .flatMap(existingStudent ->
	     serv.delete(existingStudent)
	    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
	    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	  }

}
