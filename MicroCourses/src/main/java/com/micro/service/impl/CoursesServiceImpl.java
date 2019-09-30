package com.micro.service.impl;

import com.micro.model.Courses;
import com.micro.repository.CoursesRepository;
import com.micro.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoursesServiceImpl implements CoursesService {
  @Autowired
  private CoursesRepository serv;

  @Override
  public Flux<Courses> findAll() {
    return serv.findAll();
  }

  @Override
  public Mono<Courses> save(Courses courses) {
    return serv.save(courses);
  }
  
  @Override
  public Mono<Void> delete(Courses courses) {
    return serv.delete(courses);
  }

  @Override
  public Mono<Courses> findById(String id) {
    return serv.findById(id);
  }

}
