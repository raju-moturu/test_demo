<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align:center;color:blue">Received Orders</h2>
<table border="1" align="center" >
<tr>
<th>Order No</th>
<th>Customer Name</th>
<th>Mobile Number</th>
</tr>

<c:forEach items="${orders}" var="orders">
<tr>
<td>${orders.id}</td>
<td>${orders.customerName}</td>
<td>${orders.customerPhone}</td>

</tr>
</c:forEach>
</table>
<a href="storelogin">Add Order</a><br/><br/>
<a href="showReceivedLogin">Received Orders</a>

<h3>${msg }</h3>
</body>
</html>