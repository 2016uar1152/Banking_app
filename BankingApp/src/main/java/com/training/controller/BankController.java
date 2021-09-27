package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.AuthRequest;
import com.training.util.JwtUtil;

@RestController
@RequestMapping("/")
public class BankController {
	
	@GetMapping("")
	public String welcomeEveryone() {
		return "Welcome to MAP bank!!! ";
	}
	
	@GetMapping("/customer")
	public String sayHelloUser() {
		return "Hello Customer";
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin() {
		return "Hello Admin";
	}
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception { //from json input
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getCustId(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid custId/password");
        }

        return jwtUtil.generateToken(authRequest.getCustId());
    }
	

}
