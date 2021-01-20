package com.tcs.bean;

import java.util.Date;

public class Transactions {
private long transactionid;
private long customerid;
private long targetid;
private String accounttype;
private double amount;
private Date transactiondate;
private String sourcetype;
private String targettype;
private String description;
private double transferedamount;
public Transactions() {
	super();
}





public Transactions(long transactionid, double transferedamount, Date transactiondate, String description) {
	super();
	this.transactionid = transactionid;
	this.transferedamount=transferedamount;
	this.transactiondate = transactiondate;
	this.description = description;
}





public Transactions(long customerid, long targetid, String accounttype, double amount, Date transactiondate,
		String targettype, String description, double transferedamount) {
	super();
	this.customerid = customerid;
	this.targetid = targetid;
	this.accounttype = accounttype;
	this.amount = amount;
	this.transactiondate = transactiondate;
	this.targettype = targettype;
	this.description = description;
	this.transferedamount = transferedamount;
}





public Transactions(long customerid, long targetid, String accounttype, double amount, Date transactiondate,
		String sourcetype, String targettype, String description, double transferedamount) {
	super();
	this.customerid = customerid;
	this.targetid = targetid;
	this.accounttype = accounttype;
	this.amount = amount;
	this.transactiondate = transactiondate;
	this.sourcetype = sourcetype;
	this.targettype = targettype;
	this.description = description;
	this.transferedamount = transferedamount;
}
public Transactions(long transactionid, long customerid, long targetid, String accounttype, double amount,
		Date transactiondate, String sourcetype, String targettype, String description, double transferedamount) {
	super();
	this.transactionid = transactionid;
	this.customerid = customerid;
	this.targetid = targetid;
	this.accounttype = accounttype;
	this.amount = amount;
	this.transactiondate = transactiondate;
	this.sourcetype = sourcetype;
	this.targettype = targettype;
	this.description = description;
	this.transferedamount = transferedamount;
}
public Transactions(long customerid, String accounttype, double amount, Date transactiondate, String sourcetype,
		String targettype, String description, double transferedamount) {
	super();
	this.customerid = customerid;
	this.accounttype = accounttype;
	this.amount = amount;
	this.transactiondate = transactiondate;
	this.sourcetype = sourcetype;
	this.targettype = targettype;
	this.description = description;
	this.transferedamount = transferedamount;
}
public long getTransactionid() {
	return transactionid;
}
public void setTransactionid(long transactionid) {
	this.transactionid = transactionid;
}
public long getCustomerid() {
	return customerid;
}
public void setCustomerid(long customerid) {
	this.customerid = customerid;
}
public String getAccounttype() {
	return accounttype;
}
public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getTransactiondate() {
	return transactiondate;
}
public void setTransactiondate(Date transactiondate) {
	this.transactiondate = transactiondate;
}
public String getSourcetype() {
	return sourcetype;
}
public void setSourcetype(String sourcetype) {
	this.sourcetype = sourcetype;
}
public String getTargettype() {
	return targettype;
}
public void setTargettype(String targettype) {
	this.targettype = targettype;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getTransferedamount() {
	return transferedamount;
}
public void setTransferedamount(double transferedamount) {
	this.transferedamount = transferedamount;
}
@Override
public String toString() {
	return "Transactions [transactionid=" + transactionid + ", customerid=" + customerid + ", accounttype="
			+ accounttype + ", amount=" + amount + ", transactiondate=" + transactiondate + ", sourcetype=" + sourcetype
			+ ", targettype=" + targettype + ", description=" + description + ", transferedamount=" + transferedamount
			+ "]";
}


}
