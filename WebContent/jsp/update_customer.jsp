<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.bean.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/update-customer</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<script type="text/javascript">
function createCustomer(){
		
		var  name= document.getElementById("new_cust_name").value.trim();
		var  age= document.getElementById("new_age").value.trim();
		var  address= document.getElementById("new_address").value.trim();
			
		
		
		
	if(name==''){
			alert('name');
			return false;
		}else if(age==''){
			alert('age');
			return false;
		}else if(isNan(age)){
			alert('enter age as number');
			return false;
		}else if(address==''){
			alert('enter the address');
			return false;
		}
		
		
		return true;
	}
	</script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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

	<div class=update-content>
		<h2>Update Customer </h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		<%
	Customer c=(Customer)request.getAttribute("customer");
%>
		<form action="<%=request.getContextPath() %>/BankController">
			<table class="update_table" align="center">
				<tr>
					<th>Customer SSN ID</th>
					<td width=20px>:</td>
					<td><%= c.getSSNID() %></td>
				</tr>
				<tr>
					<th>Customer ID</th>
					<td width=20px>:</td>
					<td><%=c.getCustomerId() %></td>
				</tr>
				<tr>
					<th>Old Customer Name</th>
					<td width=20px>:</td>
					<td><%=c.getName() %></td>
				</tr>
				<tr>
					<th>New Customer Name<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="new_cust_name" id="new_cust_name" placeholder="Name"></td>
				</tr>
				<tr>
					<th>Old Address</th>
					<td width=20px>:</td>
					<td><%=c.getAddress() %></td>
				</tr>
				<tr>
					<th>New Address<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="new_address" id="new_address" placeholder="New Address"></td>
				</tr>
				<tr>
					<th>Old Age</th>
					<td width=20px>:</td>
					<td><%= c.getAge() %></td>
				</tr>
				<tr>
					<th>New Age<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="new_age" id="new_age" placeholder="New Age"></td>
				</tr>
				
			</table>
			<input type="hidden" name="custid" id="custid" value=<%=c.getCustomerId() %>>
			<input class="button" type="submit" name="status" value="Update" onclick="return createCustomer();">
			<input class="button"type="reset" name="Status" value="Reset">
		</form>
	</div>
	
	<div class="footer">
		----------------------------------------
	</div>
</body>
</html>