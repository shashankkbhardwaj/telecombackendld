package com.telecom.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.userservice.entities.AuthRequest;
import com.telecom.userservice.services.JwtService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AuthController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;


	
	@PostMapping("/authenticate")
	@CrossOrigin("http://localhost:3000/")
	public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest ) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
		
		return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
		}
		else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}
}
