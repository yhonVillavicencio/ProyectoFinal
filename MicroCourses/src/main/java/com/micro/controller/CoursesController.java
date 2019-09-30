package com.micro.controller;

import com.micro.model.Courses;
import com.micro.service.CoursesService;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CoursesController {
  @Autowired
  private CoursesService serv;
  
  @GetMapping("/cs")
  public Flux<Courses> listar() {
    return serv.findAll();
  }
  
  @PostMapping("/cs")
  public Mono<Courses> crear(@Valid @RequestBody Courses courses) {
    return serv.save(courses);
  }
  
  //Find id
  @GetMapping("cs/{id}")
  public Mono<Courses> ver(@PathVariable String id) {
    return serv.findById(id);
  }
  
  /**
    *  modificar.
    */
  
  @PutMapping("/cs/{id}")
  public Mono<Courses> edit(@Valid @RequestBody Courses courses,@PathVariable String id) {
    return serv.findById(id).flatMap(s -> {
      s.setNombreCurso(courses.getNombreCurso());
      s.setNumeroIdentificacionStudent(courses.getNumeroIdentificacionStudent());
      s.setNumeroIdentificacionTeacher(courses.getNumeroIdentificacionTeacher());
      s.setEstadoCurso(courses.getEstadoCurso());
      s.setCantidadEstudiante(courses.getCantidadEstudiante());
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
