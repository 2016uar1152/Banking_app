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


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="customer")
public class Customer {

	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long custId;
	
	@OneToOne//(cascade=cascadeType)
	@JoinColumn(name="accountNo")
	private Account account;
	
	private String custName;
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	@Column(name="mobileNo", length=10)
	private String mobileNo;
	private String photo;
	private String address;
	public Customer() {
		super();
	}
	public Customer(long custId, Account account, String custName, LocalDate dob, String mobileNo, String photo,
			String address) {
		super();
		this.custId = custId;
		this.account = account;
		this.custName = custName;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.photo = photo;
		this.address = address;
	}
	public Customer( Account account, String custName, LocalDate dob, String mobileNo, String photo,
			String address) {
		super();
		this.account = account;
		this.custName = custName;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.photo = photo;
		this.address = address;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", account=" + account + ", custName=" + custName + ", dob=" + dob
				+ ", mobileNo=" + mobileNo + ", photo=" + photo + ", address=" + address + "]";
	}
	
	

}
