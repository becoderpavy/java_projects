
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
<%@include file="../all_component/allcss.jsp"%>
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
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../all_component/admin_navbar.jsp"%>

	<div class="container">
		<h3 class="text-center text-primary">Jobs Details</h3>
		<div class="row">

			<%
			int id = Integer.parseInt(request.getParameter("jid"));
			JobDAO dao = new JobDAO(DBConnect.getConn());
			Job j = dao.getJobById(id);
			%>
			<div class="col-md-10 offset-md-1 mt-3 jobcard p-0 ">

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
										<%=j.getExperience()%> years
										<br> <i class="fa-solid fa-sack-dollar"></i> Salary :
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


					</div>
				</div>

			</div>



		</div>

		<%-- 		<div class="col-md-6 offset-md-5 mt-3">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<%
					int totalJob = dao.count();
					int noOfpages = (int) Math.ceil(totalJob * 1.0 / 4);

					if (cp != 1) {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=cp - 1%>" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
					</a></li>


					<%
					}
					%>

					<%
					for (int in = 1; in <= noOfpages; in++) {
						if (cp == in) {
					%>
					<li class="page-item "><a
						class="page-link text-white bg-primary "
						href="home.jsp?pgid=<%=in%>"><%=in%></a></li>
					<%
					} else {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=in%>"><%=in%></a></li>
					<%
					}

					}
					%>


					<%
					if (cp != noOfpages) {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=cp + 1%>" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
					</a></li>
					<%
					}
					%>


				</ul>
			</nav>
		</div> --%>



	</div>



</body>
</html>