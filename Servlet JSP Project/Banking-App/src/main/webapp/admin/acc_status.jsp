<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AdminDAOImpl"%>
<%@page import="com.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Status</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@include file="main_navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 offset-md-2">
				<h1 class="text-center">Account Status</h1>
				<c:if test="${empty userobj}">
					<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
					<c:redirect url="../login.jsp"></c:redirect>
				</c:if>

				<c:if test="${not empty sussMsg }">
					<h5 class="text-center text-success">${sussMsg}</h5>
					<c:remove var="sussMsg" />
				</c:if>

				<table class="table table-striped mt-5">
					<thead class="bg-primary text-light">
						<tr>
							<th scope="col">Account No</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone No</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
						List<User> list = dao.findByStatus();
						for (User sts : list) {
						%>
						<tr>
							<th scope="row"><%=sts.getAccountNo()%></th>
							<td><%=sts.getFirstName() + " " + sts.getLastName()%></td>
							<td><%=sts.getEmail()%></td>
							<td><%=sts.getNumber()%></td>
							<td><a class="btn btn-success btn-sm"
								href="approve?accno=<%=sts.getAccountNo()%>&&uname=<%=sts.getFirstName() + " " + sts.getLastName()%>&&email=<%=sts.getEmail()%>">Approve</a>
								<a href="../edit_view?accno=<%=sts.getAccountNo()%>"
								class="btn btn-sm btn-primary text-white">View</a> <a
								href="../reject?accno=<%=sts.getAccountNo()%>"
								class="btn btn-sm btn-danger text-white">Reject</a></td>
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