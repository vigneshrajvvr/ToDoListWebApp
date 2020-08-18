package com.practice.vvr.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
@RequestMapping("/register")
public class RegistrationController {
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm() {
		return "RegistrationForm";
	}
	
	@GetMapping("/showRedirectedHomePage")
	public String showRedirectedHomePage(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("registerMessage", "Sign Up Successful!");
		
		return "redirect:/showLoginPage";
	}
	
}
