package com.training;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.entity.Account;
import com.training.entity.Customer;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Account a1=new Account(22222222l,"SAV",97000.00,true);
		Account a2=new Account(22222223l,"SAV",101500.00,true);
		Account a3=new Account(22222224l,"SAV",32635.67,true);
		accountRepo.save(a1);
		accountRepo.save(a2);
		accountRepo.save(a3);
		Customer c1= new Customer(11111l,a1,"sam",new Date(), "9472356897", "dp_11111.jpg", "13, church st, Bangalore, KA");
		Customer c2=new Customer(11112l,a2,"peter",new Date(), "773698275", "dp_11112.jpg", "24A, Lodi Road, Delhi, DL");
		Customer c3=new Customer(11113l,a3,"donald",new Date(), "8672836243", "dp_11113.jpg", "567, Park central, Bangalore, KA");
		customerRepo.save(c1);
		customerRepo.save(c2);
		customerRepo.save(c3);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am in command line runner.");
		//System.out.println(config.getMessage());
		//System.out.println(config.getPort());


	}

}
