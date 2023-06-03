<%@page import="com.entites.Job"%>
<%@page import="com.entites.Candidates"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entites.User"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@page import="java.util.List"%>

<%@page import="com.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applied Jobs</title>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
td a {
	text-decoration: none;
	color: black;
}

td a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">Jobs</h2>
		<c:if test="${not empty succMsg }">
			<div class="alert alert-success" role="alert">${ succMsg}</div>
			<c:remove var="succMsg" />
		</c:if>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>
		<table class="table">
			<thead class="bg-primary text-white ">
				<tr>

					<th scope="col">Job Tittle</th>
					<th scope="col">Location</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				User r = (User) session.getAttribute("userObj");
				CandidatesDao dao = new CandidatesDao(DBConnect.getConn());
				JobDAO dao2 = new JobDAO(DBConnect.getConn());
				List<Candidates> list = dao.getByUserId(r.getId());

				for (Candidates c : list) {
					Job j = dao2.getJobById(c.getJobId());
				%>
				<tr>
					<td><a href="job.jsp?jid=<%=j.getId()%>"><%=j.getJobName()%></a></td>
					<td><%=j.getLocation()%></td>
					<td><a href="#" class="btn btn-sm btn-success"> Applied</a></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>