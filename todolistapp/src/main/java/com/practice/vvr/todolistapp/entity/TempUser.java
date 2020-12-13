package com.practice.vvr.todolistapp.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
/*
* This is temporary user to validate given
* inputs from the controller
*/
public class TempUser {
	
	private int userId;
	
	@NotNull(message="Username should not be empty")
	private String username;
	
	@NotNull(message="Password field cannot be empty")
	private String password;
	
	@NotNull(message="Confirm Password field cannot be empty")
	private String confirmPassword;
	
	private String email;
	
	private int enabled;
	
	public TempUser() {
		
	}

	public TempUser(int userId, String username, String password, String confirmPassword, String email, int enabled) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.enabled = enabled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
