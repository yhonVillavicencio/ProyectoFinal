package com.microservicio.repository;

import com.microservicio.model.FamilyMembers;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyMembersRepository extends ReactiveMongoRepository<FamilyMembers, String> { 
  Flux<FamilyMembers> findBynombre(String nombre);
  
  Mono<FamilyMembers> findBynumeroIdentificacion(String numeroIdentificacion);

}
