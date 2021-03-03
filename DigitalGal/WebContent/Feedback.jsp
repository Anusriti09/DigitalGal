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
div {font-size: 25px;height: 270px;
  width: 400px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 36%; margin-bottom:15%}
</style>
<meta charset="ISO-8859-1">
<title>Feedback</title>
</head>
<body>
	<div>
	<form action="Feedback" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required></td>
			</tr>
			<tr>
				<label for="feedback">Feedback</label><br/>
	        	<textarea name="feedback" cols="50" rows="10"></textarea>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form></div>
</body>
</html>