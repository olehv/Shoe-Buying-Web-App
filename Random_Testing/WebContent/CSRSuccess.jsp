<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Success! </title>
</head>


<header>
	<table style="height: 27px; background-color: #434fad; color: white; border: none;" width="100%">
		<tbody>
			<tr style="height: 57px;">
				<td style="width: 20%; height: 57px; border: none;"><input type="button" value="Log Out" /></td>
				<td style="width: 40%; text-align: center; height: 57px; border: none;"><h1>Main Page</h1></td>
				<td style="width: 20%; text-align: right; height: 57px; border: none;"> Success!</td>
			</tr>
		</tbody>
	</table>
</header>

<body>


Success!

<br>

<form name ="csrSuccess" method="get" action="CSRSuccessController">
<input type="submit" value="Click here to Return to the Main Menu">
</form>
</body>
</html>