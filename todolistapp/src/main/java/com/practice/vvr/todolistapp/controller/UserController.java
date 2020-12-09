package com.practice.vvr.todolistapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.vvr.todolistapp.entity.User;

@Controller
@RequestMapping("/app")
public class UserController {
	
	@GetMapping("/register")
	public String registrationForm(Model userModel) {
		
		User theUser = new User();
		
		userModel.addAttribute("theUser", theUser);
		
		return "register";
		
	}
	

}
