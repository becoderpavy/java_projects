
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
<title>Add Jobs</title>
<%@include file="../all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<%@include file="../all_component/admin_navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-10 offset-md-1">

			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>


						<h5>Add Jobs</h5>
						<c:if test="${not empty succMsg }">
							<div class="alert alert-success" role="alert">${ succMsg}</div>
							<c:remove var="succMsg" />
						</c:if>
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
					</div>
					<form action="../addJob" method="post">

						<div class="form-group">
							<label>Job Name</label> <input type="text" name="jobName"
								required class="form-control">
						</div>

						<div class="form-group">
							<label>Enter Description</label>
							<textarea required rows="6" cols="" name="description"
								class="form-control"></textarea>
						</div>

						<div class="row">
							<div class="col">
								<div class="form-group">
									<label>Experience</label> <input type="number"
										name="experience" required class="form-control">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Skill Required</label> <input type="text" name="skill"
										required class="form-control">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Qualification</label> <input type="text"
										name="qualification" required class="form-control">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="form-group">
									<label>Location</label> <select name="location"
										class="custom-select " required
										id="inlineFormCustomSelectPref">
										<option value="">choose...</option>
										<option value="Banglore">Banglore</option>
										<option value="Chennai">Chennai</option>
										<option value="Hydrabad">Hydrabad</option>
										<option value="Bhubaneswar">Bhubaneswar</option>
										<option value="Delhi">Delhi</option>

									</select>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Salary</label> <input type="text" name="salary" required
										class="form-control">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>No Of Vacancies</label> <input type="number"
										name="vacancies" required class="form-control">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col">
								<div class="form-group">
									<label>Employe Name</label> <input type="text" name="empName"
										required class="form-control">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Contact Number</label> <input type="number"
										name="contactNumber" required class="form-control">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Email</label> <input type="email" name="email" required
										class="form-control">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label>Address</label>
							<textarea required rows="3" cols="" name="address"
								class="form-control"></textarea>
						</div>


						<button class="btn btn-success">Publish Job</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>