package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Customer;
import com.training.service.AdminService;
import com.training.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("")
	public String welcome() {
		return "Welcome, Admin to MAP Bank!!";
	}

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add/customer")
	public String addCustomer(@RequestBody Customer customer) {
		try {
			adminService.createCustomer(customer.getCustName(), customer.getDob(),
			  customer.getMobileNo(), customer.getPhoto(),customer.getAddress(),
			  customer.getAccount().getType(), customer.getAccount().getBalance());
			return "Customer added!!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Customer not added!!";
		}		
	}
	
	
	
	
}
