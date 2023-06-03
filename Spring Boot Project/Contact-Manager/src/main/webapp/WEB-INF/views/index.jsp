<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager</title>
</head>
<body>
	<h1>Index page</h1>


	<table>
		<thead>
			<tr>
				<th>SL No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${list}" varStatus="status">

				<tr>

					<td>${status.index+1}</td>
					<td>${c.name}</td>
					<td>${c.email }</td>
					<td>${c.address }</td>
					<td>${c.phone }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>