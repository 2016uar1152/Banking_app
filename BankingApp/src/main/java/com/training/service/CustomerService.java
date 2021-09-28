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
import com.training.repo.BankUserRepo;
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
	
	public Account getAccount(long accountNo)
	{
		Optional<Account> opAccount = accountRepo.findById(accountNo);
		Account account = opAccount.get();
		return account;
	}

	public Account getAccountDetails(long custId){
		return getCustomer(custId).getAccount();
	}

	public double getBalance(long custId) {
		return getAccountDetails(custId).getBalance();		
	}

	public List<Transaction> viewTransaction(long custId, LocalDate startDate, LocalDate endDate) {
		Account account= getAccountDetails(custId);
		return transactionRepo.findByDateBetween(startDate, endDate, account, account);
	}
	
	public Transaction deposit(long custId, double amount) {
		Account account = getAccountDetails(custId);
		Transaction transaction=new Transaction();
		
		transaction.setFromAccount(account);
		transaction.setToAccount(account);
		transaction.setAmount(amount);
		transaction.setDate(LocalDate.now());
		
		transactionRepo.save(transaction);
		account.setBalance( account.getBalance()+amount );
		accountRepo.save(account);
		
		return 	transaction;
	}
	
	public Transaction withdraw(long custId, double amount) {
		Account account = getAccountDetails(custId);
		Transaction transaction=new Transaction();
		if(account.getBalance()>=amount) {
			transaction.setFromAccount(account);
			transaction.setToAccount(account);
			transaction.setAmount(-amount);
			transaction.setDate(LocalDate.now());
			transactionRepo.save(transaction);
			
			account.setBalance( account.getBalance()-amount );
			accountRepo.save(account);
			return 	transaction;
		}
		else {
			System.out.println("Insufficient balance!!");
			return null;
		}
		
	}
	
	public Transaction transfer(long fromCustId, long toAccountNo, double amount) {
		Account fromAccount = getAccountDetails(fromCustId);
		Account toAccount = getAccount(toAccountNo);
		
		if(fromAccount.getBalance()>=amount) {
			//before transaction value being saved to database
			Transaction transaction=new Transaction();
			transaction.setFromAccount(fromAccount);
			transaction.setToAccount(toAccount);
			transaction.setAmount(amount);
			transaction.setDate(LocalDate.now());
			transactionRepo.save(transaction);
			
			//transaction begins
			fromAccount.setBalance( fromAccount.getBalance()-amount );
			accountRepo.save(fromAccount);
			
			toAccount.setBalance( toAccount.getBalance()+amount );
			accountRepo.save(toAccount);
			return 	transaction;
		}
		else {
			System.out.println("Insufficient balance!!");
			return null;
		}	
		
	}
	
}
