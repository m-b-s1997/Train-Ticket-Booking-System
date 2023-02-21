<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Compartment Table</h1>
	<hr>
<% int rows= (int) request.getAttribute("allList");
   int seats=6;
   int num=1;
%>
<table border="2" cellpadding="10">
	<% for (int i = 1; i <= rows ; i++) { %>
    <tr>
        <% for (int j = 1; j <=seats; j++) { %>
        <td><%= num %></td>
        <%num++; %>
        <% } %>
         
    </tr>
    <% } %>

</table><br><br>
</center>
<a href="./logout">Logout</a>
</body>
</html>