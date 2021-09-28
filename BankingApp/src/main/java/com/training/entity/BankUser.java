package com.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="user")
public class BankUser {
	
	@Id
	@Column(name="username",length=100)
	private String username;
	private String password;
	private boolean active;
	private String roles;
	public BankUser() {
		super();
	}
	public BankUser(String username, String password, boolean active, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	
}