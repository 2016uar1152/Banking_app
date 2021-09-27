package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("")
	public String welcome() {
		return "Hello Admin :-)";
	}

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/get/account/{accountNo}")
	public Account getAccountDetails(@PathVariable("accountNo") long accountNo) {
		return adminService.getAccount(accountNo);
	}
	@GetMapping("/get/customer/{custId}")
	public Customer getCustomerDetails(@PathVariable("custId") long custId) {
		return adminService.getCustomer(custId);
	}
	
	@DeleteMapping("/delete/account/{accountNo}")
	public String deleteAccount(@PathVariable("accountNo") long accountNo) {
		return adminService.deleteAccount(accountNo);
	}
	@DeleteMapping("/delete/customer/{custId}")
	public String deleteCustomer(@PathVariable("custId") long custId) {
		return adminService.deleteCustomer(custId);
	}
	
	@GetMapping("/update/customer/{custId}/phone/{phoneNo}")
	public Customer updateCustomerPhone(@PathVariable("custId") long custId, @PathVariable("phoneNo") String phoneNo) {
		return adminService.updateCustomerPhone(custId,phoneNo);
	}
	@GetMapping("/update/account/{accountNo}/status/{status}")
	public Account updateAccountStatus(@PathVariable("accountNo") long accountNo, @PathVariable("status") boolean status) {
		return adminService.updateAccountStatus(accountNo,status);
	}
	
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
