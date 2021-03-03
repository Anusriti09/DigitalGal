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
div {font-size: 25px;height: 140px;
  width: 130px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 45%; margin-bottom:18%}
</style>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<div>
	<form action="Dashboard" method="post">
		<table>
			<tr>
				<td><input type="submit" name ="act" value="Search Resource"></td>
			</tr>
			<tr>
				<td><input type="submit" name ="act" value="Payment"></td>
			</tr>
			<tr>
				<td><input type="submit" name ="act" value="Financial Aid"></td>
			</tr>
			<tr>
				<td><input type="submit" name ="act" value="Feedback"></td>
			</tr>
		</table>
	</form></div>
</body>
</html>