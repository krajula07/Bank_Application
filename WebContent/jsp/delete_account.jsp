<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tcs.bean.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/delete_account</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<script type="text/javascript">
function delete_account(){
		//alert("kavya");
		var cus_id = document.getElementById("acc_id").value.trim();
		 var  ac_type= document.getElementById("acc_type").value; 
		//var  Amount= document.getElementById("Amount").value.trim();
		
		if(cus_id==''){
			alert('enter id');
			return false;
		}
		else if(cus_id.length!=9){
			alert('id length should be 9');
			return false;
		}
		else if(ac_type==''){
			alert('enter account type');
			return false;
		}
		return true;
		}
		
	
	
		
		
		
		
		</script>
</head>
<body>
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
	<div class=delete-content>
		<h2>Delete Account </h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		
		<form action="<%=request.getContextPath() %>/BankController">
			<table class="delete_table" align="center">
				<tr>
					<th>Account ID<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="acc_id" id="acc_id" placeholder="Account ID"></td>
				</tr>
				
				<tr>
					<th>Account Type<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="acc_type" id="acc_type" placeholder="Account Type"></td>
				</tr>
			</table>
			<input class="button" type="submit" name="status" value="DeleteAccount" onclick="return delete_account();">
			<input class="button"type="reset" name="Status" value="Reset">
		</form>
	</div>
	<div class="create-footer">
		----------------------------------------
	</div>
</body>
</html>