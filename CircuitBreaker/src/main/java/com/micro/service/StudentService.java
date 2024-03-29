package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentService {

	 @Autowired
	  private RestTemplate restTemplate;
	
	
	 @HystrixCommand(fallbackMethod =  "callStudentApplication_Fallback")
	  public String callStudentApplication() {
	    System.out.println("Fetching Student Information");
	    
	    String response = restTemplate
	        .exchange("http://localhost:8081/spring-student/api/st", HttpMethod.GET
	        ,null,new ParameterizedTypeReference<String> () {},"").getBody();
	    
	    System.out.println("Response Received from Student Application");
	    return "NORMAL CALL Successful" + "Student Details: " + response;
	  }
	  
	  @SuppressWarnings("unused")
	  private String callStudentApplication_Fallback() {
	    System.out.println("Student Application is down!  Fallback enabled!");
	    return "CIRCUIT BREAKER ENABLED!!  Por el momento no se encuentra disponible";
	  }
	
	
}
