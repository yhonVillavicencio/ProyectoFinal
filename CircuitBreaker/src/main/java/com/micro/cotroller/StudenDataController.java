package com.micro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.StudentService;

@RestController
public class StudenDataController {
	
	 @Autowired
	  StudentService studentService;
	
	 @GetMapping(value="/getStudentInfo")
	  public String getStudents() {
	    System.out.println("Making a call to students application");
	    return studentService.callStudentApplication();
	  }
	

}
