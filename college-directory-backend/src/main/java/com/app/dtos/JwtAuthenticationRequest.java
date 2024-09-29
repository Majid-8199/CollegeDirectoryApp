package com.app.dtos;

import com.app.entities.User;

public class JwtAuthenticationRequest {

	private String token;
	private String refreshToken;
	private User user;
	
	public JwtAuthenticationRequest() {
	
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
