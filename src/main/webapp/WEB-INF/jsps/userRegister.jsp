<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script>
function myFun() {
	var a = document.myform.email.value;
	if (a.indexOf('@') <= 0) {
		alert(" invalid emial ");
		return false;
	}

	if ((a.charAt(a.length - 4) != '.')
			&& (a.charAt(a.length - 3) != '.')) {
		alert(" invalid emial ");
		return false;
	}
}

</script>

<form action="registerUser" method="post"  name="myform" onsubmit="return myFun()" align="center" >
<h1 style="color:green;text-align:center;">User Registration</h1>

<input type="text" name="firstName" placeholder="Enter First Name" required /><br/><br/>

<input type="text" name="lastName" placeholder="Enter Last Name" required /><br/><br/>

<input type="email" name="email" placeholder="Enter Email Address" required /><br/><br/>

<input type="password" name="password" placeholder="Enter Password" required/><br/><br/> 

Male:<input type="radio" name="gender" value="male" checked/> &nbsp 
FeMale:<input type="radio" name="gender" value="female" /> <br/><br/>

<input type="number" name="phone" placeholder="Enter Phone Number" required /><br/><br/>

<input type="submit" value="register" />


</form>

<a href="showLogin">Login</a><br/><br/>
<a href="showAddStore">Add Store</a><br/><br/>
<a href="searchStores">Find stores</a>



<h3>${msg}</h3>
</body>
</html>