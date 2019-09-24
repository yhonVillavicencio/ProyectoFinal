package com.microservicio.service;


import com.microservicio.model.FamilyMembers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FamilyMembersService {
	
	public Flux<FamilyMembers> findAll();
	
	public Mono<FamilyMembers> save(FamilyMembers familyMembers);
	
	public Mono<FamilyMembers> findById(String id);
	
	public Mono<Void> delete(FamilyMembers familyMembers);
	
	public Flux<FamilyMembers> findBynombre(String nombre);
	  
	public Mono<FamilyMembers> findBynumeroIdentificacion(String numeroIdentificacion);
	
	
}
