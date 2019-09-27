package com.microservicio;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservicio.model.FamilyMembers;
import com.microservicio.repository.FamilyMembersRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MicroservicioFamilyMembersApplicationTests {
	
	@Mock
	private FamilyMembersRepository serv;
  @Test
  public void findAll() {
	  FamilyMembers fm= new FamilyMembers();  
	  fm.setTipoIdentificacion("DNI");
	  fm.setNumeroIdentificacion("73226940");
	  fm.setNombre("YHON");
	  fm.setCodigoStudent("0001");
	  fm.setGenero("MASCULINO");
	  fm.setTipoFamiliar("PADRE");
	  when(serv.findAll()).thenReturn(Flux.just(fm));
	    Flux<FamilyMembers> actual = serv.findAll();
	    assertResults(actual, fm);

  }
  
  private void assertResults(Publisher<FamilyMembers> publisher, FamilyMembers... expectedFamilyMembers) {
	    StepVerifier
	      .create(publisher)
	      .expectNext(expectedFamilyMembers)
	      .verifyComplete();
	  }
  
  
  
}
