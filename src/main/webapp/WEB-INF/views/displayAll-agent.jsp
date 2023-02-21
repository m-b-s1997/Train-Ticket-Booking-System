<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Page</title>
</head>
<body>

	<center><h1>All Agent</h1>
	<hr>

	<table border="1" align="center">
		<tr>
			<th>Agent Id</th>
			<th>Agent Name</th>
			<th>Email</th>
			<th>DOB</th>
			<th>Mobile Number</th>
			<th colspan="2">Action</th>
		</tr>
		
		<c:forEach var="agent" items="${agents}">
			<tr>
				<td>${ agent.agentId }</td>
				<td>${ agent.name }</td>
				<td>${ agent.email }</td>
				<td>${ agent.dob }</td>
				<td>${ agent.mbl }</td>
				<td><a href='./delete?agentId=${ agent.agentId }'>DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	</center>
	<a href="./logout">Logout</a>
</body>
</html>