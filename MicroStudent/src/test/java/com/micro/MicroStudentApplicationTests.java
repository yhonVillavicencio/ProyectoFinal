package com.micro;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.micro.model.Student;
import com.micro.repository.StudentRepository;

import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MicroStudentApplicationTests {

	
	@Autowired
	private WebTestClient client;
	
	@Autowired
	private StudentRepository servi;
	
	@Test
	public void listar() {
		
		client.get()
		.uri("/api/v2/st")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Student.class)
		.hasSize(2);
	}

	@Test
	public void BuscarPorNombre() {
		
		Student student = servi.findBynombre("YHONManuel").block();
		client.get()
		.uri("/api/v2/st/{id}", Collections.singletonMap("id",student.getCodigoStudent()))
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.codigoStudent").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("YHONManuel");
		
	}
	
	@Test
	public void Crear() {
		
		Student student = new Student("DNI","12345613","prueba");
		
		client.post()
		.uri("/api/v2/st")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(student), Student.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$student.codigoStudent").isNotEmpty()
		.jsonPath("$student.tipoIdentificacion").isEqualTo("DNI");	
		
	} 
	
	@Test
	public void editarTest() {
		
		Student student = servi.findBynombre("123").block();

		Student studentEditado = new Student("DNI","manuel","12345678");
		
		client.put().
		uri("/api/v2/st/{id}", Collections.singletonMap("id", student.getCodigoStudent()))
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(studentEditado), Student.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.codigoStudent").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("manuel");
		
	}
	@Test
	public void eliminarTest() {
		Student student = servi.findBynombre("prueba").block();
		client.delete()
		.uri("/api/v2/st/{id}", Collections.singletonMap("id", student.getCodigoStudent()))
		.exchange()
		.expectStatus().isNoContent()
		.expectBody()
		.isEmpty();
		
		client.get()
		.uri("/api/v2/st/{id}", Collections.singletonMap("id", student.getCodigoStudent()))
		.exchange()
		.expectStatus().isNotFound()
		.expectBody()
		.isEmpty();
	}
	
	}
	
