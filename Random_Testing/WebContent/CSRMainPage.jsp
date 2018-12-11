<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSRMainPage</title>
</head>

<%!
com.web.CSR csr = null;
HttpSession session = null;
%>
<%

try {
	session = request.getSession();
	csr =	(com.web.CSR)session.getAttribute("csr");
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
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome <%= csr.getFirstName() %></td>
			</tr>
		</tbody>
	</table>
</header>

<body>

<form action="CSRMainPageController" method="get">
<table align="center">
	<tr>
		<td>
			<input type="submit" name="action" value="Edit Order Details">
		</td>
		<td>
			<input type="submit" name="action" value="Add Shoes">
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="action" value="Edit Shoes">
		</td>
		<td>
			<input type="submit" name="action" value="Edit/Delete Customer">
		</td>
	</tr>
	
</table>

</form>





</body>
</html>