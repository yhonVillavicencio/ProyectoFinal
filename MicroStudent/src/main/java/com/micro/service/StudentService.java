package com.micro.service;

import com.micro.model.Student;
import java.util.Date;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

  public Flux<Student> findAll();
  
  public Flux<Student> findByBirthdateBetween(Date birthdate, Date birthdate1);
  
  public Mono<Student> save(Student student);
  
  public Mono<Student> findById(String id);
  
  public Mono<Student> findBynombre(String nombre);
  
  public Mono<Void> delete(Student student);
  
  public Mono<Student> findBynumeroIdentificacion(String numeroIdentificacion);

}
