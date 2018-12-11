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
int itemID = -1;
com.web.Shoe shoe = null;
%>
<%

try {
	session = request.getSession();
	csr = (com.web.CSR)session.getAttribute("csr");
	itemID = Integer.parseInt(session.getAttribute("currentItemID").toString());
	shoe = connection.getShoe(itemID);
	System.out.println(shoe.toString());
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
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Edit Shoe</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= csr.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

<body>

		<table align="center">
			<tr>
				<td>
					<h4 align="center">Edit Shoe Information</h4>
				</td>
			</tr>
			
			
			
			
			<tr>
				<td>
					<form name ="newShoe" method="get" action="CSREditShoesEditController">
						<table>
							<tr>
								<td>Enter an Item Name:</td><td> <input type="text" name="itemName" value="<%=shoe.getItemName() %>"></td>
							</tr>
							<tr>
								<td>Enter a Category: </td> <td><input type="radio" name="category" value="Mens" checked> Mens
																<input type="radio" name="category" value="womens" > Womens
																<input type="radio" name="category" value="Kids"> Kids 
								</td>
							</tr>
							<tr>
								<td>Enter a Shoe Size: </td><td> <input type="text" name="shoeSize" value="<%=shoe.getShoeSize() %>"></td>
							</tr>
							<tr>
								<td>Enter a Price: </td><td> <input type="text" name="price" value="<%=shoe.getPrice() %>"></td>
							</tr>
						</table>
						
						<input type="submit" value="Update"/>
					</form>
					
					
				</td>
			</tr>		
			
	</table>



</body>
</html>