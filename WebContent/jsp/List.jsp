<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
 <%@ page import="com.tcs.bean.Transactions" %> 
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
		<div class="cashier-nav">
			<ul>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/search_account.jsp" ><i class="material-icons">home</i>Home</a></li>
				<li>
					<div class="dropdown">
						<button class="nav-btn">Account Operations<i class="material-icons" style="font-size:18px">arrow_drop_down</i></button>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath() %>/jsp/search_account.jsp">Deposit</a>
    						<a href="<%=request.getContextPath() %>/jsp/search_account.jsp">Withdraw</a>
    						<a href="<%=request.getContextPath() %>/jsp/search_account.jsp">Transfer</a>
    					</div>
    				</div>
				</li>
				<li><a  href="<%=request.getContextPath() %>/jsp/choose.jsp" ><button class="nav-btn">Mini Statement</button></a></li>
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
	ArrayList<Transactions> Tlist=(ArrayList<Transactions>) request.getAttribute("transactions");
	if(Tlist!=null) {
		
%>
		<form action="<%=request.getContextPath() %>/BankController">
			<table class="view_table" align="center">
				<tr>
					<th>Transaction ID</th>
					<th>Date</th>
					<th>description</th>
					<th>Transfered amount</th>
					
				</tr>
				<%
		for(Transactions e:Tlist) {
%>
							<tr>
								<td><%=e.getTransactionid() %></td>
								<td><%=e.getTransactiondate() %></td>
								<td><%=e.getDescription()%></td>
								<td><%=e.getTransferedamount()%></td>
								
								
							</tr>
				<%		}
%>
			</table>
			<%
	}
	%>
		</form>
	</div>
	
	<div class="view-footer">
		----------------------------------------
	</div>
</body>
</html>