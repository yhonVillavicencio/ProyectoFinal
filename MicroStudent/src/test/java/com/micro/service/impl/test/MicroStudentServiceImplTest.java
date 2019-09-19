package com.micro.service.impl.test;

import static org.mockito.Mockito.when;

import com.micro.model.Student;

import com.micro.repository.StudentRepository;
import com.micro.service.impl.StudentServiceImpl;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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

  @Test
  public void findByDocument() {
    Student st2 = new Student();
    st2.setTipoIdentificacion("DNI");
    st2.setNumeroIdentificacion("73226957");
    st2.setNombre("prueba05");
    st2.setGenero("Masculino");
    st2.setBirthdate(new Date());
    st2.setNumeroPadres(3);
    final String dni = "73226957";
    when(imp.findBynumeroIdentificacion(dni)).thenReturn(Mono.just(st2));
    Mono<Student> actual = imp.findBynumeroIdentificacion(dni);
    assertResults(actual,st2);
  }
  
  @Test
  public void delete() {
    Student st2 = new Student();
    st2.setTipoIdentificacion("DNI");
    st2.setNumeroIdentificacion("73226957");
    st2.setNombre("prueba05");
    st2.setGenero("Masculino");
    st2.setBirthdate(new Date());
    st2.setNumeroPadres(3);
    when(imp.delete(st2)).thenReturn(Mono.empty());
  }
}
