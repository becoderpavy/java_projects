
<%@page import="com.entites.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Jobs</title>
<%@include file="../all_component/allcss.jsp"%>
<style type="text/css">
a:hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	 <c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if> 
	<%@include file="../all_component/admin_navbar.jsp"%>
	<div class="container-fluid p-3">


		<div class="card">
			<div class="card-body">
				<h2 class="text-center">All Jobs</h2>
				<c:if test="${not empty succMsg }">
					<div class="alert alert-success" role="alert">${ succMsg}</div>
					<c:remove var="succMsg" />
				</c:if>
				<c:if test="${not empty failedMsg }">
					<h5 class="text-center text-danger">${failedMsg}</h5>
					<c:remove var="failedMsg" scope="session" />
				</c:if>
				<table class="table mt-5">
					<thead>
						<tr>
							<th scope="col">Title</th>
							<th scope="col">Location</th>
							<th scope="col">No Of Vacancies</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody class="bg-white">
						<%
						JobDAO dao = new JobDAO(DBConnect.getConn());
						List<Job> list = dao.getAllJobs();
						for (Job j : list) {
						%>
						<tr>
							<td><a href="job.jsp?jid=<%=j.getId()%>"><%=j.getJobName()%></a></td>
							<td><%=j.getLocation()%></td>
							<td><%=j.getVacancies()%></td>
							<td><a href="edit_job.jsp?jid=<%=j.getId()%>"
								class="btn btn-sm btn-primary"> Edit</a> <a
								href="../deleteJob?id=<%=j.getId()%>"
								class="btn btn-sm btn-danger"> Delete</a></td>
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