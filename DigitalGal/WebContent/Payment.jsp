<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Payment</title>
	<style>
body {
    background-image: url("img/background.jpeg");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
}
div {font-size: 25px;height: 350px;
  width: 420px; background-color: #EBEBEB; position: fixed; bottom: 0;margin-left: 35%; margin-bottom:10%}
</style>
</head>
<body>
<div align="center">
	<h1>Make Payment</h1>
	<br/>
	<form action="./MakePayment" method="post">
	<table>
		<tr>
			<td>E-mail id</td>
			<td><input type="text" name="email" required/></td>
		</tr>
		<tr>
			<td>Membership charge:  </td>
			<td><label>500</label></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button name="action" value="pay">Pay</button>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>