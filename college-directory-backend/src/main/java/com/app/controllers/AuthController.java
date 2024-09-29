package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.JwtAuthenticationRequest;
import com.app.dtos.LoginRequest;
import com.app.dtos.RefreshTokenRequest;
import com.app.services.AuthenticationService;

@RestController
@RequestMapping("/api/all")
@CrossOrigin("${frontend.url}")
public class AuthController {
	
	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationRequest> login(@RequestBody LoginRequest loginRequest) throws IllegalAccessException{
		return ResponseEntity.ok(authenticationService.login(loginRequest));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<JwtAuthenticationRequest> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
		return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
	}
	
}
