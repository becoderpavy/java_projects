<%@page import="com.entity.Jobs"%>
<%@page import="com.dao.JobDAO"%>
<%@page import="com.entity.Candidates"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.CandidateDAO"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-5">

		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Candidates</h4>
						<c:if test="${not empty succMsg }">
							<h4 class="text-center text-success">${succMsg }</h4>
							<c:remove var="succMsg" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Job title</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Resume</th>
									<th scope="col">Interview Date</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								CandidateDAO dao = new CandidateDAO(DBConnect.getConn());
								JobDAO dao2 = new JobDAO(DBConnect.getConn());
								List<Candidates> list = dao.getAllCandidates();
								for (Candidates c : list) {
									Jobs j = dao2.getJobsById(c.getJobId());
								%>
								<tr>
									<th scope="row"><%=j.getTitle()%></th>
									<td><%=c.getName()%></td>
									<td><%=c.getEmail()%></td>
									<td><a href="downloadFile?fileName=<%=c.getResume()%>"
										class="btn btn-sm btn-primary">Download</a></td>
									<td><%=c.getInterviewDate()%></td>

									<td><a class="btn btn-sm btn-primary"
										href="schedule.jsp?cid=<%=c.getId()%>">Schedule</a></td>

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
	</div>


</body>
</html>