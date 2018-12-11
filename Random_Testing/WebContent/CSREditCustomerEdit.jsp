CSREditCustomerEdit


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Shoe</title>
</head>

<%!
com.web.ConnectionFactory connection = new com.web.ConnectionFactory();
com.web.CSR csr = null;
HttpSession session = null;
com.web.Customer customer = null;
int customerId = -1;
%>
<%

try {
	session = (HttpSession) request.getSession();
	csr = (com.web.CSR)session.getAttribute("csr");
	customerId = Integer.parseInt(session.getAttribute("currentCustomerID").toString());
	customer = connection.getCustomer(customerId);
}
catch(Exception e) {
	out.print(e);
}
	%>

<header>
	<table style="height: 27px; background-color: #434fad; color: white; border: none;" width="100%">
		<tbody>
			<tr style="height: 57px;">
				<td style="width: 20%; height: 57px; border: none;">
				
				<form name="logoutbutton" method="get" action="Logout">
					<input type="submit" value="Logout">
				</form>
				
				</td>
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Edit Customer</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= csr.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

<body>

		<table align="center">
			<tr>
				<td>
					<h4 align="center">Edit Customer Information</h4>
				</td>
			</tr>
			
			
			
			
			<tr>
				<td>
					<form name ="newShoe" method="get" action="CSREditCustomerEditController">
						<table>
							<tr>
								<td>Enter an UserName:</td><td> <input type="text" name="userName" value="<%=customer.getUserName() %>"></td>
							</tr>
							<tr>
								<td>Enter a Password: </td> <td><input type="text" name="password" value="<%=customer.getPassword() %>"></td>
							</tr>
							<tr>
								<td>Enter a First Name: </td> <td><input type="text" name="firstName" value="<%=customer.getFirstName() %>"></td>
							</tr>
							<tr>
								<td>Enter a Last Name: </td> <td><input type="text" name="lastName" value="<%=customer.getLastName() %>"></td>
							</tr>
							<tr>
								<td>Enter an Address: </td> <td><input type="text" name="address" value="<%=customer.getAddress() %>"></td>
							</tr>
							<tr>
								<td>Enter a City: </td> <td><input type="text" name="city" value="<%=customer.getCity() %>"></td>
							</tr>
							<tr>
								<td>Enter a Postal Code: </td> <td><input type="text" name="postalCode" value="<%=customer.getPostalCode() %>"></td>
							</tr>
						</table>
						
						<input type="submit" value="Update"/>
					</form>
					
					
				</td>
			</tr>		
			
	</table>



</body>
</html>