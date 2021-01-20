<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
 <%@ page import="com.tcs.bean.AccountStatus" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/view_account_status</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
</head>
<body>
	<% /*List<Account> accountList = (ArrayList<Amount>)request.getAttribute(" ");*/ %>

	<div class="header">
		<h1>BANK</h1>
		<div class="executive-nav">
			<ul>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/executive_Home.jsp" ><i class="material-icons">home</i>Home</a></li>
				<li>
					<div class="dropdown">
						<button class="nav-btn">Customer Management<i class="material-icons" style="font-size:18px">arrow_drop_down</i></button>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath() %>/jsp/create_customer.jsp">Create Customer</a>
    						<a href="<%=request.getContextPath() %>/jsp/deletecustomer.jsp">Delete Customer</a>
    					</div>
    				</div>
				</li>
				<li>
					<div class="dropdown">
						<button class="nav-btn">Account Management<i class="material-icons" style="font-size:18px">arrow_drop_down</i></button>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath() %>/jsp/create_account.jsp">Create Account</a>
    						<a href="<%=request.getContextPath() %>/jsp/delete_account.jsp">Delete Account</a>
    					</div>
    				</div>
				</li>
				<li>
					<div class="dropdown">
						<button class="nav-btn">Status Details<i class="material-icons" style="font-size:18px">arrow_drop_down</i></button>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath()%>/BankController?status=CustomerStatus">Customer Status</a>
    						<a href="<%=request.getContextPath()%>/BankController?status=CustomerStatus">Account Status</a>
    					</div>
    				</div>
				</li>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/login.jsp" ><i class="material-icons">power_settings_new</i>Logout</a></li>
			</ul>
		</div>
	</div>
	<div class=view-content>
		<h3>Account Status</h3>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		<%
	ArrayList<AccountStatus> Alist=(ArrayList<AccountStatus>) request.getAttribute("list");
	if(Alist!=null) {
		
%>
		<form action="<%=request.getContextPath() %>/BankController">
			<table class="view_table" align="center">
				<tr>
					<th>Customer ID</th>
					<th>Account ID</th>
					<th>Account Type</th>
					<th>Account Status</th>
					<th>Message</th>
					<th>Last Updated</th>
					<th>Operations</th>
				</tr>
				<%
		for(AccountStatus e:Alist) {
%>
							<tr>
								<td><%=e.getCustid() %></td>
								<td><%=e.getAccid() %></td>
								<td><%=e.getCusttype() %></td>
								<td><%=e.getStatus()%></td>
								<td><%=e.getMessage() %></td>
								<td><%=e.getLastUpdated() %></td>
									<td><a class="link" href="<%=request.getContextPath()%>/BankController?status=UpdateCustomer&customerid=<%=e.getCustid()%>">Update</a></td>
								
							</tr>
				<%		}
%>
			</table>
			<%
	}
	%>
		</form>
	</div>
	<a class="link" href="executive_Home.jsp">Home</a>
	<div class="view-footer">
		----------------------------------------
	</div>
</body>
</html>