package com.training.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="account")
public class Account {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	
	private String type;
	private double balance;
	private boolean isActive;
	public Account() {
		super();
	}
	public Account(long accountNo, String type, double balance, boolean isActive) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.balance = balance;
		this.isActive = isActive;
	}
	public Account( String type, double balance, boolean isActive) {
		super();
		this.type = type;
		this.balance = balance;
		this.isActive = isActive;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", type=" + type + ", balance=" + balance + ", isActive=" + isActive
				+ "]";
	}
	
	
	
	
}
