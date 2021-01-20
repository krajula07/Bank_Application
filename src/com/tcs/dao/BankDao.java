package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tcs.bean.Account;
import com.tcs.bean.AccountStatus;
import com.tcs.bean.Customer;
import com.tcs.bean.Transactions;
import com.tcs.exception.DataLayerException;
import com.tcs.util.DBUtil;

public class BankDao {
	private static Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
	
	public ArrayList<String> searchUser(String username,String password) throws DataLayerException{
		ArrayList<String>  result=null;
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs = null;
		try {
			con=DBUtil.createConnection();
			pst1=con.prepareStatement("SELECT * from Userstore");
			pst2=con.prepareStatement("update Userstore set lastlogin=to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') where username=?");
			pst2.setString(1, username);
			rs = pst1.executeQuery();
			while(rs.next()) {
				if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))){
					pst2.executeUpdate();
					if(result==null){
						result = new ArrayList<String>();
					}
					result.add(rs.getString(3));
					result.add(rs.getString(4));
					result.add(rs.getString(5));
				}
			}
		} catch(SQLException | DataLayerException e) {
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	
	public boolean addCustomer(Customer customer) throws DataLayerException {

		boolean result = false;
		long cust_id = 0;
		try {
			Connection con = DBUtil.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
			PreparedStatement ps1 = con.prepareStatement("select customer_seq.nextval from dual");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				cust_id = rs.getInt(1);
			}
			ps.setLong(1, customer.getSSNID());
			ps.setLong(2, cust_id);
			ps.setString(3, customer.getName());
			ps.setString(4, customer.getAddress());
			ps.setInt(5, customer.getAge());
			
			int t = ps.executeUpdate();

			if (t > 0) {

				result = true;

			}
			ps.close();
			con.close();

		} catch (DataLayerException | SQLException e) {
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public boolean createAccount(Account a,long id) throws DataLayerException{
		boolean result=false;
		long accnt_id=0;
		try{
		Connection con=DBUtil.createConnection();
		//System.out.println("kavya");
		PreparedStatement ps8=con.prepareStatement("select bankaccount_seq.nextval from dual");
		ResultSet rs8=ps8.executeQuery();
		if ( rs8.next() ) {
			accnt_id = rs8.getInt(1);
			}
		PreparedStatement ps1=con.prepareStatement("insert into bankaccount values(?,?,?,?,?,?,?)");
		ps1.setString(3,a.getAccountType() );
		ps1.setLong(2,accnt_id);
		ps1.setLong(1, id);
		ps1.setDouble(4, a.getBalance());
		ps1.setTimestamp(5, getCurrentTimeStamp());
		ps1.setLong(7, a.getDuration());
		ps1.setTimestamp(6, getCurrentTimeStamp());
		int t=ps1.executeUpdate();
		
		PreparedStatement ps9=con.prepareStatement("insert into account_status values(?,?,?,?,?,?)");
		System.out.println("kavya");
		ps9.setLong(1, id);
		ps9.setLong(2, accnt_id);
		ps9.setString(3, a.getAccountType());
		ps9.setString(4, "active");
		ps9.setString(5, "just created");
		ps9.setTimestamp(6,getCurrentTimeStamp() );
		int k=ps9.executeUpdate();
		if(t>0){
			if(k>0){
			result=true;
			}
		}
		}catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());	
		}


		catch(Exception e){
			System.out.println("exception");
		}
		return result;
	}
	public boolean searchCust(long cid) throws DataLayerException
	{
		 //Customer c=new Customer();
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customer WHERE Customerid=? ");
			ps.setLong(1, cid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=i+1;
				
			}
			if(i>0){
				result=true;
			}
		
		}catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	
	public Customer searchCustomer(long cid) throws DataLayerException
	{
		 //Customer c=new Customer();
		Customer c = null;
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customer WHERE Customerid=? ");
			ps.setLong(1, cid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				long ssnid=rs.getLong(1);
				long custid=rs.getLong(2);
				String name=rs.getString(3);
				String address=rs.getString(4);
				int age=rs.getInt(5);
				
				 c=new Customer(ssnid,custid,name,address,age);
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		
		return c;
	}
	public Customer searchCustom(long snid) throws DataLayerException
	{
		 //Customer c=new Customer();
		Customer c = null;
		boolean result=false;
		int i=0;
		try
		{System.out.println("kavya");
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customer WHERE ssnid=? ");
			ps.setLong(1, snid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{System.out.println(rs.getLong(1));
				long ssnid=rs.getLong(1);
				long custid=rs.getLong(2);
				String name=rs.getString(3);
				String address=rs.getString(4);
				int age=rs.getInt(5);
				
				 c=new Customer(ssnid,custid,name,address,age);
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			System.out.println(e.getMessage());
		}
		
		return c;
	}
	public boolean searchCust1(long cid,long ssnid,String cusname,String address,int age) throws DataLayerException
	{
		 //Customer c=new Customer();
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customer WHERE Customerid=? and ssnid=? and name=? and address=? and age=?");

			ps.setLong(1, cid);
			ps.setLong(2, ssnid);
			ps.setString(3, cusname);
			ps.setString(4, address);
			ps.setInt(5, age);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=i+1;
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public boolean searchaccountstatus(long aid) throws DataLayerException
	{
		 //Customer c=new Customer();
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM account_status WHERE Accountid=? and status='active'");

			ps.setLong(1, aid);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=i+1;
				
			}
			if(i>0){
				result=true;
			}}
		catch(SQLException | DataLayerException e)
			{
				throw new DataLayerException(e.getMessage());
			}
			return result;
		
		}
		public boolean searchaccountstatus1(long cid) throws DataLayerException
		{
			 //Customer c=new Customer();
			boolean result=false;
			int i=0;
			try
			{
				Connection con=DBUtil.createConnection();
				PreparedStatement ps=con.prepareStatement("SELECT * FROM account_status WHERE customerid=? and status='active'");

				ps.setLong(1, cid);
				
				
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					i=i+1;
					
				}
				if(i>1){
					result=true;
				}
			
			}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public boolean deleteCustomer(long id) throws DataLayerException
	{
		boolean result=false;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("update ACCOUNT_STATUS set status='inactive' where customerid=?");
			PreparedStatement ps1=con.prepareStatement("update ACCOUNT_STATUS set message='deleted' where customerid=?");
			PreparedStatement ps2=con.prepareStatement("update ACCOUNT_STATUS set lastupdated=? where customerid=?");
			ps.setLong(1, id);
			ps1.setLong(1, id);
			ps2.setTimestamp(1, getCurrentTimeStamp());
			System.out.println(getCurrentTimeStamp());
			ps2.setLong(2, id);
			int rs=ps.executeUpdate();
			int rs1=ps1.executeUpdate();
			int rs2=ps2.executeUpdate();
			System.out.println("kavya");
			if(rs>0){
				result=true;}
		}catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public boolean deleteAccount(long id) throws DataLayerException
	{
		boolean result=false;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("update ACCOUNT_STATUS set status='inactive' where accountid=?");
			
			PreparedStatement ps1=con.prepareStatement("update ACCOUNT_STATUS set message='deleted' where accountid=?");
			PreparedStatement ps2=con.prepareStatement("update ACCOUNT_STATUS set lastupdated=? where accountid=?");
			ps.setLong(1, id);
			ps1.setLong(1, id);
			ps2.setTimestamp(1, getCurrentTimeStamp());
			System.out.println(getCurrentTimeStamp());
			ps2.setLong(2, id);
			int rs=ps.executeUpdate();
			int rs1=ps1.executeUpdate();
			int rs2=ps2.executeUpdate();
		
			
			if(rs>0)
				result=true;
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public boolean searchaccount(long aid,String accnttype) throws DataLayerException
	{
		 //Customer c=new Customer();
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM bankaccount WHERE accountid=? and accounttype=? ");
			ps.setLong(1, aid);
			ps.setString(2, accnttype);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				i=i+1;
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public Account searchaccountwithid(long aid) throws DataLayerException
	{
		 //Customer c=new Customer();
		Account account=null;
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM bankaccount WHERE accountid=?");
			ps.setLong(1, aid);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				long custid=rs.getLong(1);
				long accntid=rs.getLong(2);
				String accnttype=rs.getString(3);
				double balance=rs.getDouble(4);
				
				account=new Account(custid,accntid,accnttype,balance);
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return account;
	}
	public boolean searchacntwithid(long aid) throws DataLayerException
	{
		 //Customer c=new Customer();
		Account account=null;
		boolean result=false;
		int i=0;
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM bankaccount WHERE accountid=?");
			ps.setLong(1, aid);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			i=i+1;
				
			}
			if(i>0){
				result=true;
			}
		
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return result;
	}
	public ArrayList<AccountStatus> viewStatus() throws DataLayerException
	{
		ArrayList<AccountStatus> temp=new ArrayList<AccountStatus>();
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("select * from account_status");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Long Customerid=rs.getLong(1);
				Long accountid=rs.getLong(2);
				String accounttype=rs.getString(3);
				 String State=rs.getString(4);
				 String message=rs.getString(5);
				 Date lastup=rs.getDate(6);
				AccountStatus a=new AccountStatus(Customerid,accountid,accounttype,State,message,lastup);
				temp.add(a);
				 
			}
		}
		catch(SQLException | DataLayerException e)
		{
			throw new DataLayerException(e.getMessage());
		}
		return temp;
	}
	public boolean updateCustomer(String name,String address,int age,long id) throws DataLayerException
	{
			long cust_id=0;
		boolean result=false;
		try
		{
			Connection con=DBUtil.createConnection();
			
			PreparedStatement ps=con.prepareStatement("update customer set name=?,address=?,age=? where customerid=?");
			
			ps.setString(1,name);
			ps.setString(2, address);
			ps.setInt(3, age);
			ps.setLong(4, id);
			int rs=ps.executeUpdate();
			if(rs>0)
				result=true;
		}
		catch(SQLException | DataLayerException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
	public ArrayList<Account> searchAccount(long aid,long cid) throws DataLayerException
	{
		ArrayList<Account> a=new ArrayList<Account>();
		
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM bankaccount WHERE accountid=? or customerid=? ");
			ps.setLong(1, aid);
			ps.setLong(2, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				long custid=rs.getLong(1);
				long accntid=rs.getLong(2);
				String accnttype=rs.getString(3);
				double balance=rs.getDouble(4);
				
				Account account=new Account(custid,accntid,accnttype,balance);
				a.add(account);
				 
				
			}
		
		}
		catch(Exception e)
		{
			System.out.println("exception caught");
		}
		return a;
	}
	public boolean withdrawMoney(long aid,String accounttype,double withdraw) throws DataLayerException
	{
		long tran_id=0;
		boolean result=false;
		boolean check=false;
		long custid=0;
		double amount=0;
		Date updated = null;
		try
		{
			Connection con=DBUtil.createConnection();
			
			PreparedStatement ps1=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
			//PreparedStatement ps20=con.prepareStatement("select * from account_status where Accountid=? and accounttype=? and status='active'");
			ps1.setLong(1,aid );
			ps1.setString(2, accounttype);
			//ps20.setLong(1,aid );
			//ps20.setString(2, accounttype);
			ResultSet rs1=ps1.executeQuery();
		//	ResultSet rs20=ps20.executeQuery();
			
			while(rs1.next())
			{
				if((rs1.getLong(4)-withdraw)>0)
				{
					
					
					PreparedStatement ps=con.prepareStatement("update bankaccount set balance=balance-?,crlastdate=? where Accountid=? and accounttype=?");
					ps.setDouble(1, withdraw);
					ps.setTimestamp(2, getCurrentTimeStamp());
					ps.setLong(3,aid);
					ps.setString(4, accounttype);
					int rs=ps.executeUpdate();
					
					
				}
			}
			
			
			
			PreparedStatement ps8=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
			ps8.setLong(1,aid );
			ps8.setString(2, accounttype);
			
			ResultSet rs8=ps8.executeQuery();
			while(rs8.next())
			{ custid=rs8.getLong(1);
				amount=rs8.getDouble(4);
				updated=rs8.getTimestamp(6);
			}
			
			PreparedStatement ps3=con.prepareStatement("select transaction_seq.nextval from dual ");
			ResultSet rs3=ps3.executeQuery();
			if ( rs3.next() ) {
				  tran_id = rs3.getInt(1);
				}
			
			PreparedStatement ps4=con.prepareStatement("insert into banktransactions values(?,?,?,?,?,?,?,?,?) ");
			ps4.setLong(1, tran_id);
			ps4.setLong(2, custid);
			ps4.setString(3, accounttype);
			ps4.setDouble(4, amount);
			ps4.setTimestamp(5,(Timestamp) updated);
			ps4.setString(6, null);
			ps4.setString(7, "withdraw");
			ps4.setDouble(8, withdraw);
			ps4.setLong(9, 0);
			int k1=ps4.executeUpdate();
			if(k1>0){
				check=true;}
			if(check==true)
				result=true;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	public boolean depositMoney(long aid,String accounttype,double deposit) throws DataLayerException
	{
		long tran_id=0;
		boolean result=false;
		boolean check=false;
		long custid=0;
		double amount=0;
		Date updated = null;
		try
		{
			Connection con=DBUtil.createConnection();
			
			PreparedStatement ps1=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
			ps1.setLong(1,aid );
			ps1.setString(2, accounttype);
			ResultSet rs1=ps1.executeQuery();
			int i=0;
			while(rs1.next())
			{
									
					
				i=i+1;	
					
				
			}
			
			if(i>0){
				PreparedStatement ps=con.prepareStatement("update bankaccount set balance=balance+?,crlastdate=? where Accountid=? and accounttype=?");
				ps.setDouble(1, deposit);
				ps.setTimestamp(2, getCurrentTimeStamp());
				ps.setLong(3,aid);
				ps.setString(4, accounttype);
				int rs=ps.executeUpdate();
				
			}
			
			PreparedStatement ps8=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
			ps8.setLong(1,aid );
			ps8.setString(2, accounttype);
			
			ResultSet rs8=ps8.executeQuery();
			while(rs8.next())
			{ custid=rs8.getLong(1);
				amount=rs8.getDouble(4);
				updated=rs8.getTimestamp(6);
			}
			
			PreparedStatement ps3=con.prepareStatement("select transaction_seq.nextval from dual ");
			ResultSet rs3=ps3.executeQuery();
			if ( rs3.next() ) {
				  tran_id = rs3.getInt(1);
				}
			
			PreparedStatement ps4=con.prepareStatement("insert into banktransactions values(?,?,?,?,?,?,?,?,?) ");
			ps4.setLong(1, tran_id);
			ps4.setLong(2, custid);
			ps4.setString(3, accounttype);
			ps4.setDouble(4, amount);
			ps4.setTimestamp(5,(Timestamp) updated);
			ps4.setString(6, null);
			ps4.setString(7, "deposit");
			ps4.setDouble(8, deposit);
			ps4.setLong(9, 0);
			int k1=ps4.executeUpdate();
			if(k1>0){
				check=true;}
			if(check==true)
				result=true;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	
	public boolean transferMoney(long sourceid,String sourcetype,long targetid,String targettype,double tmoney)
	{long tran_id=0;
	long tran_id1=0;
	boolean resultfinal=false;
	boolean result=false;
	boolean check=false;
	boolean check1=false;
	boolean result1=false;
	long custid=0;
	long custid1=0;
	double amount1=0;
	double amount=0;
	Date updated = null;
	Date updated1=null;
	try
	{
		Connection con=DBUtil.createConnection();
		
		PreparedStatement ps1=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
		ps1.setLong(1,sourceid );
		ps1.setString(2, sourcetype);
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			if((rs1.getLong(4)-tmoney)>0)
			{
				
				
				PreparedStatement ps=con.prepareStatement("update bankaccount set balance=balance-?,crlastdate=? where Accountid=? and accounttype=?");
				ps.setDouble(1, tmoney);
				ps.setTimestamp(2, getCurrentTimeStamp());
				ps.setLong(3,sourceid);
				ps.setString(4, sourcetype);
				int rs=ps.executeUpdate();
				
				
			}
		}
		
		
		
		PreparedStatement ps8=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
		ps8.setLong(1,sourceid );
		ps8.setString(2, sourcetype);
		
		ResultSet rs8=ps8.executeQuery();
		while(rs8.next())
		{ custid=rs8.getLong(1);
			amount=rs8.getDouble(4);
			updated=rs8.getTimestamp(6);
		}
		
		/*PreparedStatement ps3=con.prepareStatement("select tranid_seq.nextval from dual ");
		ResultSet rs3=ps3.executeQuery();
		if ( rs3.next() ) {
			  tran_id = rs3.getInt(1);
			}*/
		
		/*PreparedStatement ps4=con.prepareStatement("insert into banktransactions values(?,?,?,?,?,?,?,?,?) ");
		ps4.setLong(1, tran_id);
		ps4.setLong(2, custid);
		ps4.setString(3, sourcetype);
		ps4.setDouble(4, amount);
		ps4.setTimestamp(5,(Timestamp) updated);
		ps4.setString(6, null);
		ps4.setString(7, "withdraw");
		ps4.setDouble(8, tmoney);
		ps4.setLong(9, 0);
		int k1=ps4.executeUpdate();
		if(k1>0){
			check=true;}
		if(check==true)
			result=true;*/
		
		
		
		
		PreparedStatement ps15=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
		ps15.setLong(1,targetid );
		ps15.setString(2, targettype);
		ResultSet rs15=ps15.executeQuery();
		int i=0;
		while(rs15.next())
		{
				i=i+1;				
		}
		if(i>0){

			PreparedStatement ps=con.prepareStatement("update bankaccount set balance=balance+?,crlastdate=? where Accountid=? and accounttype=?");
			ps.setDouble(1, tmoney);
			ps.setTimestamp(2, getCurrentTimeStamp());
			ps.setLong(3,targetid);
			ps.setString(4, targettype);
			int rs=ps.executeUpdate();
		}
		
		
		PreparedStatement ps11=con.prepareStatement("select * from bankaccount where Accountid=? and accounttype=?");
		ps11.setLong(1,targetid );
		ps11.setString(2, targettype);
		
		ResultSet rs11=ps11.executeQuery();
		while(rs11.next())
		{ custid1=rs11.getLong(1);
			amount1=rs11.getDouble(4);
			updated1=rs11.getTimestamp(6);
		}
		
		PreparedStatement ps12=con.prepareStatement("select transaction_seq.nextval from dual ");
		ResultSet rs12=ps12.executeQuery();
		if ( rs12.next() ) {
			  tran_id1 = rs12.getInt(1);
			}
		
		PreparedStatement ps13=con.prepareStatement("insert into banktransactions values(?,?,?,?,?,?,?,?,?) ");
		ps13.setLong(1, tran_id1);
		ps13.setLong(2, custid);
		ps13.setString(3, sourcetype);
		ps13.setDouble(4, amount);
		ps13.setTimestamp(5,(Timestamp) updated);
		ps13.setString(6, targettype);
		ps13.setString(7, "transfer");
		ps13.setDouble(8, tmoney);
		ps13.setLong(9, targetid);
		int k2=ps13.executeUpdate();
		if(k2>0){
			check1=true;}
		if(check1==true)
			result1=true;
		
		
	}
	
	catch(SQLException | DataLayerException e)
	{
		System.out.println(e.getMessage());
	}
			
	return result1;
	
}
	public ArrayList<Transactions> ministatement(int not,long cid,String accounttype ) throws DataLayerException{
		ArrayList<Transactions> temp=new ArrayList<Transactions>();
		try
		{
			Connection con=DBUtil.createConnection();
			PreparedStatement ps=con.prepareStatement("SELECT transactionid,CAST(transactiondate AS DATE),description,transferedamount FROM banktransactions WHERE custoid=? and accountype=?");
			ps.setLong(1, cid);
			ps.setString(2, accounttype);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				if(i<not){
				long tranid=rs.getLong(1);
				Date date=rs.getDate(2);
				String description=rs.getString(3);
				double balance=rs.getDouble(4);
				
				Transactions t=new Transactions(tranid,balance,date,description);
				temp.add(t);
				}
				i++;
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return temp;
		
	}
	public ArrayList<Transactions> ministatementdate(long cid,String accounttype,String d1,String d2) throws DataLayerException{
		ArrayList<Transactions> temp=new ArrayList<Transactions>();
		try
		{
			Connection con=DBUtil.createConnection();
			Date d3=null;
			Date d4=null;
			String d5=null;
			Date d6=null;
			//SELECT CAST(transactiondate AS DATE) FROM banktransactions;
			PreparedStatement ps=con.prepareStatement("SELECT transactionid,CAST(transactiondate AS DATE),description,transferedamount FROM banktransactions WHERE custoid=? and accountype=?");
			ps.setLong(1, cid);
			ps.setString(2, accounttype);
			ResultSet rs=ps.executeQuery();
			int i=0;
			try{
				DateFormat f=new SimpleDateFormat("yyyy-mm-dd");
			 d3=f.parse(d1);
			 d4=f.parse(d2);
				}
				catch(Exception e){
					System.out.println(e);
				}
			while(rs.next())
			{
			//	public boolean datev(Date d1,Date d2){
				try{
					DateFormat f=new SimpleDateFormat("yyyy-mm-dd");
				 d5=f.format(rs.getDate(2));
				d6=f.parse(d5);
					}
					catch(Exception e){
						System.out.println(e);
					}
				
					 if(d6.compareTo(d3)>0){
						 if(d6.compareTo(d4)<0)
						 {
							 System.out.println("kavya");
				
				long tranid=rs.getLong(1);
				Date date=rs.getDate(2);
				String description=rs.getString(3);
				double balance=rs.getDouble(4);
				
				Transactions t=new Transactions(tranid,balance,date,description);
				temp.add(t);
				}
						 }
				i++;
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return temp;
		
	}
}