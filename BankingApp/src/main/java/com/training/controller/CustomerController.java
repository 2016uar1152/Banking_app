package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@GetMapping("")
	public String welcome() {
		return "Hello, Customer.";
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

	
}
