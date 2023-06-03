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
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Applied Job</h4>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Job title</th>
									<th scope="col">Email</th>
									<th scope="col">Interview Date</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userobj");
								CandidateDAO dao = new CandidateDAO(DBConnect.getConn());
								JobDAO dao2 = new JobDAO(DBConnect.getConn());
								List<Candidates> list = dao.getCandidatesByUser(user.getId());
								for (Candidates c : list) {
									Jobs j = dao2.getJobsById(c.getJobId());
								%>
								<tr>
									<th scope="row"><%=j.getTitle()%></th>
									<td><%=c.getEmail()%></td>
									<td><%=c.getInterviewDate()%></td>

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