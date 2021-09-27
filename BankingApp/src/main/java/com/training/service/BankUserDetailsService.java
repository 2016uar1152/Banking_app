package com.training.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.entity.BankUser;
import com.training.repo.BankUserRepo;


@Service
public class BankUserDetailsService implements UserDetailsService {
	
	@Autowired
	private BankUserRepo bankUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println("Username Entered: "+ username);
		BankUser bankUser=null;
		Optional<BankUser> opBankUser =bankUserRepo.findById(username);
		if(opBankUser.isPresent()) {
			bankUser=opBankUser.get();
		}
		List<GrantedAuthority> list= new ArrayList<>();
		list = Arrays.stream(bankUser.getRoles().split(","))
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
		
		return new User(bankUser.getUsername(), bankUser.getPassword(), list);
	}

}
