<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Selection</title>
</head>

<%!
ResultSet shoes=null;
com.web.ConnectionFactory connection = new com.web.ConnectionFactory();
com.web.Customer customer = null;
HttpSession session = null;
int orderId = -1;
%>
<%

try {
	customer =	(com.web.Customer)session.getAttribute("customer");
	orderId = Integer.parseInt(session.getAttribute("currentOrderEdit").toString());
	shoes = connection.getAllShoes();
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
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Order Edit</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= customer.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

<body>
<div style="text-align:center"><h1>Edit Order for ID: <%=orderId %></h1></div>
<form action="CustomerOrderEditController" method="get">
<div style="overflow:scroll; height:40%;">
<table style="width:100%">
<tr>
<td></td>
<td>Item ID</td>
<td>Item Name</td>
<td>Shoe Size</td>
<td>Price</td>
</tr>
<% 

while(shoes.next()){    //Scriptlet ends here %>
					<tr>
					<%-- JSP expression --%>
					<td> <input type="radio" value="<%=shoes.getInt("itemId") %>" name="shoes" checked></td>
					<td> <%=shoes.getInt("itemId") %> </td>
					<td> <%=shoes.getString("itemName") %> </td>
					<td> <%=shoes.getInt("shoeSize") %> </td>
					<td> <%=shoes.getDouble("price") %> </td>
					</tr>
				<%
				}
%>
</table>
</div>
Quantity: <input type="number" name="quantity" min="1" max="69" step="1" pattern="[0-9]*"><br>
<input type="submit" value="Purchase">
</form>
</body>
</html>