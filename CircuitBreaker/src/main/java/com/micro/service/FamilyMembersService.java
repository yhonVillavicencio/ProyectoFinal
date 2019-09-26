package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FamilyMembersService {
	
	@Autowired
	  private RestTemplate restTemplate;
	
	
	 @HystrixCommand(fallbackMethod =  "callFamilyMembersApplication_Fallback")
	  public String callFamilyMembersApplication() {
	    System.out.println("Fetching FamilyMembers Information");
	    
	    String response = restTemplate
	        .exchange("http://localhost:8081/spring-family/api/v2/fm", HttpMethod.GET
	        ,null,new ParameterizedTypeReference<String> () {},"").getBody();
	    
	    System.out.println("Response Received from FamilyMembers Application");
	    return "NORMAL CALL Successful" + "FamilyMembers Details: " + response;
	  }
	  
	  @SuppressWarnings("unused")
	  private String callFamilyMembersApplication_Fallback() {
	    System.out.println("FamilyMembers Application is down!  Fallback enabled!");
	    return "CIRCUIT BREAKER ENABLED!!  No response from FamilyMembers Application at this time";
	  }
	
	

}
