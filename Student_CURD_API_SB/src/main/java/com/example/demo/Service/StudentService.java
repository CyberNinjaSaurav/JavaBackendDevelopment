package com.example.demo.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Model.StudentPostRequestModel;
import com.example.demo.Model.StudentPostResponseModel;

@Service

public class StudentService {
	
	HashMap<Integer, Student> studentHM;
	
	
	public StudentPostResponseModel create(StudentPostRequestModel request) {
		if(studentHM == null) {
			studentHM = new HashMap<Integer, Student>();
		}
		
		Student s = new Student(0, request.getEmail(), request.getName(), request.getPassword());
		s.setId(getRandomNumber());
	
	if(studentHM.containsKey(s.getId())) {
		s.setId(getRandomNumber());
	}
	
	studentHM.put(s.getId(), s);
	StudentPostResponseModel response = new StudentPostResponseModel(s.getId(), s.getName(), s.getEmail());
	return response;
	}
		
		
		private int getRandomNumber() {
			int min = 1, max = 10000;
			return (int) ((Math.random() * (max - min)) + min);
		}
	}

