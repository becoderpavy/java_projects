<%@page import="com.transport.entites.User"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body
	style="height: 90vh; background: linear-gradient(rgba(0, 0, 0, .5), rgba(0, 0, 0, .5)), url('../img/tr1.jpg'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="col-md-10 offset-md-1">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">Manager Details</p>
					<c:if test="${not empty succMsg}">
						<p class=" fs-4 text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Username</th>
								<th scope="col">Email</th>
								<th scope="col">Location</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;
							UserDAO dao = new UserDAO(DbConnect.getConnection());
							List<User> list = dao.getAllManager();
							for (User u : list) {
								i++;
							%>
							<tr>
								<td><%=i%></td>
								<td><%=u.getFullName()%></td>
								<td><%=u.getUserName()%></td>
								<td><%=u.getEmail()%></td>
								<td><%=u.getLocation()%></td>
								<td><a href="edit_manager.jsp?id=<%=u.getId()%>"
									class="btn btn-sm btn-primary">Edit</a> <a
									href="../deleteManager?id=<%=u.getId()%>"
									class="btn btn-sm btn-danger ms-1">Delete</a></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>