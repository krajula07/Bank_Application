package com.tcs.service;

import java.util.ArrayList;
import java.util.Date;

import com.tcs.bean.Account;
import com.tcs.bean.AccountStatus;
import com.tcs.bean.Customer;
import com.tcs.bean.Transactions;
import com.tcs.dao.BankDao;
import com.tcs.exception.DataLayerException;

public class BankService {
	public ArrayList<String> searchUser(String username,String password) throws DataLayerException{
		BankDao dao = new BankDao();
		ArrayList<String> result = dao.searchUser(username, password);
		return result;
	}
	public boolean addCustomer(Customer customer) throws DataLayerException {
		BankDao dao = new BankDao();
		boolean result = dao.addCustomer(customer);
		return result;
	}
	public boolean createAccount(Account a,long id) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.createAccount(a, id);
		return result;
	}
	public Customer searchCustom(long snid) throws DataLayerException
	{BankDao dao = new BankDao();
	
	Customer c = dao.searchCustom(snid);
	return c;}
	public boolean searchCust(long cid) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.searchCust(cid);
		return result;
	}
	public boolean searchaccountstatus(long aid) throws DataLayerException
	{BankDao dao = new BankDao();
	boolean result = dao.searchaccountstatus(aid);
	return result;
	}
	public boolean searchaccountstatus1(long cid) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.searchaccountstatus1(cid);
		return result;
	}
	public boolean deleteCustomer(long id) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.deleteCustomer(id);
		return result;
	}
	public boolean searchCust1(long cid,long ssnid,String cusname,String address,int age) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.searchCust1(cid,ssnid,cusname,address,age);
		return result;
	}
	public boolean deleteAccount(long id) throws DataLayerException{
		BankDao dao = new BankDao();
		boolean result = dao.deleteAccount(id);
		return result;
	}
	public boolean searchaccount(long aid,String accnttype) throws DataLayerException
	{
		BankDao dao = new BankDao();
		boolean result = dao.searchaccount(aid, accnttype);
		return result;
	}
	
	public ArrayList<AccountStatus> viewStatus() throws DataLayerException{

		BankDao dao = new BankDao();
		ArrayList<AccountStatus> temp = dao.viewStatus();
		return temp;
	}
	public boolean updateCustomer(String name,String address,int age,long id) throws DataLayerException
	{BankDao dao = new BankDao();
	boolean result = dao.updateCustomer(name, address, age, id);
	return result;
	}
	public Customer searchCustomer(long cid) throws DataLayerException
	{
		BankDao dao = new BankDao();
	
	Customer c = dao.searchCustomer(cid);
	return c;
	}
	public ArrayList<Account> searchAccount(long aid,long cid) throws DataLayerException
	{
		ArrayList<Account> a=new ArrayList<Account>();
		BankDao dao = new BankDao();
		a=dao.searchAccount(aid, cid);
		return a;
	}
	public Account searchaccountwithid(long aid) throws DataLayerException
	{BankDao dao = new BankDao();
	Account result = dao.searchaccountwithid(aid);
	return result;}
	
	public boolean depositMoney(long aid,String accounttype,double deposit) throws DataLayerException
	{
		BankDao dao = new BankDao();
		boolean result = dao.depositMoney(aid, accounttype, deposit);
		return result;
		}
	public boolean withdrawMoney(long aid,String accounttype,double withdraw) throws DataLayerException
	{	BankDao dao = new BankDao();
	boolean result = dao.withdrawMoney(aid, accounttype, withdraw);
	return result;
	}
	public boolean transferMoney(long sourceid,String sourcetype,long targetid,String targettype,double tmoney)
	{BankDao dao = new BankDao();
	boolean result = dao.transferMoney(sourceid, sourcetype, targetid, targettype, tmoney);
	return result;
	}
	public boolean searchacntwithid(long aid) throws DataLayerException
	{BankDao dao = new BankDao();
	boolean result = dao.searchacntwithid(aid);
	return result;}
	public ArrayList<Transactions> ministatementdate(long cid,String accounttype,String d1,String d2) throws DataLayerException{
		BankDao dao = new BankDao();
		ArrayList<Transactions> temp=dao.ministatementdate(cid,accounttype, d1, d2);
		return temp;}
	
	public ArrayList<Transactions> ministatement(int not,long cid,String accounttype ) throws DataLayerException{
		BankDao dao = new BankDao();
		ArrayList<Transactions> temp=dao.ministatement(not,cid,accounttype);
		return temp;}
}
