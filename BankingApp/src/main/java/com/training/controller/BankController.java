package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.AuthRequest;
import com.training.service.BankUserDetailsService;
import com.training.util.JwtUtil;

@RestController
@RequestMapping("/bank")
public class BankController {

	@GetMapping("")
	public String welcomeEveryone() {
		return "Welcome to MAP bank!!! ";
	}

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception { //from json input
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
					);
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}

		return jwtUtil.generateToken(authRequest.getUsername());
	}
	
	@Autowired
	private BankUserDetailsService bankUserDetailsService;
	
	@GetMapping("/forgotpassword/username/{0}/newpassword/{1}")
	public String passwordForgot(@PathVariable("0") String username, @PathVariable("1") String newPassword) {
		return bankUserDetailsService.forgotPassword(username,newPassword);
	}

}
