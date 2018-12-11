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
%>
<%

try {
	csr = (com.web.CSR)session.getAttribute("csr");
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
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Add a Shoe</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= csr.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

<body>

		<table align="center">
			<tr>
				<td>
					<h4 align="center">New Shoe Information</h4>
				</td>
			</tr>
			
			
			
			
			<tr>
				<td>
					<form name ="newShoe" method="get" action="CSRAddShoesController">
						<table>
							<tr>
								<td>Enter an Item Name:</td><td> <input type="text" name="itemName" placeholder="Item Name"></td>
							</tr>
							<tr>
								<td>Enter a Category: </td> <td><input type="radio" name="category" value="Mens"> Mens
																<input type="radio" name="category" value="womens" checked="checked" > Womens
																<input type="radio" name="category" value="Kids"> Kids 
								</td>
							</tr>
							<tr>
								<td>Enter a Shoe Size: </td><td> <input type="text" name="shoeSize" placeholder="Shoe Size (number)"></td>
							</tr>
							<tr>
								<td>Enter a Price: </td><td> <input type="text" name="price" placeholder="Price ex(19.99)"></td>
							</tr>
						</table>
						
						<input type="submit" value="Submit"/>
					</form>
					
					
				</td>
			</tr>		
			
	</table>



</body>
</html>