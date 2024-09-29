package com.app.services;

import com.app.dtos.JwtAuthenticationRequest;
import com.app.dtos.LoginRequest;
import com.app.dtos.RefreshTokenRequest;

public interface AuthenticationService {
	
	public JwtAuthenticationRequest login(LoginRequest loginRequest);
	
	public JwtAuthenticationRequest refreshToken(RefreshTokenRequest refreshTokenRequest);

}
