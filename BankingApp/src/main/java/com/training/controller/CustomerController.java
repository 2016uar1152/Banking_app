package com.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.service.BankUserDetailsService;
import com.training.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("")
	public String welcome() {
		return "Hello, Customer :-)";
	}
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{custId}")
	public Customer getCustomerDetails(@PathVariable("custId") long custId)
	{
		return customerService.getCustomer(custId);
	}
	
	@GetMapping("/{custId}/account")
	public Account getAccountDetails(@PathVariable("custId") long custId)
	{
		return customerService.getAccountDetails(custId);
	}
	
	
	@GetMapping("/{custId}/account/balance")
	public double getBalance(@PathVariable("custId") long custId)
	{
		return customerService.getBalance(custId);
	}
	
	@GetMapping("/{custId}/deposit/{amount}")
	public Transaction depositer(@PathVariable("custId") long custId, @PathVariable("amount") double amount)
	{
		return customerService.deposit(custId,amount);
	}
	
	@GetMapping("/{custId}/withdraw/{amount}")
	public Transaction withdrawer(@PathVariable("custId") long custId, @PathVariable("amount") double amount)
	{
		return customerService.withdraw(custId,amount);
	}
	
	@GetMapping("/{custId}/transfer/{accountNo}/amount/{amount}")
	public Transaction transferer(@PathVariable("custId") long custId, @PathVariable("accountNo") long accountNo, @PathVariable("amount") double amount)
	{
		return customerService.transfer(custId,accountNo,amount);
	}
	
	@GetMapping("/{custId}/statement/from/{fromDate}/to/{toDate}")
	public List<Transaction> statementViewer(@PathVariable("custId") long custId, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate)
	{
		return customerService.viewTransaction(custId,LocalDate.parse(fromDate),LocalDate.parse(toDate));
	}
	
	@Autowired
	private BankUserDetailsService bankUserDetailsService;
	
	@GetMapping("/updatepassword/{username}/{oldPassword}/{newPassword}")
	public String passwordUpdater(@PathVariable("username") String username, @PathVariable("oldPassword") String oldPassword,
			@PathVariable("newPassword") String newPassword) {
		return bankUserDetailsService.updatePassword(username,oldPassword,newPassword);
	}
	
}
