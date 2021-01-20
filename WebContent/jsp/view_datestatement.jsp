<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/view_statement</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<script type="text/javascript">
function create_account(){
	//alert("kavya");
	var cus_id = document.getElementById("accountid").value.trim();
	
	if(cus_id==''){
		alert('enter id');
		return false;
	}
	else if(cus_id.length!=9){
		alert('id length should be 9');
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
	
	<div class=view-statement-content>
		<h2>Account Statement</h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		<form action="<%= request.getContextPath()%>/BankController">
			<table class="account_statement_table" align="center">
				<tr>
					<th>Accountid</th>
					<td width=20px>:</td>
					<td><input type="text" name="accountid" id="accountid" placeholder="account id" ></td>
				</tr>
				<tr><td> &nbsp; </td></tr>
				
				<tr><td> &nbsp; </td></tr>
				<tr>
					<th>select Date</th>
					<td width=20px>:</td>
					<td>
						<select name="startdate" id="startdate">
							<option value="2018-04-21" selected>2018-04-21</option>
							<option value="2018-04-20" >2018-04-20</option>
							<option value="2018-04-19" >2018-04-19</option>
							<option value="2018-04-18">2018-04-18</option>
							<option value="2018-04-17">2018-04-17</option>
							<option value="2018-04-16">2018-04-16</option>
							<option value="2018-04-15">2018-04-15</option>
							<option value="2018-04-14">2018-04-14</option>
							<option value="2018-04-13">2018-04-13</option>
							<option value="2018-04-12">2018-04-12</option>
							<option value="2018-04-11">2018-04-11</option>
							<option value="2018-04-10">12018-04-10</option>
						</select>
					</td>
					<td>
						<select name="enddate" id="enddate">
						<option value="2018-04-21" selected>2018-04-21</option>
							<option value="2018-04-20">2018-04-20</option>
							<option value="2018-04-19">2018-04-19</option>
							<option value="2018-04-18">2018-04-18</option>
							<option value="2018-04-17">2018-04-17</option>
							<option value="2018-04-16">2018-04-16</option>
							<option value="2018-04-15">2018-04-15</option>
							<option value="2018-04-14">2018-04-14</option>
							<option value="2018-04-13">2018-04-13</option>
							<option value="2018-04-12">2018-04-12</option>
							<option value="2018-04-11">2018-04-11</option>
							<option value="2018-04-10">12018-04-10</option>
						</select>
					</td>
				</tr>
				
			</table>
			<input class="button" type="submit" name="status" value="ViewDateStatement" onclick="return create_account();">
		</form>
	</div>
	
	<div class="view-footer">
		----------------------------------------
	</div>
</body>
</html>