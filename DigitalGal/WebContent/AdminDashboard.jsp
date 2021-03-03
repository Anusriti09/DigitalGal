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
div {font-size: 25px;height: 200px;
  width: 180px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 45%; margin-bottom:15%}
</style>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
<div>
	<form action="AdminDashboard" method="post">
		<table>
			<tr>
				<td><input type="submit" name="button" value="Add Book"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="Remove Book"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="View Members"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="View Books"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="View Financial Aid"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="Change Payment Status"></td>
			</tr>
		</table>
	</form></div>
</body>
</html>