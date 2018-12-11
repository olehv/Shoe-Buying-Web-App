<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Order</title>
</head>
<%!
com.web.Customer customer = null;
HttpSession session = null;
%>
<%

try {
	session = request.getSession();
	customer =	(com.web.Customer)session.getAttribute("customer");
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
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>New Order</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= customer.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

	<table align="center">
			<tr>
				<td>
					<h4 align="center">New Order Creation</h4>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<form name ="NewOrderCategory" method="get" action="CustomerOrderNewController">
						Select a Category:
						<table>
							<tr>
								<td>Mens:</td><td> <input type="radio" name="category" value="Mens" checked></td>
							</tr>
							<tr>
								<td>Womens: </td> <td><input type="radio" name="category" value="Womens"></td>
							</tr>
							<tr>
								<td>Kids: </td><td> <input type="radio" name="category" value="Kids"></td>
							</tr>
						</table>
						
						<input type="submit" value="Next"/>
					</form>
					
					
				</td>
			</tr>		
			
	</table> 

</body>
</html>