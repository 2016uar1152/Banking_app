package com.training;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;
import com.training.repo.TransactionRepo;
import com.training.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private CustomerService cs;
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		Account a1=new Account("SAV",97000.00,true);
		Account a2=new Account("SAV",101500.00,true);
		Account a3=new Account("SAV",32635.67,true);
		accountRepo.save(a1);
		accountRepo.save(a2);
		accountRepo.save(a3);
		Customer c1= new Customer(a1,"sam",LocalDate.parse("1997-10-27"), "9472356897", "dp_11111.jpg", "13, church st, Bangalore, KA");
		Customer c2=new Customer(a2,"peter",LocalDate.parse("1995-08-21"), "773698275", "dp_11112.jpg", "24A, Lodi Road, Delhi, DL");
		Customer c3=new Customer(a3,"donald",LocalDate.parse("1999-01-31"), "8672836243", "dp_11113.jpg", "567, Park central, Bangalore, KA");
		customerRepo.save(c1);
		customerRepo.save(c2);
		customerRepo.save(c3);
		Transaction t1= new Transaction(a1,a2,LocalDate.parse("2012-10-16"),500.00);
		Transaction t2= new Transaction(a1,a3,LocalDate.parse("2013-01-15"),1000.00);
		Transaction t3= new Transaction(a2,a3,LocalDate.parse("2015-08-16"),675.13);
		transactionRepo.save(t1);
		transactionRepo.save(t2);
		transactionRepo.save(t3);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am in command line runner.");
		//System.out.println(config.getMessage());
		//System.out.println(config.getPort());
		
		System.out.println(cs.getCustomer(4));
		System.out.println(cs.getAccountDetails(4));
		System.out.println(cs.getBalance(4));
		System.out.println(cs.viewTransaction( LocalDate.parse("2012-10-15"), LocalDate.parse("2015-08-17") ));
		
		

	}

}
