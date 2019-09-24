package com.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@EnableSwagger2WebFlux
@SpringBootApplication
@EnableEurekaClient
public class MicroservicioFamilyMembersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioFamilyMembersApplication.class, args);
	}

}
