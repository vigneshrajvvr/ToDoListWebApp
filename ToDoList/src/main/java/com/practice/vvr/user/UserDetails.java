package com.practice.vvr.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetails {
	
	@NotNull(message = "Cannot be null")
	@Size(min = 1, message = "Cannot be null" )
	private String username;
	
	@NotNull(message = "Cannot be null")
	@Size(min = 1, message = "Cannot be null" )
	private String email;
	
	@NotNull(message = "Cannot be null")
	@Size(min = 1, message = "Cannot be null" )
	private String password;
	
	@NotNull(message = "Cannot be null")
	@Size(min = 1, message = "Cannot be null" )
	private String matchingPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
}
