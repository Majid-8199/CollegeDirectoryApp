package com.app.dtos;

public class LoginRequest {

	private String username;
	private String password;
	
	public LoginRequest() {
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
