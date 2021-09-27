package com.training.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Account;
import com.training.entity.Transaction;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public Account getAccount(long custId){
		Optional<Account> opAccount=accountRepo.findById(custId);
		Account account= opAccount.get();
		if(opAccount.isPresent()) System.out.println(account);
		return account;
	}
	
	public double getBalance(long custId) {
		return getAccount(custId).getBalance();		
	}
	
	public List<Transaction> viewTransaction(Date startDate, Date endDate) {
		List<Transaction> list = new ArrayList<>();
		
		
		return list;
	}
	
}
