package com.practice.vvr.todolistapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.vvr.todolistapp.entity.TempUser;

@Controller
@RequestMapping("/app") 
public class UserController {
	
	@GetMapping("/register")
	public String registrationForm(Model userModel) {
		
		TempUser theTempUser = new TempUser();
		
		userModel.addAttribute("theTempUser", theTempUser); 
		
		return "register";
		
	}
	
	@PostMapping("/processUserForm")
	public String processRegistrationForm(@Valid @ModelAttribute("theTempUser") TempUser tempUserModel,
			                              BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		if(!tempUserModel.getPassword().equals(tempUserModel.getConfirmPassword())) {
			return "register"; 
		}
		
		
		return "register";
	}
	

}
