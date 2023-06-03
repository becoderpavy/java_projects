
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.model.Recruiter"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.RecruiterDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recruiter Page</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<h2 class="text-center">All Recruiter</h2>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg }">
			<h5 class="text-center text-success">${succMsg}</h5>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<table class="table table-bordered">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Company Name</th>
					<th scope="col">Recruiter Name</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				RecruiterDao dao = new RecruiterDao(DBConnect.getConn());
				List<Recruiter> list = dao.getAll();
				for (Recruiter r : list) {
				%>
				<tr>

					<td><%=r.getCompanyName()%></td>
					<td><%=r.getRecruiterName()%></td>
					<td><a href="rec_job.jsp?id=<%=r.getId()%>"
						class="btn btn-sm btn-outline-success"><i class="fas fa-edit"></i>
							view jobs</a>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>


</body>
</html>