<%@page import="com.emp.entity.UserDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.emp.db.DBConnect"%>
<%@page import="com.emp.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	<%@include file="../common_nav/admin_nav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<div class="forgot text-center">
					<h3 class="display-4">Employee Details</h3>

					<%
					UserDAO dao2 = new UserDAO(DBConnect.getConnection());
					int i = dao2.getEmpNo();
					%>
					<h4 class="text-primary">
						Total Employee :
						<%=i%></h4>


					<c:if test="${not empty succMsg }">
						<h5 class="text-success text-center" role="alert">${ succMsg}</h5>
						<c:remove var="succMsg" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<h5 class="text-danger text-center" role="alert">${ failedMsg}</h5>
						<c:remove var="failedMsg" />
					</c:if>
				</div>

				<table class="table mt-5">
					<thead class="bg-success text-white">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Username</th>
							<th scope="col">Password</th>
							<th scope="col">Email</th>
							<th scope="col">Ph No</th>
							<th scope="col">Address</th>
							<th scope="col">Salary</th>
							<th scope="col">Qualification</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody class="bg-light ">

						<%
						UserDAO dao = new UserDAO(DBConnect.getConnection());
						List<UserDtls> list = dao.getAllEmp();
						for (UserDtls u : list) {
						%>
						<tr>
							<td><%=u.getFirstName() + " " + u.getLastName()%></td>
							<td><%=u.getUserName()%></td>
							<td><%=u.getPassword()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getContactNo()%></td>
							<td><%=u.getAdress()%></td>
							<td><%=u.getSalary()%></td>
							<td><%=u.getQualification()%></td>
							<td><%=u.getStatus()%></td>
							<td><a href="edit_emp.jsp?id=<%=u.getId()%>"
								class="btn btn-sm btn-primary">Edit</a> <a
								href="../deleteemp?id=<%=u.getId()%>"
								class="btn btn-sm btn-danger">Delete</a></td>

						</tr>
						<%
						}
						%>
					</tbody>
				</table>


			</div>
		</div>
	</div>
</body>
</html>
