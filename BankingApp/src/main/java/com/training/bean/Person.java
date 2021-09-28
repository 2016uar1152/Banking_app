package com.training.bean;
public class Person {

  private long custId;
  private String mobileNo;
  //private int age;

  public Person() {
  }

  public Person(long custId, String lastName) {
    this.custId = custId;
    this.mobileNo = lastName;
    //this.age=age;
  }

	/*
	 * public int getAge() { return age; }
	 * 
	 * public void setAge(int age) { this.age = age; }
	 */

public void setCustId(long custId) {
    this.custId = custId;
  }

  public long getCustId() {
    return custId;
  }

public String getMobileNo() {
    return mobileNo;
  }

public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  @Override
  public String toString() {
    return "custId: " + custId + ", Mobile No: " + mobileNo;
  }

}