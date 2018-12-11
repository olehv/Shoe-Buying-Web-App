<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<%!
ResultSet orders=null;
com.web.ConnectionFactory connection = new com.web.ConnectionFactory();
com.web.Customer customer = null;
HttpSession session = null;
%>
<%

try {
	session = request.getSession();
	customer =	(com.web.Customer)session.getAttribute("customer");
	orders = connection.getOrders(customer);
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
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Main Page</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= customer.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>



<body>
<form action="CustomerMainPageController" method="get">
<div style="overflow:scroll; height:40%;">
<table style="width:100%">
<tr>
<td></td>
<td>Order ID</td>
<td>Item ID</td>
<td>Quantity</td>
<td>Order Date</td>
<td>Status</td>
</tr>
<% 

while(orders.next()){    //Scriptlet ends here %>
					<tr>
					<%-- JSP expression --%>
					<td> <input type="radio" value="<%=orders.getInt("orderId") %>" name="orders" checked></td>
					<td> <%=orders.getInt("orderId") %> </td>
					<td> <%=orders.getInt("itemId") %> </td>
					<td> <%=orders.getInt("quantity") %> </td>
					<td> <%=orders.getDate("orderDate") %> </td>
					<td> <%=orders.getString("status") %> </td>
					</tr>
				<%
					
				}
%>
</table>

</div>
<input type="submit" value="Edit Order" name="action"/>
<input type="submit" value="New Order" name="action"/>
</form>
</body>
</html>