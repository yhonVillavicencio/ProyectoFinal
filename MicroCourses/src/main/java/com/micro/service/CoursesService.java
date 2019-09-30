package com.micro.service;

import com.micro.model.Courses;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursesService {
  public Flux<Courses> findAll();
  
  public Mono<Courses> save(Courses courses);
  
  public Mono<Void> delete(Courses courses);
  
  public Mono<Courses> findById(String id);
}
