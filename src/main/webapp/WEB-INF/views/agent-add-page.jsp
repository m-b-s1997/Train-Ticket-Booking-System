<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Agent adding page</h1>
	<hr>
	<div class="/container">
		<form action="agent-save" method="POST">
			<!-- <label>SuperAdmin Id</label><br>
			<input type="text" name="supId"> -->
			
			<label>Agent name</label><br>
			<input type="text" name="name">
			<br><br>
			<label>Agent email</label><br>
			<input type="email" name="email">
			<br><br>
	
			<label>Agent Password</label><br>
			<input type="password" name="password">
			<br><br>
			
			<label>DOB</label><br>
			<input type="date" name="dob">
			<br><br>
			
			<label>Mobile Number </label><br>
			<input type="number" name="mbl">
			<br><br>
			
			<input type="submit" value="Register">
			</form></div></center>
		<a href="./logout">Logout</a>
</body>
</html>