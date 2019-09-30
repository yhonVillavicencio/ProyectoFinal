package com.micro.service;

import com.micro.model.Teachers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeachersService {
  public Flux<Teachers> findAll();
	  
  public Mono<Teachers> save(Teachers teachers);
	  
  public Mono<Void> delete(Teachers teachers);
	  
  public Mono<Teachers> findById(String id);	
	
}
