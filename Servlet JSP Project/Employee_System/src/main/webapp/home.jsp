<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Login Page</title>
<link href="css/side.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/empnav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container">
		<br> <br> <br> <br>
		<div class="container">
			<div class="row">
				<div class="col-lg-6">

					<h4
						class="display-4 p-3 mb-2bg-warning text-dark bg-light text-center">
						<span class="fas fa-user-circle "></span> ${userobj.firstName}
						${userobj.lastName}
					</h4>
					<br>
					<h1 class="display-4 text-danger text-center">
						Welcome to the <br> Self Service <br> Portal
					</h1>

				</div>
				<div class="col-lg-3">
					<div class="card text-white bg-primary mb-3">
						<img src="images/time.png" class="card-img-top" alt="..."
							width="60" height="200">
						<div class="card-body">
							<h5 class="card-title  text-center ">Apply</h5>
							<a href="timesheet.jsp">
								<button type="button" class="btn btn-link text-white">Attendance</button>
							</a> <a href="leave.jsp"><button type="button"
									class="btn btn-link btn-labeled pull-right text-white">Leave</button></a>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="card text-dark bg-info mb-3">
						<img src="images/log.jpg" class="card-img-top" alt="..."
							width="60" height="200">
						<div class="card-body">
							<h5 class="card-title  text-center  text-white">Application</h5>
							<a href="expense.jsp"><button type="button"
									class="btn btn-link  text-white">Expenses</button></a> <a
								href="resign.jsp">
								<button type="button"
									class="btn btn-link btn-labeled pull-center  text-white">Resignation</button>
							</a><br>
						</div>
					</div>
				</div>

				<div class="modal fade" id="profile-modal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalCenterTitle"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header primary-background text-white">
								<h5 class="modal-title " id="exampleModalLongTitle">
									<span class="fa fa-user-o "></span>&nbsp; User Profile Details
								</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div id="profile-details">
								<div class="modal-body">
									<div class="text-center">
										<i class="fas fa-user-circle fa-3x"></i>
									</div>
									<table class="table table-striped mt-2">
										<%-- <tr>
											<th scope="row">ID</th>
											<td>${userobj.id}</td>
										</tr> --%>
										<tr>
											<th scope="row">Name</th>
											<td>${userobj.firstName}${userobj.lastName}</td>
										</tr>
										<tr>
											<th scope="row">Username</th>
											<td>${userobj.userName}</td>
										</tr>
										<%-- 	<tr>
											<th scope="row">Password</th>
											<td>${userobj.password}</td>
										</tr> --%>
										<tr>
											<th scope="row">Email</th>
											<td>${userobj.email}</td>
										</tr>
										<tr>
											<th scope="row">Contact</th>
											<td>${userobj.contactNo}</td>
										</tr>

										<tr>
											<th scope="row">Address</th>
											<td>${userobj.adress}</td>
										</tr>

										<tr>
											<th scope="row">Qualification</th>
											<td>${userobj.qualification}</td>
										</tr>

									</table>
								</div>
							</div>


							<!-- Profile Edit -->

							<%-- 				<div id="profile-edit" style="display: none;">
								<h5 class="text-center mt-4">Please Edit Details Carefully</h5>

								<form action="EditServlet" method="POST">
									<table class="table table-striped">
										<tr>
											<th scope="row">ID</th>
											<td>${userobj.id}</td>
										</tr>
										<tr>
											<th scope="row">Name</th>
											<td>${userobj.firstName} ${userobj.lastName}</td>
										</tr>

										<tr>
											<th scope="row">Username</th>
											<td>${userobj.userName}</td>
										</tr>
										<tr>
											<th scope="row">Password</th>
											<td><input type="text" class="form-control"
												name="password" value="${userobj.password}"></td>
										</tr>
										<tr>
											<th scope="row">Email</th>
											<td><input type="email" class="form-control"
												name="email" value="${userobj.email}"></td>
										</tr>
										<tr>
											<th scope="row">Contact</th>
											<td><input type="text" class="form-control"
												name="contact" value="${userobj.contactNo}"></td>
										</tr>

									</table>

									<div class="container">
										<button type="submit" class="btn btn-outline-info">Save</button>
									</div>
								</form>

							</div> --%>


							<div class="modal-footer">
								<button type="button" class="btn btn-warning"
									data-dismiss="modal">Close</button>
								<!-- <button id="edit-profile-button" type="button"
									class="btn btn-danger">Edit</button> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 	<script>
		$(document).ready(function() {
			let editStatus = false;

			$('#edit-profile-button').click(function() {

				if (editStatus == false) {
					$("#profile-details").hide()

					$("#profile-edit").show();
					editStatus = true;
					$(this).text("Back")
				} else {
					$("#profile-details").show()

					$("#profile-edit").hide();
					editStatus = false;
					$(this).text("Edit")

				}

			})
		});
	</script> -->

</body>
</html>