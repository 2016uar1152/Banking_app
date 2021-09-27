package com.training.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;
import com.training.repo.TransactionRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private TransactionRepo transactionRepo;

	public Customer getCustomer(long custId)
	{
		Optional<Customer> opCustomer = customerRepo.findById(custId);
		Customer customer = opCustomer.get();
		//if(opCustomer.isPresent()) System.out.println(customer);
		return customer;
	}

	public Account getAccountDetails(long custId){
		return getCustomer(custId).getAccount();
	}

	public double getBalance(long custId) {
		return getAccountDetails(custId).getBalance();		
	}

	public List<Transaction> viewTransaction(LocalDate startDate, LocalDate endDate) {
		return transactionRepo.findByDateBetween(startDate, endDate);
	}

}
