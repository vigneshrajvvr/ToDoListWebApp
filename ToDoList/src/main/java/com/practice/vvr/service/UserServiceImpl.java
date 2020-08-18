package com.practice.vvr.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.vvr.entity.User;
import com.practice.vvr.user.UserDetails;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void save(UserDetails userDetails) {
		
		User user = new User();
		
		user.setUsername(userDetails.getUsername());
		user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		user.setEmail(userDetails.getEmail());
		
		
	}

}
