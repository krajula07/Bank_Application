package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.tcs.bean.Account;
import com.tcs.bean.AccountStatus;
import com.tcs.bean.Customer;
import com.tcs.bean.Transactions;
import com.tcs.exception.DataLayerException;
import com.tcs.service.BankService;

/**
 * Servlet implementation class BankController
 */
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		BankService service = new BankService();
		System.out.println(status);
		RequestDispatcher rd;
		
		try{
		
		if("login".equalsIgnoreCase(status)){
			String username = request.getParameter("userName");
			String password = request.getParameter("pass");
			if(username!=null && !username.trim().equals("") && password!=null && !password.trim().equals("")){
				try {
					ArrayList<String> result = service.searchUser(username, password);
					if(result!=null && result.get(2).equalsIgnoreCase("executive")){
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(10);
						session.setAttribute("executive_name", result.get(0));
						session.setAttribute("lastLogIn", result.get(1));
						response.sendRedirect("jsp/executive_Home.jsp");
					}
					else if(result!=null && result.get(2).equalsIgnoreCase("cashier")){
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(10);
						session.setAttribute("executive_name", result.get(0));
						session.setAttribute("lastLogIn", result.get(1));
						response.sendRedirect("jsp/search_account.jsp");
					}else{
						HttpSession session = request.getSession();
						session.setMaxInactiveInterval(1);
						session.setAttribute("status", "error");
						session.setAttribute("message", "Invalid User Credentials");
						response.sendRedirect("jsp/login.jsp");
					}
				} catch (Exception e) {
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(1);
					session.setAttribute("status", "error");
					session.setAttribute("message", e.getMessage());
					response.sendRedirect("jsp/login.jsp");
				}
			}else{
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1);
				session.setAttribute("status", "error");
				session.setAttribute("message", "Please enter all the details");
				response.sendRedirect("jsp/login.jsp");
			}
		}else if("CreateCustomer".equals(status)){
			String ssnid1=request.getParameter("ssnId");
			String cusname=request.getParameter("cus_name");
			String age1=request.getParameter("age");
			String address=request.getParameter("address");
			int age=Integer.parseInt(age1);
			long ssnid=Long.parseLong(ssnid1);
			Customer customer =new Customer(ssnid,cusname,address,age);
			boolean result = false;
			
			
					try {
						result = service.addCustomer(customer);
					} catch (DataLayerException e) {
						rd=request.getRequestDispatcher("jsp/create_customer.jsp");
						request.setAttribute("status", "error");
						request.setAttribute("message", "Please Enter Valid Id...");
						rd.forward(request, response);
					} 
					System.out.println(result);
				if(result==true){
					System.out.println(ssnid);
					Customer c=service.searchCustom(ssnid);
					System.out.println(c);
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(5);
					session.setAttribute("customer", c.getCustomerId());
						session.setAttribute("status", "success");
					session.setAttribute("message", "customer successfully created.Create the account");
						response.sendRedirect("jsp/accountext.jsp");
				}
				else{
					rd=request.getRequestDispatcher("jsp/create_customer.jsp");
					request.setAttribute("status", "error");
					request.setAttribute("message", "Please Enter Valid Id...");
					rd.forward(request, response);
				}
		}else if("CreateAccountExte".equals(status)){
		String cusid=request.getParameter("cus_id");
			String ac_type=request.getParameter("ac_type");
			String amount=request.getParameter("Amount");
			double amount1=Double.parseDouble(amount);
			long cusid1=Long.parseLong(cusid);
			boolean search=service.searchCust(cusid1);
			System.out.println(search);
			try{
			if(search==true){
				Account a=new Account(cusid1,ac_type,amount1);
				boolean create =service.createAccount(a, cusid1);
				if(create==true){
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(5);
						session.setAttribute("status", "success");
						session.setAttribute("message", "account created successfully! ");
						response.sendRedirect("jsp/success.jsp");
					
				}else{
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(5);
						session.setAttribute("status", "error");
						session.setAttribute("message", "only one account can be created");
						response.sendRedirect("jsp/create_account.jsp");
							
							//rd.forward(request, response);
					}
			}else{
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(5);
					session.setAttribute("status", "error");
					session.setAttribute("message", "problem encountered in account creation.Please try again!");
					response.sendRedirect("jsp/create_account.jsp");
			}}
			catch(Exception e){
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(5);
					session.setAttribute("status", "error");
					session.setAttribute("message", "problem encountered in account creation.Please try again!");
					response.sendRedirect("jsp/create_account.jsp");
			}
		}else if("CreateAccount".equals(status)){
			String cusid=request.getParameter("cus_id");
			String ac_type=request.getParameter("ac_type");
			String amount=request.getParameter("Amount");
			double amount1=Double.parseDouble(amount);
			long cusid1=Long.parseLong(cusid);
			boolean search=service.searchCust(cusid1);
			System.out.println(search);
			try{
			if(search==true){
				Account a=new Account(cusid1,ac_type,amount1);
				boolean create =service.createAccount(a, cusid1);
				if(create==true){
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(5);
						session.setAttribute("status", "success");
						session.setAttribute("message", "account created successfully! ");
						response.sendRedirect("jsp/success.jsp");
					
				}else{
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(5);
						session.setAttribute("status", "error");
						session.setAttribute("message", "only one account can be created");
						response.sendRedirect("jsp/create_account.jsp");
							
							//rd.forward(request, response);
					}
			}else{
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(5);
					session.setAttribute("status", "error");
					session.setAttribute("message", "problem encountered in account creation.Please try again!");
					response.sendRedirect("jsp/create_account.jsp");
			}}
			catch(Exception e){
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(5);
					session.setAttribute("status", "error");
					session.setAttribute("message", "problem encountered in account creation.Please try again!");
					response.sendRedirect("jsp/create_account.jsp");
			}
		}
		else if("Delete".equals(status)){
			String ssnid1=request.getParameter("ssnId");
			String cusid=request.getParameter("cus_id");
			String cusname=request.getParameter("cust_name");
			String age1=request.getParameter("age");
			String address=request.getParameter("address");
			int age=Integer.parseInt(age1);
			long cusid1=Long.parseLong(cusid);

			long ssnid=Long.parseLong(ssnid1);
			Customer customer =new Customer(ssnid,cusname,address,age);
			boolean result = false;
			boolean result1=false;
			System.out.println(ssnid);
			System.out.println(cusname);
			System.out.println(address);
			System.out.println(age);
					try {
						result = service.searchCust1(cusid1, ssnid, cusname, address, age);
					} catch (DataLayerException e) {
						/*rd=request.getRequestDispatcher("jsp/create_customer.jsp");
						request.setAttribute("status", "error");
						request.setAttribute("message", "Please Enter Valid Id...");
						rd.forward(request, response);*/
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
							session.setAttribute("status", "error");
							session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
							response.sendRedirect("jsp/delete_customer.jsp");
					} 
					System.out.println(result);
				if(result==true){
					try {
						 result1 = service.deleteCustomer(cusid1);
					} catch (DataLayerException e) {
						/*request.setAttribute("status", "error");
						request.setAttribute("message", "Please Enter crrct credentials...");
						rd=request.getRequestDispatcher("jsp/delete_customer.jsp");
						
						rd.forward(request, response);*/
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
							session.setAttribute("status", "error");
							session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
							response.sendRedirect("jsp/delete_customer.jsp");
					} 
					if(result1==true){
						/*request.setAttribute("status", "success");
						request.setAttribute("message", "Succesfully deleted");
						rd=request.getRequestDispatcher("jsp/success.jsp");
						
						rd.forward(request, response);*/
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
							session.setAttribute("status", "success");
							session.setAttribute("message", "succesfully deleted");
							response.sendRedirect("jsp/success.jsp");
					}
					else{
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
							session.setAttribute("status", "error");
							session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
							response.sendRedirect("jsp/delete_customer.jsp");
					}
				}
				
		}
				
				else if("DeleteAccount".equals(status)){
					String accountid=request.getParameter("acc_id");
				
					String ac_type=request.getParameter("acc_type");
					long acctid=Long.parseLong(accountid);
					boolean result=false;
					boolean result1=false;
					
					System.out.println(acctid);
					System.out.println(ac_type);
							try {
								result = service.searchaccount(acctid, ac_type);
							} catch (DataLayerException e) {
								/*rd=request.getRequestDispatcher("jsp/create_customer.jsp");
								request.setAttribute("status", "error");
								request.setAttribute("message", "Please Enter Valid Id...");
								rd.forward(request, response);*/
								HttpSession session=request.getSession();
								session.setMaxInactiveInterval(1);
									session.setAttribute("status", "error");
									session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
									response.sendRedirect("jsp/delete_account.jsp");
							} 
							System.out.println(result);
						if(result==true){
							try {
								 result1 = service.deleteAccount(acctid);
							} catch (DataLayerException e) {
								/*request.setAttribute("status", "error");
								request.setAttribute("message", "Please Enter crrct credentials...");
								rd=request.getRequestDispatcher("jsp/delete_customer.jsp");
								
								rd.forward(request, response);*/
								HttpSession session=request.getSession();
								session.setMaxInactiveInterval(1);
									session.setAttribute("status", "error");
									session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
									response.sendRedirect("jsp/delete_account.jsp");
							} 
							if(result1==true){
								/*request.setAttribute("status", "success");
								request.setAttribute("message", "Succesfully deleted");
								rd=request.getRequestDispatcher("jsp/success.jsp");
								
								rd.forward(request, response);*/
								HttpSession session=request.getSession();
								session.setMaxInactiveInterval(1);
									session.setAttribute("status", "success");
									session.setAttribute("message", "succesfully deleted");
									response.sendRedirect("jsp/success.jsp");
							}
							else{
								HttpSession session=request.getSession();
								session.setMaxInactiveInterval(1);
									session.setAttribute("status", "error");
									session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
									response.sendRedirect("jsp/delete_account.jsp");
							}
						}
				else{
					/*request.setAttribute("status", "error");
					request.setAttribute("message", "Please correct credentials...");

					rd=request.getRequestDispatcher("jsp/delete_customer.jsp");
										rd.forward(request, response);*/
					HttpSession session=request.getSession();
					session.setMaxInactiveInterval(1);
						session.setAttribute("status", "error");
						session.setAttribute("message", "Delete operation is unsuccessful.Try again!");
						response.sendRedirect("jsp/delete_account.jsp");
				}
				}
				else if("CustomerStatus".equals(status)){
					ArrayList<AccountStatus> temp=service.viewStatus();
					
					rd=request.getRequestDispatcher("jsp/view_customer_status.jsp");
					request.setAttribute("list", temp);
					rd.forward(request, response);
					
				}
				else if("UpdateCustomer".equals(status)){
					String customerid=request.getParameter("customerid");
					long custid=Long.parseLong(customerid);
					Customer customer=service.searchCustomer(custid);
					rd=request.getRequestDispatcher("jsp/update_customer.jsp");
					request.setAttribute("customer", customer);
					rd.forward(request, response);
				}
				else if("Update".equals(status)){
					String name=request.getParameter("new_cust_name");
					String age=request.getParameter("new_age");
					String address=request.getParameter("new_address");
					String id=request.getParameter("custid");
					int age1=Integer.parseInt(age);
					long id1=Long.parseLong(id);
					boolean s=service.updateCustomer(name, address, age1, id1);
					if(s==true){
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
						session.setAttribute("status", "success");
						session.setAttribute("message", "updated successfully");
						response.sendRedirect("jsp/success.jsp");
					}
					
					
				}
				else if("Search".equals(status)){
					System.out.println("kavya");
					long custid=0;
					long actid=0;
					String customerid=request.getParameter("cus_id");
					String accountid=request.getParameter("acc_id");
					try{
						if(customerid!=null){
					custid=Long.parseLong(customerid);}
					}catch(NumberFormatException e){
						custid=0;
					}
					try{
						if(accountid!=null)
				               actid=Long.parseLong(accountid);}
					catch(NumberFormatException e){
						actid=0;
					}
					System.out.println(custid);
					System.out.println(actid);
					boolean result=service.searchaccountstatus(actid);
					boolean result1=service.searchaccountstatus1(custid);
					ArrayList<Account> account=service.searchAccount(actid, custid);
					
					if(account.size()!=0){
					rd=request.getRequestDispatcher("jsp/function.jsp");
					request.setAttribute("account", account);
					rd.forward(request, response);
					}else{
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
						session.setAttribute("status", "error");
						session.setAttribute("message", "Please enter correct details");
						response.sendRedirect("jsp/search_account.jsp");
					}
					}
					
					
					
				else if("DepositAmount".equals(status)){
					String aid=request.getParameter("accountid");
					long accountid=Long.parseLong(aid);
					Account a=service.searchaccountwithid(accountid);
					
					rd=request.getRequestDispatcher("jsp/deposit.jsp");
					request.setAttribute("account", a);
					rd.forward(request, response);
				}else if("Deposit".equals(status)){
					
					String amount=request.getParameter("deposit_amount");
					double amount1=Double.parseDouble(amount);
					System.out.println(amount1);
					String accountid=request.getParameter("accountid");
					long accountid1=Long.parseLong(accountid);
					System.out.println(accountid1);
					boolean result=service.searchaccountstatus(accountid1);
					if(result==true && amount1>0){
					Account a=service.searchaccountwithid(accountid1);
					boolean s=service.depositMoney(accountid1, a.getAccountType(), amount1);
					if(s==true){
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
						session.setAttribute("status", "success");
						session.setAttribute("message", "updated successfully");
						response.sendRedirect("jsp/cashiersuccess.jsp");
					}
					
					}else{
						HttpSession session=request.getSession();
						session.setMaxInactiveInterval(1);
						session.setAttribute("status", "success");
						session.setAttribute("message", "Amount cannot be deposited.Check and try again!");
						response.sendRedirect("jsp/cashiersuccess.jsp");
					}
					}
					else if("WithdrawAmount".equals(status)){
						String aid=request.getParameter("accountid");
						long accountid=Long.parseLong(aid);
						Account a=service.searchaccountwithid(accountid);
						rd=request.getRequestDispatcher("jsp/withdraw.jsp");
						request.setAttribute("account", a);
						rd.forward(request, response);
					}else if("Withdraw".equals(status)){
						
						String amount=request.getParameter("deposit_amount");
						double amount1=Double.parseDouble(amount);
						System.out.println(amount1);
						String accountid=request.getParameter("accountid");
						long accountid1=Long.parseLong(accountid);
						System.out.println(accountid1);
						boolean result=service.searchaccountstatus(accountid1);
						if(result==true && amount1>0){
						Account a=service.searchaccountwithid(accountid1);
						boolean s=service.depositMoney(accountid1, a.getAccountType(), amount1);
						
						if(s==true){
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
							session.setAttribute("status", "success");
							session.setAttribute("message", "updated successfully");
							response.sendRedirect("jsp/cashiersuccess.jsp");
						}}
						else{
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
							session.setAttribute("status", "success");
							session.setAttribute("message", "Insufficient balance!");
							response.sendRedirect("jsp/cashiersuccess.jsp");
						}
					}
					
					else if("Transfer".equals(status)){
						System.out.println("kavya");
						String amount=request.getParameter("deposit_amount");
						System.out.println(amount);
						double amount1=Double.parseDouble(amount);
						System.out.println(amount1);
						String accountid=request.getParameter("accountid");
						long accountid1=Long.parseLong(accountid);
						System.out.println(accountid1);
						String targetid=request.getParameter("scid");
						long targetid1=Long.parseLong(targetid);
						System.out.println(targetid1);
						boolean result=service.searchacntwithid(targetid1);
						Account a1=service.searchaccountwithid(targetid1);
						Account a=service.searchaccountwithid(accountid1);
						boolean resultf=service.searchaccountstatus(accountid1);
						System.out.println(amount1);
						if(resultf==true){
							boolean resultx=service.searchaccountstatus(targetid1);
								if(resultx==true){
						try{
						if(result==true && amount1>0){
						
						boolean s=service.transferMoney(accountid1, a.getAccountType(),targetid1,a1.getAccountType(), amount1);
			if(s==true){
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
							session.setAttribute("status", "success");
							session.setAttribute("message", "updated successfully");
							response.sendRedirect("jsp/cashiersuccess.jsp");
						}else{
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
								session.setAttribute("status", "error");
								session.setAttribute("message", "Transaction failed");
								response.sendRedirect("jsp/cashiersuccess.jsp");
						}
						}else{
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
								session.setAttribute("status", "error");
								session.setAttribute("message", "Transaction failed");
								response.sendRedirect("jsp/cashiersuccess.jsp");
						}
						
					}
						catch(NullPointerException e){
							System.out.println(e.getMessage());
						}}
						else{
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
								session.setAttribute("status", "error");
								session.setAttribute("message", "Transaction failed");
								response.sendRedirect("jsp/cashiersuccess.jsp");
						}}else{
							HttpSession session=request.getSession();
							session.setMaxInactiveInterval(1);
								session.setAttribute("status", "error");
								session.setAttribute("message", "Transaction failed");
								response.sendRedirect("jsp/cashiersuccess.jsp");
						}
						
}
					
					else if("TransferAmount".equals(status)){
						String aid=request.getParameter("accountid");
						long accountid=Long.parseLong(aid);
						Account a=service.searchaccountwithid(accountid);
						rd=request.getRequestDispatcher("jsp/transfer.jsp");
						request.setAttribute("account", a);
						rd.forward(request, response);
					}
else if("ViewStatement".equals(status)){
	String aid=request.getParameter("accountid");
	long aid1=Long.parseLong(aid);
	
	//System.out.println(service.searchacntwithid(aid1));
	
	Account a=service.searchaccountwithid(aid1);
	String not=request.getParameter("noOfTransactions");
	int nooftransactions=Integer.parseInt(not);
	
	
		

	System.out.println(a);
	
	try{
		System.out.println(aid1);
		
		ArrayList<Transactions> transactions=service.ministatement(nooftransactions, a.getCustomerId(), a.getAccountType());
		request.setAttribute("transactions", transactions);
		rd=request.getRequestDispatcher("jsp/List.jsp");
		rd.forward(request, response);
	}catch(Exception e){
		
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(1);
				session.setAttribute("status", "error");
				session.setAttribute("message", "Please enter correct ID!");
				response.sendRedirect("jsp/view_statement.jsp");
		
	}
		
}else if("ViewDateStatement".equals(status)){
	String aid=request.getParameter("accountid");
	long aid1=Long.parseLong(aid);
	
	//System.out.println(service.searchacntwithid(aid1));
	
	Account a=service.searchaccountwithid(aid1);
	String startdate=request.getParameter("startdate");
	String enddate=request.getParameter("enddate");
	System.out.println(a);
	
	try{
		System.out.println(aid1);
		
		ArrayList<Transactions> transactions=service.ministatementdate(a.getCustomerId(),a.getAccountType(), startdate, enddate);
		request.setAttribute("transactions", transactions);
		rd=request.getRequestDispatcher("jsp/List.jsp");
		rd.forward(request, response);
	}catch(Exception e){
		
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(1);
				session.setAttribute("status", "error");
				session.setAttribute("message", "Please enter correct ID!");
				response.sendRedirect("jsp/view_datestatement.jsp");
		
	}
		
}else if("Searchcustomerfordelete".equals(status)){
	System.out.println("kavya");
//	long custid=0;
	long actid=0;
	
	String accountid=request.getParameter("acc_id");
	
	try{
		if(accountid!=null)
               actid=Long.parseLong(accountid);}
	catch(NumberFormatException e){
		actid=0;
	}
	
	Customer account=service.searchCustomer(actid);
	if(account!=null){
	rd=request.getRequestDispatcher("jsp/delete_customer.jsp");
	request.setAttribute("customer", account);
	rd.forward(request, response);
	}else{
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1);
		session.setAttribute("status", "error");
		session.setAttribute("message", "Please enter correct details");
		response.sendRedirect("jsp/deletecustomer.jsp");
	}
}
					
		}
		
		
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
