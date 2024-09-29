package com.app.servicesImp;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.app.dtos.JwtAuthenticationRequest;
import com.app.dtos.LoginRequest;
import com.app.dtos.RefreshTokenRequest;
import com.app.entities.User;
import com.app.repositories.UserRepository;
import com.app.services.AuthenticationService;


@Service
public class AuthenticationServiceImp implements AuthenticationService{
	
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImp.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTServiceImp jwtService;
    
    @Override
    public JwtAuthenticationRequest login(LoginRequest loginRequest) { 
    	
        logger.info("Attempting to authenticate user with email: {}", loginRequest.getUsername());
        
        try { 
        	
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            logger.info("Authentication successful for user with email: {}", loginRequest.getUsername());
            
        } catch (Exception e) {
        	
            logger.error("Authentication failed for user with email: {}. Error: {}", loginRequest.getUsername(), e.getMessage());
            throw new IllegalArgumentException("Invalid Email or Password");
            
        }

        User user = userRepository.findByUsername(loginRequest.getUsername())
                                  .orElseThrow(() -> new IllegalArgumentException("User not found"));
        logger.debug("User found with email: {}. Generating JWT token.", loginRequest.getUsername());

        String jwt = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        logger.info("JWT token and refresh token generated for user with email: {}", loginRequest.getUsername());

        JwtAuthenticationRequest jwtAuthResponse = new JwtAuthenticationRequest();
        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);
        jwtAuthResponse.setUser(user);
        return jwtAuthResponse;
        
    }

    @Override
    public JwtAuthenticationRequest refreshToken(RefreshTokenRequest refreshTokenRequest) {
    	
        logger.info("Attempting to refresh token for token: {}", refreshTokenRequest.getToken());
        
        String username = jwtService.extractUsername(refreshTokenRequest.getToken());
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(() -> new IllegalArgumentException("User not found"));
        logger.debug("User found for email: {}. Validating refresh token.", username);
        
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            String newToken = jwtService.generateToken(user);
            logger.info("New JWT token generated for user with email: {}", username);
            JwtAuthenticationRequest jwtAuthResponse = new JwtAuthenticationRequest();
            jwtAuthResponse.setToken(newToken);
            jwtAuthResponse.setRefreshToken(refreshTokenRequest.getToken());
            jwtAuthResponse.setUser(user);
            return jwtAuthResponse;
            
        } else {
        	
            logger.error("Invalid or expired refresh token for user with email: {}", username);
            throw new IllegalArgumentException("Invalid or expired refresh token");
            
        }
    }
    
}
