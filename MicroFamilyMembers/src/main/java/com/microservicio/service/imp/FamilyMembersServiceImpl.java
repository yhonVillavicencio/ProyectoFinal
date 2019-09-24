package com.microservicio.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.model.FamilyMembers;
import com.microservicio.repository.FamilyMembersRepository;
import com.microservicio.service.FamilyMembersService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class FamilyMembersServiceImpl implements FamilyMembersService{

	@Autowired
	private FamilyMembersRepository resp; // se inyecta el repositorio
	
	
	@Override
	public Flux<FamilyMembers> findAll() {
		return resp.findAll();
	}

	@Override
	public Mono<FamilyMembers> save(FamilyMembers familyMembersService) {
		return resp.save(familyMembersService);
	}

	@Override
	public Mono<FamilyMembers> findById(String id) {
		return resp.findById(id);
	}

	@Override
	public Mono<Void> delete(FamilyMembers familyMembers) {
		return resp.delete(familyMembers);
	}

	@Override
	public Flux<FamilyMembers> findBynombre(String nombre) {
		return resp.findBynombre(nombre);
	}

	@Override
	public Mono<FamilyMembers> findBynumeroIdentificacion(String numeroIdentificacion) {

		return resp.findBynumeroIdentificacion(numeroIdentificacion);
	}


}
