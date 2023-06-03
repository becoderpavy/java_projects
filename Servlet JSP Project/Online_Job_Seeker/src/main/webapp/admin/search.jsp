
<%@page import="com.entites.Resume"%>
<%@page import="com.dao.ResumeDAO"%>
<%@page import="com.entites.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.JobDAO"%>


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

.back-img {
	width: 100%;
	height: 20vh;
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/job2.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	 <c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if> 
	<%@include file="../all_component/admin_navbar.jsp"%>

	<div class="back-img justify-content-center p-5">

		<form action="resume.jsp" method="post">
			<div class="form-row">
				<div class="form-group col-md-8 offset-md-1">
					<input type="search" class="form-control form-control-lg" name="ch"
						placeholder=" skill , location">
				</div>

				<div class="form-group col-md-2">
					<button class="btn btn-primary btn-lg">Search</button>
				</div>

			</div>
		</form>

	</div>

	<div class="container">
		<h3 class="text-center text-primary"></h3>
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center ">All Resume</h3>
						<table class="table mt-5">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Email</th>
									<th scope="col">Mobile No</th>
									<th scope="col">Skill</th>
									<th scope="col">Resume</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody class="bg-white">
								<%
								String ch = request.getParameter("ch");
								ResumeDAO dao = new ResumeDAO(DBConnect.getConn());
								List<Resume> list = dao.getAllResume();
								for (Resume r : list) {
								%>
								<tr>
									<td><%=r.getFirstName()%> <%=r.getLastName()%></td>
									<td><%=r.getEmail()%></td>
									<td><%=r.getPhoneNumber()%></td>
									<td><%=r.getSkill()%></td>
									<td><a
										href="../downloadFile?fileName=<%=r.getResumeFileName()%>"
										class="btn btn-sm btn-primary">Download</a></td>
									<td><a href="view_resume.jsp?id=<%=r.getId()%>"
										class="btn btn-sm btn-primary"> View</a></td>
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