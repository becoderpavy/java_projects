
<%@page import="com.dao.CandidatesDao"%>
<%@page import="com.entites.User"%>
<%@page import="com.entites.Job"%>
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

.jobcard:hover {
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

	<div class="container">

		<div class="row">

			<%
			int id = Integer.parseInt(request.getParameter("jid"));
			JobDAO dao = new JobDAO(DBConnect.getConn());
			Job j = dao.getJobById(id);
			%>
			<div class="col-md-10 offset-md-1 mt-3 jobcard p-0 ">

				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-primary">Jobs Details</h3>
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
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
								<i class="fas fa-shopping-bag text-primary"></i> No Of Vacancies
								:
								<%=j.getVacancies()%>
							</div>
						</div>
						<hr>
						<div class="p-2 mt-3">
							<h4 class="font-weight-bold">Description</h4>
							<%=j.getDescription()%>
						</div>
						<hr class="mt-5">
						<div class="row">
							<div class="col-md-6">
								<div class="ml-2 mt-4">
									<h4 class="font-weight-bold">Job Details</h4>
									<p>
										<i class="fa fa-external-link-square" aria-hidden="true"></i>
										Experience :
										<%=j.getExperience()%>
										years <br> <i class="fa-solid fa-sack-dollar"></i> Salary
										:
										<%=j.getSalary()%><br> <i
											class="fa-solid fa-graduation-cap"></i> Skil Required:
										<%=j.getSkill()%><br> <i
											class="fa-solid fa-building-columns"></i> Qualification :
										<%=j.getQualification()%><br>

									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="ml-2 mt-4">
									<h4 class="font-weight-bold">Contact Details</h4>
									<p>
										Name :
										<%=j.getEmpName()%>
										<br> Email:
										<%=j.getEmail()%><br> Mob No :
										<%=j.getContactNumber()%><br> Address:
										<%=j.getAddress()%>
									</p>
								</div>
							</div>
						</div>

						<div class="text-center col-md-3 offset-md-4">
							<%
							User u = (User) session.getAttribute("userObj");

							if (u != null) {
								CandidatesDao dao2 = new CandidatesDao(DBConnect.getConn());
								boolean f = dao2.checkJobApplied(id, u.getId());
								if (f) {
							%>
							<button class="btn btn-success btn-block badge-pill ">Job
								Applied</button>
							<%
							} else {
							%>
							<button data-toggle="modal" data-target="#exampleModalLong"
								class="btn btn-outline-primary btn-block badge-pill ">Apply
								Now</button>
							<%
							}} 
							else {
							%>
							<a href="login.jsp"
								class="btn btn-outline-primary btn-block badge-pill  ">Apply
								Now</a>
							<%
							}
							%>


						</div>


					</div>
				</div>
			</div>
		</div>



	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">

					<h5 class="modal-title" style="margin-left: 170px;"
						id="exampleModalLongTitle">Apply Job</h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="background-color: #f0f1f2;">

					<form action="apply_job" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="jid" value="<%=id%>"> <input
							type="hidden" name="uid" value="${userObj.id }">
						<div class="form-group">
							<label>Enter Name</label> <input type="text" name="na" required
								class="form-control"
								value="${userObj.firstName } ${userObj.lastName}">
						</div>
						<div class="form-group">
							<label>Enter Email</label> <input type="email" name="em" required
								class="form-control" value="${userObj.email }">
						</div>
						<div class="form-group">
							<label>Enter Mobile Number</label> <input type="number" name="mb"
								required class="form-control" value="${userObj.mobileNumber }">
						</div>
						<div class="form-group">
							<label>Upload Resume</label> <input type="file" name="re"
								required class="form-control">
						</div>
						<div class="col-md-3 offset-md-4">
							<button class="btn btn-primary">Apply Now</button>
						</div>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>