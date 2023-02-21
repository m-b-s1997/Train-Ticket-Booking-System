<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login </title>
</head>
<body>
<center><h1>Admin Login Page</h1>
<hr>
<div class="/container">
		<form action="agent-login-authendicate" method="post">
			<label>email</label><br>
			<input type="email" name="email">
			<br><br>
	
			<label>Password</label><br>
			<input type="password" name="password">
			<br><br>
			
			<input type="submit" value="Login">
		</form>
	</div>
</center>
</body>
</html>