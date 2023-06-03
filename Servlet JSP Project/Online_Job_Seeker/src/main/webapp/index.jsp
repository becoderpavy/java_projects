
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
<title>Home Page</title>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
.back-img {
	width: 100%;
	height: 20vh;
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/job2.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.jobcard {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
	transition: box-shadow 0.3s ease-in-out;
}

.jobcard a {
	text-decoration: none;
	color: black;
}

.jobcard a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body style="background-color: #fffcfa">

	<%@include file="all_component/navbar.jsp"%>
	<div class="back-img justify-content-center p-5">

		<form action="search.jsp" method="post">
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
		<h3 class="text-center text-primary">All Jobs</h3>
		<div class="row">


			<%
			JobDAO dao = new JobDAO(DBConnect.getConn());
			List<Job> list = dao.getAllJobs();
			for (Job j : list) {
			%>
			<div class="col-md-10 offset-md-1 mt-3 jobcard p-0 ">
				<a href="job.jsp?jid=<%=j.getId()%>">
					<div class="card">
						<div class="card-body">

							<h5 class="ml-2"><%=j.getJobName()%></h5>
							<div class="row p-2">
								<div class="col-md-3">
									<i class="fas fa-map-marker-alt text-warning"></i>
									<%=j.getLocation()%>
								</div>
								<div class="col-md-4">
									<i class="fas fa-calendar-alt text-primary"></i> Publish Date :
									<%=j.getPublishDate()%>
								</div>

								<div class="col-md-3">
									<i class="fas fa-shopping-bag text-primary"></i> No Of
									Vacancies :
									<%=j.getVacancies()%>
								</div>
							</div>

							<div class="p-2">

								<%
								String desc = j.getDescription();
								int l = desc.length();
								if (l < 120) {
									String subDesc = desc.substring(0, l);
								%>
								<%=subDesc%>
								<%
								} else {
								String subDesc2 = desc.substring(0, 110);
								%>
								<%=subDesc2%>
								..<a href="job.jsp?jid=<%=j.getId()%>" class="text-primary">Read
									more</a>
								<%
								}
								%>

							</div>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			%>

		</div>




	</div>

	<div style="margin-top: 100px">
		<%@include file="all_component/footer.jsp"%>
	</div>

</body>
</html>