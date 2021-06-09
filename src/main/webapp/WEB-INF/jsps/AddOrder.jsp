<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align: center;color:green">Adding Order Details</h2>
<form action="addOrderDetails" method="post">
<input type="text" name="customerName" placeholder="Enter customer Name"><br/><br/>
<input type="number" name="customerPhone" placeholder="Enter custormer Phone"><br/><br/>
<input type="hidden" name="servicestore" value="${serviceId}" />
<input type="number" name="toStore" placeholder="Enter from service store code " required /><br/><br/> 
<h2>To Address</h2>

<input type="text" name="doorNo" placeholder="Enter Door Number" required /><br/><br/>

<input type="text" name="street" placeholder="Enter Street" required /><br/><br/>

<input type="text" name="area" placeholder="Enter area" required /><br/><br/>

<input type="text" name="village" placeholder="Enter village/city" required /><br/><br/>

<input type="text" name="distric" placeholder="Enter distric" required /><br/><br/>

<input type="text" name="state" placeholder="Enter State" required /><br/><br/>

<input type="number" name="pincode" placeholder="Enter Pin code" required /><br/><br/>
<input type="submit" value="add order" />
</form>
<h1>${msg}</h1>
</body>
</html>