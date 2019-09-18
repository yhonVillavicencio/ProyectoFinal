package com.micro;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
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
		 .consumeWith(response -> {
	           List<Student> students = response.getResponseBody();
	           students.forEach(s -> {
	             System.out.println(s.getNombre() + " - " + s.getCodigoStudent());
	           });
	           Assertions.assertThat(students.size() > 0).isTrue();
	         });
	}

	@Test
	public void BuscarPorNombre() {
		
		Student student = servi.findBynombre("brigido").block();
		client.get()
		.uri("/api/v2/st/{id}", Collections.singletonMap("id",student.getCodigoStudent()))
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.codigoStudent").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("brigido");
		
	}

	@Test
	public void Crear() {
		
		Student student = new Student("DNI","12345611","aaaaff","Masculino",new Date(),2);
		client.post()
		.uri("/api/v2/st")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(student), Student.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.codigoStudent").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("aaaaff");	
		
	} 
	
	
	@Test
	public void editarTest() {
		
		Student student = servi.findBynumeroIdentificacion("12345610").block();

		Student studentEditado = new Student("DNI","73226940","gaa","Masculino",new Date(),2);
		
		client.put().
		uri("/api/v2/st/{id}", Collections.singletonMap("id", student.getCodigoStudent()))
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(studentEditado), Student.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.codigoStudent").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("gaa");
		
	}


	@Test
	public void eliminarTest() {
		Student student = servi.findBynumeroIdentificacion("12345678").block();
		client.delete()
		.uri("/api/v2/st/{id}", Collections.singletonMap("id", student.getCodigoStudent()))
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.isEmpty();
		
	} 
	
	

	}
	
