<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dash Board</title>
<link href="css/side.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="../common_nav/admin_nav.jsp"%>
<body style="background-color: #eceff1;">

	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	
	<div class="container p-5">
		<div class="row">
			<div class="col-lg-6">
				<h4 class="display-4 p-3 mb-2 bg-light text-dark text-center">
					<span class="fa fa-user-o "></span> Admin
				</h4>
				<br>
				<h1 class="display-4 text-danger text-center">
					Welcome to the <br> User Management <br>Admin Portal
				</h1>
			</div>
			<div class="col-lg-3">
				<div class="card text-dark bg-info mb-3">
					<img src="../images/images_1.png" class="card-img-top" alt="..."
						width="95" height="245">
					<div class="card-body text-center">
						<h5 class="card-title  text-center text-white">Employee</h5>

						<a href="addemp.jsp" class="btn btn-sm btn-light btn-link "
							style="color: white">Add</a> <a type="button" href="view_emp.jsp"
							class="btn btn-sm btn-light btn-link" style="color: white">View</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="card text-white bg-danger mb-3">
					<img src="../images/req.jpg" class="card-img-top" alt="..."
						width="60" height="220">
					<div class="card-body text-center">
						<h5 class="card-title  text-center text-white">User Request &
							Accept</h5>

						<a href="admin_status.jsp" class="btn btn-sm btn-light btn-link"
							style="color: white">Status</a> 
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
						<table class="table table-striped">
							<br>
							<tr>
								<th scope="row">ID</th>
								<td>id
								<td>
							</tr>
							<tr>
								<th scope="row">Name</th>
								<td>name</td>
							</tr>
							<tr>
								<th scope="row">Username</th>
								<td>username</td>
							</tr>
							<tr>
								<th scope="row">Password</th>
								<td>password</td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td>email</td>
							</tr>
							<tr>
								<th scope="row">Contact</th>
								<td>contact</td>
							</tr>

						</table>
					</div>
				</div>


				<!-- Profile Edit -->

				<div id="profile-edit" style="display: none;">
					<h5 class="text-center mt-4">Please Edit Details Carefully</h5>

					<form action="EditServlet" method="POST">
						<table class="table table-striped">
							<br>
							<tr>
								<th scope="row">ID</th>
								<td>id</td>
							</tr>
							<tr>
								<th scope="row">Name</th>
								<td>name</td>
							</tr>

							<tr>
								<th scope="row">Username</th>
								<td>username</td>
							</tr>
							<tr>
								<th scope="row">Password</th>
								<td><input type="text" class="form-control" name="password"
									value="password"></td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td><input type="email" class="form-control" name="email"
									value="email"></td>
							</tr>
							<tr>
								<th scope="row">Contact</th>
								<td><input type="text" class="form-control" name="contact"
									value="contact"></td>
							</tr>

						</table>

						<div class="container">
							<button type="submit" class="btn btn-outline-info">Save</button>
						</div>
					</form>

				</div>


				<div class="modal-footer">
					<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn btn-danger">Edit</button>
				</div>
			</div>
		</div>
	</div>


	<script>
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
	</script>
</body>
</html>


