<%@page import="com.entites.Job"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.dao.CandidatesDao"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Candidates</title>
<%@include file="../all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../all_component/admin_navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">All Jobs</h2>
		<table class="table">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Job Name</th>
					<th scope="col">Candidates</th>
					<th scope="col">Total Candidates</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				JobDAO dao = new JobDAO(DBConnect.getConn());
				CandidatesDao dao2 = new CandidatesDao(DBConnect.getConn());
				List<Job> list = dao.getAllJobs();
				for (Job j : list) {
					int total_candidates = dao2.count(j.getId());
				%>
				<tr>
					<td><a href="job.jsp?jid=<%=j.getId()%>"><%=j.getJobName()%></a></td>
					<td><a href="job_candidate.jsp?jid=<%=j.getId()%>"
						class="btn btn-sm btn-outline-success"><i class="fas fa-edit"></i>
							View</a></td>
					<td><%=total_candidates%></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>