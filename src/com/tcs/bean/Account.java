package com.tcs.bean;

import java.util.Date;

public class Account {
	private long CustomerId;
	private long AccountId;
	private String AccountType;
	private double Balance;
	private Date CRdate;
	private Date CRlastdate;
	private long Duration;
	public Account() {
		super();
	}
	public Account(long customerId, long accountId, String accountType, double balance) {
		super();
		CustomerId = customerId;
		AccountId = accountId;
		AccountType = accountType;
		Balance = balance;
	}
	public Account(long customerId, long accountId, String accountType, double balance, Date cRdate, Date cRlastdate,
			long duration) {
		super();
		CustomerId = customerId;
		AccountId = accountId;
		AccountType = accountType;
		Balance = balance;
		CRdate = cRdate;
		CRlastdate = cRlastdate;
		Duration = duration;
	}
	
	
	public Account(long customerId, String accountType, double balance) {
		super();
		CustomerId = customerId;
		AccountType = accountType;
		Balance = balance;
	}
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	public long getAccountId() {
		return AccountId;
	}
	public void setAccountId(long accountId) {
		AccountId = accountId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public Date getCRdate() {
		return CRdate;
	}
	public void setCRdate(Date cRdate) {
		CRdate = cRdate;
	}
	public Date getCRlastdate() {
		return CRlastdate;
	}
	public void setCRlastdate(Date cRlastdate) {
		CRlastdate = cRlastdate;
	}
	public long getDuration() {
		return Duration;
	}
	public void setDuration(long duration) {
		Duration = duration;
	}
	@Override
	public String toString() {
		return "\nAccount [CustomerId=" + CustomerId + ", AccountId=" + AccountId + ", AccountType=" + AccountType
				+ ", Balance=" + Balance + ", CRdate=" + CRdate + ", CRlastdate=" + CRlastdate + ", Duration="
				+ Duration + "]";
	}
	
}
