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
  width: 350px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 40%; margin-bottom:20%}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="RemoveBook" method="post">
		<table>
			<tr>
				<td>Book Name</td>
				<td><input type="text" name="Bname" required></td>
			</tr>
			<tr>
				<td>Author Name</td>
				<td><input type="text" name="Aname" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="Remove"></td>
			</tr>
		</table>
	</form></div>
</body>
</html>