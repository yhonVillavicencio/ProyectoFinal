package com.micro.service.impl;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micro.model.Student;
import com.micro.repository.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MicroStudentServiceImplTest {
	
	@Mock
	private StudentRepository resp;
	
	@InjectMocks
	private StudentServiceImpl imp;

	 @Test
	    public void findAll() {
	        Student student = new Student();
	        student.setTipoIdentificacion("DNI");
	        student.setNumeroIdentificacion("73226957");
	        student.setNombre("prueba05");
	        student.setGenero("Masculino");
	        student.setBirthdate(new Date());
	        student.setNumeroPadres(3);
	        when(imp.findAll()).thenReturn(Flux.just(student));
	        Flux<Student> actual = imp.findAll();
	        assertResults(actual, student);
	    }

	 private void assertResults(Publisher<Student> publisher, Student... expectedProducts) {
	        StepVerifier
	            .create(publisher)
	            .expectNext(expectedProducts)
	            .verifyComplete();
	    }
	
	
	

}
