<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/create_customer</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<script type="text/javascript">
function createCustomer(){
		var ssnId = document.getElementById("ssnId").value.trim();
		var  name= document.getElementById("cus_name").value.trim();
		var  age= document.getElementById("age").value.trim();
		var  address= document.getElementById("address").value.trim();
		 var  state= document.getElementById("state");
		var  city= document.getElementById("city"); 
		
	
		if(ssnId==''){
			alert('enter ssnid');
			return false;
		}
		else if(ssnId.length!=9){
			alert('ssnid length should be 9');
			return false;
		}
		
		else if(name==''){
			alert('name');
			return false;
		}else if(age==''){
			alert('age');
			return false;
		}else if(isNaN(age)){
			alert('enter age as number');
			return false;
		}else if(address==''){
			alert('enter the addess');
			return false;
		}else if(state.value==''){
			 alert('enter state');
			return false;
		}else if(city.value==''){
			alert('enter city');
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

	<div class=create-content>
		<h2>Create Customer </h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		
<%}  %>
		<form action="<%=request.getContextPath() %>/BankController" >
			<table class="create_table" align="center">
				<tr>
					<th>Customer SSN ID<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="ssnId" id="ssnId" placeholder="SSN ID"></td>
				</tr>
				<tr>
					<th>Customer Name<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="cus_name" id="cus_name" placeholder="Name"></td>
				</tr>
				<tr>
					<th>Age<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="age" id="age" placeholder="Age"></td>
				</tr>
				<tr>
					<th>Address<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td><input type="text" name="address" id="address" placeholder="Address"></td>
				</tr>
				<tr>
					<th>State<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td>
						<select name="State" id="State">
							<option value="Andhra Pradesh">Andhra Pradesh</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>City<span class="mandatory_asterisk">*</span></th>
					<td width=20px>:</td>
					<td>
						<select name="city" id="city">
							<option value="Hyderabad">Hyderabad</option>
							<option value="Chennai">Chennai</option>
						</select>
					</td>
				</tr>
			</table>
			<input class="button" type="submit" name="status" value="CreateCustomer" onclick="return createCustomer();">
			<input class="button"type="reset" name="Status" value="Reset">
		</form>
	</div>
	<div class="footer">
		----------------------------------------
	</div>
</body>
</html>