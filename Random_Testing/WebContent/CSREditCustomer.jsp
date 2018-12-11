<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
     import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
</head>

<%!
ResultSet customers=null;
com.web.ConnectionFactory connection = new com.web.ConnectionFactory();
com.web.CSR csr = null;
HttpSession session = null;
%>
<%

try {
	session = (HttpSession) request.getSession();
	csr = (com.web.CSR)session.getAttribute("csr");
	customers = connection.getAllCustomers();
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
<form action="CSREditCustomerController" method="get">
<div style="overflow:scroll; height:40%;">
<table style="width:100%">
<tr>
<td></td>
<td>Customer ID</td>
<td>User Name</td>
<td>First Name</td>
<td>Last Name</td>
<td>Address</td>
<td>City</td>
<td>Postal Code</td>
</tr>
<% 

while(customers.next()){    //Scriptlet ends here %>
					<tr>
					<%-- JSP expression --%>
					<td> <input type="radio" value="<%=customers.getInt("customerId") %>" name="customers" checked></td>
					<td> <%=customers.getInt("customerId") %> </td>
					<td> <%=customers.getString("userName") %> </td>
					<td> <%=customers.getString("firstName") %> </td>
					<td> <%=customers.getString("lastName") %> </td>
					<td> <%=customers.getString("address") %> </td>
					<td> <%=customers.getString("city") %> </td>
					<td> <%=customers.getString("postalCode") %> </td>
					</tr>
				<%
				}
%>
</table>
</div>
<input type="submit" value="Edit" name="action">
<input type="submit" value="Delete" name="action">
</form>
</body>
</html>