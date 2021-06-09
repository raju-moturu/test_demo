<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:green;text-align:center;">Stores in ${address} </h2>
<table border="1" align="center">
<tr>
<th>Store Id</th>
<th>Store Name</th>
<th>Phone</th>
<th>Address</th>
</tr>
<c:forEach items="${stores}" var="stores">
<tr>
<td>${stores.id }</td>
<td>${stores.serviceName}</td>
<td>${stores.phone}</td>
<td>${stores.address.doorNo},${stores.address.street},${stores.address.area},${stores.address.village}</td>

<td><a href="showStoreDetails?storeId=${stores.id}" >select</a></td> 

</tr>
</c:forEach>
</table>

<h3><a href="searchStores">back</a></h3>
</body>
</html>