<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:green;text-align:center;">Find stores</h2>
<form action="findStores" method="post">
<select name="city"  required >
  <option value="hyderabad">Hyderabad</option>
  <!-- <option value="vijayawada">vijayawada</option>
  <option value="vizag">Vizag</option>
  <option value="ongole">ongole</option> -->
</select> <br/><br/>

<select name="area"  required >
  <option value="ameerpet">Ameerpet</option>
  <option value="maadhapur">Maadapur</option>
  <option value="jublieehills">jublie hills</option>
  <option value="moosapet">Moosapet</option>
</select>

<input type="submit" value="find" />
</form>
<h3 style="color:red">${msg}</h3>

</body>
</html>