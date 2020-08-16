package com.practice.vvr.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/register")
public class RegistrationController {
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm() {
		return "RegistrationForm";
	}
	
}
