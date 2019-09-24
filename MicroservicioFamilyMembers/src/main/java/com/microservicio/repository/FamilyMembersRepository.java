package com.microservicio.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservicio.model.FamilyMembers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyMembersRepository extends ReactiveMongoRepository<FamilyMembers, String>{ 
	
	 Flux<FamilyMembers> findBynombre(String nombre);
	  
	 Mono<FamilyMembers> findBynumeroIdentificacion(String numeroIdentificacion);
	

}
