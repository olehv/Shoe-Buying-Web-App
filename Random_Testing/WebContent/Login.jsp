<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page Designer Shoes</title>
</head>
<header>
	<table style="height: 27px; background-color: #434fad; color: white; border: none;" width="100%">
		<tbody>
			<tr style="height: 57px;">
				<td style="width: 20%; height: 57px; border: none;"></td>
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Log in</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;"></td>
			</tr>
		</tbody>
	</table>
</header>
	 

	<table align="center">
			<tr>
				<td>
					<h4>Login Option</h4>
				</td>
			</tr>
			  
			   
			<tr>
				<td>
					<form name ="login" method="get" action="LoginController">
						<input type="radio" name="user" value="customer" checked="checked" > Customer
						<input type="radio" name="user" value="csr"> CSR <br> <br>
						
						<input type="text" placeholder="Username" name="username"> <br> <br>
						<input type="password" placeholder="Password" name="password"><br>
						<br>
						<input type="submit" value="Log in"/>
						<br>
					</form>
					<br>
					<div style="text-align: center;">
					<a href="NewCustomer.jsp">New Customer?<br> Click Here</a><br><br>
					<a href="NewCSR.jsp"> New CSR?<br>Click Here</a>
					</div>
					
					
				</td>
			</tr>		
			
	</table> 

</body>
</html>