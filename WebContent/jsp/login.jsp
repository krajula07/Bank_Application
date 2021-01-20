<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank/login</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/BankStyles.css"></link>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript">
		var index = 1;
		showImage(index);
		function plusIndex(i){
			index += i;
			showImage(index);
		}
		
		function showImage(n){
			var i;
			var x = document.getElementsByClassName("slides");
			if(n > x.length){index=1};
			if(n < 1){index=x.length};
		
			for(i=0;i<x.length;i++){
				x[i].style.display = "none";
			}
			x[index-1].style.display = "block";
		}
	
</script>
</head>
<body class="login-body">
<div class="container">
	<div class="login-header">
		<h1>BANK</h1>
	</div>
	<div class=image-container>
		<img class="slides" src="<%= request.getContextPath()%>/css/Bank-dream-home.jpg" alt="dream-home">
		<img class="slides" src="<%= request.getContextPath()%>/css/april-assured-discount-D.jpg" alt="travel-discount">
		<img class="slides" src="<%= request.getContextPath()%>/css/press-release-chanda-kochhar-D.jpg" alt="travel-discount">
		<img class="slides" src="<%= request.getContextPath()%>/css/secure-family-pnjjby-D.jpg" alt="travel-discount">
		<button class="btnleft" onclick = "plusIndex(-1)"> &#10094; </button>
		<button class="btnright" onclick = "plusIndex(1)"> &#10095; </button>
	</div>
	<div class=login-content>
		<h2 style="color:white">Employee Sign in </h2>
		<%String status = (String)session.getAttribute("status");
					if(status!=null && "error".equalsIgnoreCase(status)){%>
						<font color="red" size="5px"><%=session.getAttribute("message") %></font>
		<%} %>
		<form action="<%= request.getContextPath()%>/BankController" onsubmit="return validateUser()" method="get">
			<table  class="login_table" align="center">
				<tr><td colspan="2"><span class="font-red">Care:</span><span class="font-white">Username and Password are case sensitive</span></td></tr>
				<tr><td colspan="2"> &nbsp; </td></tr>
				<tr>
					<th>Username :</th>
					<td><input type="text" name="userName" id="userName" placeholder="User Name" ></td>
				</tr>
				<tr><td colspan="2"><span id="errUserName"></span></td></tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="pass" id="pass" placeholder="Password"></td>
				</tr>
				<tr><td  colspan="2"><span id="errPass"></span></td></tr>
			</table>
			<button class="button" type="submit" name="status" value="Login"><i class="material-icons">lock</i><font size="4pt"> Login</font> </button>
			<!-- <input class="button" type="button" name="action"  value="Forgot Password"> -->
		</form>
	</div>
	<div class="login-footer">
		----------------------------------------
	</div>
</div>
</body>
	<script>
			var myIndex = 0;
			carousel();
			
			function carousel() {
			    var i;
			    var x = document.getElementsByClassName("slides");
			    for (i = 0; i < x.length; i++) {
			       x[i].style.display = "none";  
			    }
			    myIndex++;
			    if (myIndex > x.length) {myIndex = 1}    
			    x[myIndex-1].style.display = "block";  
			    setTimeout(carousel, 5000); // Change image every 2 seconds
			}
	</script>
</html>