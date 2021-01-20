package com.tcs.bean;

public class Customer {
	private long SSNID; 
	private long CustomerId;
	private String Name;
	private String Address;
	private int Age;
	public Customer() {
		super();
	}
	public Customer(long sSNID, long customerId, String name, String address, int age) {
		super();
		SSNID = sSNID;
		CustomerId = customerId;
		Name = name;
		Address = address;
		Age = age;
	}
	
	public Customer(long sSNID, String name, String address, int age) {
		super();
		SSNID = sSNID;
		Name = name;
		Address = address;
		Age = age;
	}
	public long getSSNID() {
		return SSNID;
	}
	public void setSSNID(long sSNID) {
		SSNID = sSNID;
	}
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "\ncustomer [SSNID=" + SSNID + ", CustomerId=" + CustomerId + ", Name=" + Name + ", Address=" + Address
				+ ", Age=" + Age + "]";
	}
	
}
