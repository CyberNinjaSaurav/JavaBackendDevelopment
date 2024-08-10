package com.example.demo.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.Post.model.StudentPostRequestModel;
import com.example.demo.Post.model.StudentPostResponseModel;

@RestController

@RequestMapping("/student")
public class StudentController {
	
	@GetMapping("/test")
	public String test() {
		return "Test API works";
		
	}
	
	@PostMapping("/create")
	
	public StudentPostResponseModel createStudent(@RequestBody StudentPostRequestModel requestModel) {
		 
		Student s = new Student(101, requestModel.getName(), requestModel.getRoll());
		StudentPostResponseModel response = new StudentPostResponseModel(s.getId(), s.getName(), s.getRoll());
	     
		return response;
	}

}
