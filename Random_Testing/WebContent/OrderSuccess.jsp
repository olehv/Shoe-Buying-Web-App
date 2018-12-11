<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%!
ResultSet orders=null;
com.web.ConnectionFactory connection = new com.web.ConnectionFactory();
com.web.Customer customer = null;
com.web.Order order = null;
HttpSession session = null;
%>
<%

try {
	session = request.getSession();
	customer =	(com.web.Customer)session.getAttribute("customer");
	order = (com.web.Order) session.getAttribute("currentOrder");
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


Success!
Customer Information:
<%=customer.toString() %>
<br>
Order Information:
<%=order.toString() %>
<br>
<form name ="orderSuccess" method="get" action="OrderSuccessController">
<input type="submit" value="Click here to Return to the Main Menu">
</form>
</body>
</html>