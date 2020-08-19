package com.practice.vvr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.vvr.entity.User;
import com.practice.vvr.service.UserService;
import com.practice.vvr.user.UserDetails;

@Component
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		
		theModel.addAttribute("userDetails", new UserDetails());
		
		return "RegistrationForm";
	}
	
//	@GetMapping("/showRedirectedHomePage")
//	public String showRedirectedHomePage(RedirectAttributes redirectAttributes) {
//		
//		redirectAttributes.addFlashAttribute("registerMessage", "Sign Up Successful!");
//		
//		return "redirect:/showLoginPage";
//	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistartionForm(RedirectAttributes redirectAttributes, 
										  @Valid @ModelAttribute("userDetails") UserDetails theUserDetails,
										  Model theModel) {
		
		User user = userService.findUserByemail(theUserDetails.getEmail());
		
		if(user != null) {
			theModel.addAttribute("userDetails", new UserDetails());
			theModel.addAttribute("registrationError", "User already exists");
			return "RegistrationForm";
		}
		
		userService.save(theUserDetails);
		
		theModel.addAttribute("registartionMessage", "Successfully registered. Signin to start!!");
		
		return "redirect:/showLoginPage";
	}
	
}
