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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	public String updatePassword(String username, String oldPassword, String newPassword) {
		BankUser bankUser=null;
		Optional<BankUser> opBankUser =bankUserRepo.findById(username);
		if(opBankUser.isPresent()) 
		{	bankUser=opBankUser.get();
			if( passwordEncoder().matches(oldPassword, bankUser.getPassword()) )
			{	newPassword = passwordEncoder().encode(newPassword);
				bankUser.setPassword(newPassword);
				bankUserRepo.save(bankUser);
				return "Password Updated Successfully.";
			}
			else {return "Old Password doesn't matches.";}
		}
		else {return "User doesn't exists/ invalid username.";}
	}
	
//	public String forgotPassword(String username, String mobileNo, String newPassword) {
//		newPassword = passwordEncoder.encode(newPassword);
//		
//		BankUser bankUser=null;
//		Optional<BankUser> opBankUser =bankUserRepo.findById(username);
//		if(opBankUser.isPresent())
//		{	
//			bankUser=opBankUser.get();
//			if( (bankUser.getMobileNo()).equals(mobileNo) )
//			{	bankUser.setPassword(newPassword);
//				bankUserRepo.save(bankUser);
//				return "Password Updated Successfully.";
//			}
//			else return "Mobile verification failed.";
//		}
//		else return "User doesn't exists/ invalid username.";
//	}
	
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return new PasswordEncoder()
		{
			@Override
			public String encode(CharSequence userEnteredPassword) {
		        String hashedPassword = passwordEncoder.encode(userEnteredPassword);
				return hashedPassword;
			}

			@Override
			public boolean matches(CharSequence userEnteredPassword, String password) {
				if(passwordEncoder.matches(userEnteredPassword, password))   
					return true;
				return false;
			}
		};

	}
}
