package com.microservicio.controller;

import com.microservicio.model.FamilyMembers;
import com.microservicio.repository.FamilyMembersRepository;
import com.microservicio.service.FamilyMembersService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v2")//ruta principal
public class FamilyMembersController {
  @Autowired
  private FamilyMembersService servicio;
  
  @GetMapping("/fm")
  public Flux<FamilyMembers> listar() {
    return servicio.findAll();
  }
  
  @PostMapping("/fm")
  public Mono<FamilyMembers> crear(@Valid @RequestBody FamilyMembers familyMembers) {
    return servicio.save(familyMembers);
  }
  //Busca id
  
  @GetMapping("/fm/{id}")
  public Mono<FamilyMembers> ver(@PathVariable String id) {
    return servicio.findById(id);
 
  }
  // Busca Por Numero de Identificacion
  
  @GetMapping("/fm/numberId/{numeroIdentificacion}")
  public Mono<FamilyMembers> dni(@PathVariable("numeroIdentificacion") String numeroIdentificacion) {
    return servicio.findBynumeroIdentificacion(numeroIdentificacion);
  }
  // Busca por nombres
  
  @GetMapping("/fm/name/{nombre}")
  public Flux<FamilyMembers> findBynombre(@PathVariable("nombre") String nombre) {
    return servicio.findBynombre(nombre);
  }
  	
  //Busca por id y acctualiza
  
  @PutMapping("/fm/{id}")
  public Mono<FamilyMembers> edi(@Valid @RequestBody FamilyMembers familyMembers,@PathVariable String id) {
    return servicio.findById(id).flatMap(s -> {
      s.setTipoIdentificacion(familyMembers.getTipoIdentificacion());
      s.setNumeroIdentificacion(familyMembers.getNumeroIdentificacion());
      s.setNombre(familyMembers.getNombre());
      s.setGenero(familyMembers.getGenero());
      s.setCodigoStudent(familyMembers.getCodigoStudent());
      s.setTipoFamiliar(familyMembers.getTipoFamiliar());
      return servicio.save(s);
    });
  }
  // Elimina por id
  
  @DeleteMapping("/fm/{id}")
  public Mono<Void> eliminar(@PathVariable String id) {
    return servicio.findById(id).flatMap(s -> {
      return servicio.delete(s);
    });
  }

}
