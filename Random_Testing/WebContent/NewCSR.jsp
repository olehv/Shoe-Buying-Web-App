<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New CSR</title>
</head>

<header>
	<table style="height: 27px; background-color: #434fad; color: white; border: none;" width="100%">
		<tbody>
			<tr style="height: 57px;">
				<td style="width: 20%; height: 57px; border: none;"><input type="button" value="Log Out" /></td>
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>New CSR</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;">Welcome</td>
			</tr>
		</tbody>
	</table>
</header>

<body>

	<table align="center">
			<tr>
				<td>
					<h4>New CSR</h4>
				</td>
			</tr>
			
			
			<tr>
				<td>

					<form name ="NewCSR" method="get" action="NewCSRController">

					
					<table>
						<tr>
							<td>Enter a Username:</td><td> <input type="text" name="userName" placeholder="Username"></td>
						</tr>
						<tr>
							<td>Enter a Password: </td> <td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td>Enter First Name: </td><td> <input type="text" name="firstName" placeholder="First Name"></td>
						</tr>
						<tr>
							<td>Enter Last Name: </td><td> <input type="text" name="lastName" placeholder="Last Name"></td>
						</tr>
           				</table>
						<input type="submit" value="Submit"/>
					</form>
					
					
				</td>
			</tr>		
			
	</table> 

</body>
</html>