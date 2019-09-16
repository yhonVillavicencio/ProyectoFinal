package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
@EnableSwagger2WebFlux
@SpringBootApplication
public class MicroStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroStudentApplication.class, args);
	}

}
