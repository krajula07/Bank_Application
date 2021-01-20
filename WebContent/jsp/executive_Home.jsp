<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/executive_Home</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	
	<div class="executive-home-content">
		<div class="accountMgmt-content">
			<h2> <i class="fa fa-list-alt" style="font-size:25px" ></i>Account Mangement</h2>
			<a class="button" href="create_account.jsp">Create Account</a><br>
			<a class="button" href="delete_account.jsp">Delete Account</a><br>
		</div>
		<div class="customerMgmt-content">
			<h2><i class="fa fa-users" style="font-size:25px"></i>Customer Management</h2>
			<a class="button" href="create_customer.jsp">Create Customer</a><br>
			<!-- <a class="button" href="update_customer.jsp">Update Customer</a><br> -->
			<a class="button" href="deletecustomer.jsp">Delete Customer</a>
		</div>
		<div class="accountMgmt-content">
			<h2> <i class="material-icons" style="font-size:25px">details</i>Status Details</h2>
			<a class="button" href="<%=request.getContextPath()%>/BankController?status=CustomerStatus">Customer Status</a><br>
			<a class="button" href="<%=request.getContextPath()%>/BankController?status=CustomerStatus">Account Status</a><br>
			
		</div>
	</div>
	<div class="footer">
		----------------------------------------
	</div>
</body>
</html>