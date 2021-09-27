package com.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class AuthRequest {
	
	private String custId;
	private String password;
	public AuthRequest() {
		super();
	}
	public AuthRequest(String custId, String password) {
		super();
		this.custId = custId;
		this.password = password;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}