package com.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.model.Teachers;
import com.micro.repository.TeachersRepository;
import com.micro.service.TeachersService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeachersServiceImpl implements TeachersService{

	@Autowired
	private TeachersRepository serv;
	
	@Override
	public Flux<Teachers> findAll() {
		return serv.findAll();
	}

	@Override
	public Mono<Teachers> save(Teachers teachers) {
		return serv.save(teachers);
	}

	@Override
	public Mono<Void> delete(Teachers teachers) {
		return serv.delete(teachers);
	}

	@Override
	public Mono<Teachers> findById(String id) {
		return serv.findById(id);
	}

}
