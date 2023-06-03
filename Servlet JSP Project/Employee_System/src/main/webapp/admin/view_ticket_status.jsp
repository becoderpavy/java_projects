<%@page import="com.emp.entity.Helpline"%>
<%@page import="com.emp.dao.HelplineDAO"%>
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
<body style="background-color: #eceff1;">
	<%@include file="../common_nav/admin_nav.jsp"%>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<div class="forgot text-center">
					<h3 class="display-4">All Employee Ticket Details</h3>
					<c:if test="${not empty succMsg }">
						<h5 class="text-success text-center" role="alert">${ succMsg}</h5>
						<c:remove var="succMsg" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<h5 class="text-danger text-center" role="alert">${ failedMsg}</h5>
						<c:remove var="failedMsg" />
					</c:if>
				</div>

				<table class="table m-4">
					<thead class="bg-success text-white">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Contact No</th>
							<th scope="col">Title</th>
							<th scope="col">Reason</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody class="bg-light">
						<%
						UserDAO dao5 = new UserDAO(DBConnect.getConnection());
						HelplineDAO dao = new HelplineDAO(DBConnect.getConnection());
						List<Helpline> list = dao.gethelp();
						for (Helpline h : list) {
							UserDtls u = dao5.getUser(h.getUserid());
						%>
						<tr>
							<td><%=u.getFirstName()%> <%=u.getLastName()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getContactNo()%></td>
							<td><%=h.getTitle()%></td>
							<td><%=h.getReason()%></td>
							<td><%=h.getStatus()%></td>
							<td><a
								href="give_resp.jsp?tid=<%=h.getId()%>&&uid=<%=h.getUserid()%>"
								class="btn btn-sm btn-info">Response</a></td>
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
