package com.tcs.tester;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tcs.bean.Account;
import com.tcs.bean.AccountStatus;
import com.tcs.bean.Customer;
import com.tcs.dao.BankDao;
import com.tcs.exception.DataLayerException;
import com.tcs.service.BankService;

public class Tester {
	private static Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	public static void main(String args[]) throws DataLayerException{
		BankDao b=new BankDao();
		BankService service=new BankService();
		Customer customer=new Customer(400000000,"kavya","pdtr",21);
		Customer customer1=new Customer(400000001,"kavyasree","kdp",21);

		Account account=new Account(100000001,"current",2000);
	 	Date d1=null;
			Date d2=null;
			String d3="2018-04-17";
			String d4="2018-04-20";
			try{
			DateFormat f=new SimpleDateFormat("yyyy-mm-dd");
		 d1=f.parse("2018-04-17");
		 d2=f.parse("2018-04-20");
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		/*Account a=new Account(1002,"savings",2000);
		
		ArrayList<AccountStatus> temp=new ArrayList<AccountStatus>();
		ArrayList<Account> temp1=new ArrayList<Account>();
		System.out.println(b.createAccount(a, 1002));
		System.out.println(b.deleteCustomer(1002));
		System.out.println(b.deleteAccount(1022));
		temp=b.viewStatus();
		for(AccountStatus as:temp){
			System.out.println(as.toString());
		}
		System.out.println(b.updateCustomer("vamsi","nellore", 21, 1001));
		temp1=b.searchAccount(1022, 1002);
		System.out.println(temp1.size());*/
		
		//System.out.println(b.transferMoney(1023,"savings",1024,"Current",1000));
		//ArrayList<AccountStatus> temp=service.viewStatus();
		//ArrayList<Account> temp=service.searchAccount(200000001, 100000000);
		//System.out.println(service.withdrawMoney(200000001, "current", 10));
		//System.out.println(service.depositMoney(200000001,"current", 10));
		//System.out.println(service.transferMoney(200000001,"current",200000001,"savings",10));
			//System.out.println(d1);
		//	System.out.println(service.searchaccountwithid(200000001));
		//System.out.println(service.ministatementdate(100000000,"current", d3, d4));
		System.out.println(service.searchCustom(645677238));
	}
}
