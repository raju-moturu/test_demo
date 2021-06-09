<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align: center;color:green" >Add Service Store</h2>
<form action="AddService" method="post"  align="center">
<input type="hidden" name="user" value="${userId }"  />

<input type="text" name="serviceName" placeholder="Enter Service Center Name" required /><br/><br/>

<input type="number" name="phone" placeholder="Enter phone number" required /><br/><br/>

<input type="text" name="doorNo" placeholder="Enter Door Number" required /><br/><br/>

<input type="text" name="street" placeholder="Enter Street" required /><br/><br/>

<input type="text" name="area" placeholder="Enter area" required /><br/><br/>

<input type="text" name="village" placeholder="Enter village/city" required /><br/><br/>

<input type="text" name="distric" placeholder="Enter distric" required /><br/><br/>

<input type="text" name="state" placeholder="Enter State" required /><br/><br/>

<input type="number" name="pincode" placeholder="Enter Pin code" required /><br/><br/>
 <input type="submit" value="add" />
</form>

</body>
</html>