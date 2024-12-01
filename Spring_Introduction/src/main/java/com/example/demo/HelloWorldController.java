package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// @RestController = Controller + ResponseBody

public class HelloWorldController {
     
	@RequestMapping(value = "/test")
	public String test() {
		return "Test API is working fine!";
	}
}
