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
  width: 300px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 40%; margin-bottom:20%}
</style>
<meta charset="ISO-8859-1">
<title>Add Resource</title>
</head>
<body>
<div>
	<form action="Resource" method="post">
		<table>
			<tr>
				<td>Book Name</td>
				<td><input type="text" name="Bname" required></td>
				<td><input type="submit" value="Search" required></td>
			</tr>
		</table>
	</form></div>
</body>
</html>