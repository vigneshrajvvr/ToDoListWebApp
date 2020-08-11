package com.practice.vvr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "LoginPage";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "accessDenied";
	}
	
}
