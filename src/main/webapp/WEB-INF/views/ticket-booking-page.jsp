<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking</title>
</head>
<body>
<center>
<h1>Ticket Booking Page</h1>
<hr>
	<form action="save-booking" method="post">
		<label>Passenger Name</label>
		<input type="text" name="name"><br><br>
		<label>Age</label>
		<input type="number" name="age"><br><br>
		<label>Gender</label>
		<input type="radio" name="gender" value="Male" checked="checked">Male
		<input type="radio" name="gender" value="Female">Female
		<br><br>
		<input type="submit" value="Book Ticket">
	
	</form><br>
</center>
<a href="./logout">Logout</a>
</body>
</html>