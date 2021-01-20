package com.tcs.bean;

import java.util.Date;

public class AccountStatus {
private long custid;
private long accid;
private String custtype;
private String status;
private String message;
private Date lastUpdated;
public AccountStatus(long custid, long accid, String custtype, String status, String message, Date lastUpdated) {
	super();
	this.custid = custid;
	this.accid = accid;
	this.custtype = custtype;
	this.status = status;
	this.message = message;
	this.lastUpdated = lastUpdated;
}

public Date getLastUpdated() {
	return lastUpdated;
}

public void setLastUpdated(Date lastUpdated) {
	this.lastUpdated = lastUpdated;
}

public long getCustid() {
	return custid;
}
public void setCustid(long custid) {
	this.custid = custid;
}
public long getAccid() {
	return accid;
}
public void setAccid(long accid) {
	this.accid = accid;
}
public String getCusttype() {
	return custtype;
}
public void setCusttype(String custtype) {
	this.custtype = custtype;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public AccountStatus() {
	super();
}
@Override
public String toString() {
	return "AccountStatus [custid=" + custid + ", accid=" + accid + ", custtype=" + custtype + ", status=" + status
			+ ", message=" + message + "]";
}

}
