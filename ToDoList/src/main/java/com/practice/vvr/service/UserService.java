package com.practice.vvr.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.practice.vvr.entity.User;
import com.practice.vvr.user.UserDetails;

public interface UserService extends UserDetailsService {
	
	void save(UserDetails userDetails);
	
	User findUserByemail(String email);
	
}
