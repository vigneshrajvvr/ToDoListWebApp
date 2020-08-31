package com.practice.vvr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.vvr.dao.UserDao;
import com.practice.vvr.entity.User;
import com.practice.vvr.user.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void save(UserDetails userDetails) {

		User user = new User();

		user.setUsername(userDetails.getUsername());
		user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		user.setEmail(userDetails.getEmail());

		userDao.save(user);

	}

	@Override
	@Transactional
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return null;
	}

	@Override
	@Transactional
	public User findUserByemail(String email) {
		return userDao.findUserByEmail(email);
	}

}
