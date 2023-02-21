<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperAdmin Login Page</title>
</head>
<body>
	<center>
	<h1>SuperAdmin Login Page</h1>
	<hr>
	<div class="/container">
		<form action="sup-login-authendicate" method="post">
			<label>Admin email</label><br>
			<input type="email" name="email">
			<br><br>
	
			<label>Admin Password</label><br>
			<input type="password" name="password">
			<br><br>
			
			<input type="submit" value="Login">
		</form>
	</div>
</center>
<a href="./logout">Logout</a>
</body>
</html>