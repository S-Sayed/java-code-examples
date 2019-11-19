package com.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet")
public class GreetingController {

	@GetMapping
	public String greet() {
		return "Hello, The request has been served without authentication";
	}

	@GetMapping("/{name}")
	public String greet(@PathVariable(name = "name") String name) {
		String reply = "Hello %s, The request has been served after authentication";
		return String.format(reply, name);
	}
}
