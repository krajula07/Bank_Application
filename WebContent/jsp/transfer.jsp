<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tcs.bean.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/deposit</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<script type="text/javascript">
		
	function create_account(){
		//alert("kavya");
		var cus_id = document.getElementById("scid").value.trim();
		
		var  Amount= document.getElementById("deposit_amount").value.trim();
		
		if(cus_id==''){
			alert('enter id');
			return false;
		}
		else if(cus_id.length!=9){
			alert('id length should be 9');
			return false;
		}
		else if(Amount==''){
			alert('enter amount');
			return false;
		}else if(isNan(Amount)){
			alert('enter number');
			return false;}
		return true;
		}
		
	
	
		
		
		
		
		</script>
</head>
<body>
	<div class="header">
		<h1>BANK</h1>
		<div class="cashier-nav">
			<ul>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/search_account.jsp" ><i class="material-icons">home</i>Home</a></li>
				<li>
					<div class="dropdown">
						<button class="nav-btn">Account Operations<i class="material-icons" style="font-size:18px">arrow_drop_down</i></button>
						<div class="dropdown-content">
							<a href="<%=request.getContextPath() %>/jsp/deposit.jsp">Deposit</a>
    						<a href="<%=request.getContextPath() %>/jsp/withdraw.jsp">Withdraw</a>
    						<a href="<%=request.getContextPath() %>/jsp/transfer.jsp">Transfer</a>
    					</div>
    				</div>
				</li>
				<li><a  href="<%=request.getContextPath() %>/jsp/view_statement.jsp" ><button class="nav-btn">Mini Statement</button></a></li>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/choose.jsp" ><i class="material-icons">power_settings_new</i>Logout</a></li>
			</ul>
		</div>
	</div>

	<div class=deposit-content>
		<h2>Deposit Money</h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		<%
	Account a=(Account)request.getAttribute("account");
%>
		<form action="<%=request.getContextPath() %>/BankController">
			<table class="deposit_table" align="center">
				<tr>
					<th>Customer ID</th>
					<td width=20px>:</td>
					<td><%= a.getCustomerId() %></td>
				</tr> 
				<%-- <tr>
					<th>Account ID</th>
					<td width=20px>:</td>
					<td><%= a.getAccountId() %></td>
				</tr> --%>
				<tr>
					<th>Account Type</th>
					<td width=20px>:</td>
					<td><%=a.getAccountType()%></td>
				</tr>
				<tr>
					<th>source id<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="scid" id="scid" placeholder="id"></td>
				</tr>
				<tr>
					<th>Deposit Amount(INR)<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="deposit_amount" id="deposit_amount" placeholder="Amount"></td>
				</tr>
			</table>
			
			<input type="hidden" name="accountid" id="accountid" value=<%=a.getAccountId()%> >
			<input class="button" type="submit" name="status" value="Transfer" onclick="return create_account();">
		</form>
	</div>
	
	<div class="view-footer">
		----------------------------------------
	</div>
</body>
</html>