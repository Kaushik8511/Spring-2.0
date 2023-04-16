package com.jwt.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/")
	public String Home() {
		return "welcome to the jwt authentication!";
	}
	
}
