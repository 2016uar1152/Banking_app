package com.training.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transId;

	@OneToOne//(cascade=cascadeType)
	@JoinColumn(name="fromAccountNo")
	private Account fromAccount;
	
	@OneToOne//(cascade=cascadeType)
	@JoinColumn(name="toAccountNo")
	private Account toAccount;

	//@Temporal(TemporalType.DATE)
	private LocalDate date;
	
	private double amount;

	public Transaction() {
		super();
	}

	public Transaction(long transId, Account fromAccount, Account toAccount, LocalDate date, double amount) {
		super();
		this.transId = transId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
		this.amount = amount;
	}
	public Transaction( Account fromAccount, Account toAccount, LocalDate date, double amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
		this.amount = amount;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", date=" + date + ", amount=" + amount + "]";
	}	
	
	
	
	
}
