<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>

<title>Insert title here</title>
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
							<a href="<%=request.getContextPath() %>/jsp/view_customer_status.jsp">Customer Status</a>
    						<a href="<%=request.getContextPath() %>/jsp/view_customer_status.jsp">Account Status</a>
    					</div>
    				</div>
				</li>
				<li><a class="nav-btn" href="<%=request.getContextPath() %>/jsp/login.jsp" ><i class="material-icons">power_settings_new</i>Logout</a></li>
			</ul>
		</div>
	</div>
	<div class=create-content>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
						
				<%} else if(status!=null && "success".equalsIgnoreCase(status)){%>
						<font color="green" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
	</div>
	<div class="create-footer">
		----------------------------------------
	</div>
</body>
</html>