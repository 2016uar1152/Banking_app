package com.training.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;
import com.training.repo.TransactionRepo;

@Service
public class AdminService {
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private TransactionRepo transactionRepo;
	
	public Customer getCustomer(long custId)
	{
		Optional<Customer> opCustomer = customerRepo.findById(custId);
		if(opCustomer.isPresent()) return customerRepo.findById(custId).get();
		return null;
	}
	public Account getAccount(long accountNo)
	{
		Optional<Account> opAccount = accountRepo.findById(accountNo);
		if(opAccount.isPresent()) return accountRepo.findById(accountNo).get();
		return null;
	}
	
	public String deleteCustomer(long custId)
	{	Customer customer= getCustomer(custId);
		if(customer == null) 
			return "Account with account Id : "+custId+" does not exist";
		
		long accountNo= customer.getAccount().getAccountNo();
		customerRepo.deleteById(custId);
		deleteAccount(accountNo);
		return "Customer deleted";
	}
	public String deleteAccount(long accountNo)
	{
		if(getAccount(accountNo) == null)
			return "Account with account Id : "+accountNo+" does not exist";
		accountRepo.deleteById(accountNo);
		return "Account deleted";
	}
	
	public Customer updateCustomerPhone(long custId,String phone)
	{	Customer customer=getCustomer(custId);
		if(customer == null) return null;
		customer.setMobileNo(phone);
		customerRepo.save(customer);
		return customer;
	}
	public Account updateAccountStatus(long accountNo, boolean status)
	{	Account account = getAccount(accountNo);
		if(account == null) return null;
		account.setActive(status);
		accountRepo.save(account);
		return account;
	}
	
	public Customer createCustomer(Customer customer)
	{	
		Account account = createAccount(customer.getAccount());
		customer.setAccount(account);
		customerRepo.save(customer);
		return customer;
	}
	public Account createAccount(Account account)
	{	accountRepo.save(account);
		return account;
	}
	
	
	
	
}
