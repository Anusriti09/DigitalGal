<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-image: url("img/background.jpeg");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
}
div {font-size: 25px;height: 100px;
  width: 250px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 40%; margin-bottom:20%}
</style>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div>
	<form action="Home" method="post">
		<table>
			<tr>
				<td><label>Registered User</label>
				<input type="submit" name ="act" value="Sign In"></td>
			</tr>
			<tr>
				<td><label>New User</label>
				<input type="submit" name ="act" value="Sign Up"></td>
			</tr>
			<tr>
				<td><label>Admin</label>
				<input type="submit" name ="act" value="Admin Login"></td>
			</tr>
		</table>
	</form></div>
</body>
</html>