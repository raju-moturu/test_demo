<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="showReceivedOrders" method="post">
<input type="email" name="email" placeholder="Enter Email" required /><br/><br/>
<input type="password" name="password" placeholder="Enter password" required/><br/><br/>
<input type="submit" value="login" />
</form>
<h3 style="color:red">${msg}</h3>
</body>
</html>