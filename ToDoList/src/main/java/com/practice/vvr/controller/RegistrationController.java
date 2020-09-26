package com.practice.vvr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.vvr.entity.User;
import com.practice.vvr.service.UserService;
import com.practice.vvr.user.UserDetails;

@Component
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
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
	public String processRegistartionForm(@Valid @ModelAttribute("userDetails") UserDetails theUserDetails,
										  BindingResult theBindingResult,
										  Model theModel) {
		
		User user = userService.findUserByemail(theUserDetails.getEmail());
		
		//form validation
		if(theBindingResult.hasErrors()) {
			return "RegistrationForm";
		}
		
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
