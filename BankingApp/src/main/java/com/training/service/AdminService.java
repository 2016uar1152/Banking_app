package com.training.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;

@Service
public class AdminService {
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public Customer getCustomer(long id)
	{
		Optional<Customer> opCustomer = customerRepo.findById(id);
		if(opCustomer.isPresent())
		return customerRepo.findById(id).get();
		return null;
	}
	
	public Customer createCustomer()
	{	Customer c= new Customer(11114l,new Account(22222225l,"SAV",45735.67,true),"Joe",new Date(), "7672836243", "dp_11114.jpg", "567, Park central, Bangalore, KA");
		customerRepo.save(c);
		return c;
	}
	
	public Account createAccount()
	{
		Account acc= new Account(22222226l,"SAV",67735.67,true);
		accountRepo.save(acc);
		return acc;
	}
	
	public Account getAccount(long Id)
	{
		Optional<Account> opAcc = accountRepo.findById(Id);
		if(opAcc.isPresent())
		return accountRepo.findById(Id).get();
		return null;
	}
	public String deleteAccount(long Id)
	{
		if(getAccount(Id) == null)
			return "Account with account Id : "+Id+" does not exist";
		accountRepo.deleteById(Id);
		return "Account deleted";
	}
	
	public Customer updateCustomer(long Id,String phone)
	{	Customer customer=getCustomer(Id);
		if(customer == null)
			return null;
		customer.setMobileNo(phone);
		customerRepo.save(customer);
		return getCustomer(Id);
	}
	
	
}
