package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

	@RequestMapping("/test")

	public String test() {
		return "Test API Works!";
	}
	// 3 ways to pass request
	// 1. Request Body
	// 2. Path Variable
	// 3. Request Param

	@RequestMapping("/profile/{name}")
	public String pathExample(@PathVariable String name) {
		return "Hello " + name;
	}
         
	@RequestMapping("/profile/{id}/{name}")
	public String pathExample1(@PathVariable String name, @PathVariable int id) {
		return "User " + name + " created with id: " + id;
		
	}
	// localhost:8080/profile?name = saurav
	// localhost:8080/<PathVariable> ? <RequestParam> & <RequestParam> 
	
	@RequestMapping("/")
	public String queryParamExample(@RequestParam String name) {
		return "Hello " + name;
	}
	

}
