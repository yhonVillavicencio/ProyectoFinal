package com.micro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.FamilyMembersService;

@RestController
public class FamilyMembersDataController {
	
	
	 @Autowired
	  FamilyMembersService familyService;
	
	 @GetMapping(value="/getFamilyMembersInfo")
	  public String getFamilyMembers() {
	    System.out.println("Making a call to students application");
	    return familyService.callFamilyMembersApplication();
	  }
	

}
