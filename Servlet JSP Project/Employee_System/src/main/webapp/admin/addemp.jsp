<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Emp</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #eceff1;">
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	<%@include file="../common_nav/admin_nav.jsp"%>
	<div class="container ">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h3 class="display-4 text-center">Registration Form</h3>
					<c:if test="${not empty succMsg }">
						<div class="alert alert-success" role="alert">${ succMsg}</div>
						<c:remove var="succMsg" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<div class="alert alert-danger" role="alert">${ failedMsg}</div>
						<c:remove var="failedMsg" />
					</c:if>
				</div>
				<form id="reg-form" action="../add_emp" method="POST">
					<div class="card mt-4">
						<div class="card-body">
							<div class="row">
								<div class="col">
									<input name="fn" type="text" class="form-control"
										placeholder="First name" required>
								</div>
								<div class="col">
									<input name="ln" type="text" class="form-control"
										placeholder="Last name" required>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col">
									<input name="un" type="text" class="form-control"
										placeholder="User name" required>
								</div>
								<div class="col">
									<input name="ps" type="text" class="form-control"
										placeholder="Password" required>
								</div>
							</div>

							<br>
							<div class="row">
								<div class="col">
									<input name="em" type="email" class="form-control"
										placeholder="Email" required>
								</div>
								<div class="col">
									<input name="cn" type="number" class="form-control"
										placeholder="Contact" required>
								</div>
							</div>

							<br>
							<div class="row">

								<div class="col-md-4">
									<input name="sa" type="number" class="form-control"
										placeholder="Salary" required>
								</div>
								<div class="col-md-4">
									<input name="qu" type="text" class="form-control"
										placeholder="Qualification" required>
								</div>

								<div class="col-md-4">
									<select class="form-control" name="st">
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									</select>
								</div>

							</div>

							<div class="form-group mt-2">
								<textarea rows="4" cols="" class="form-control" name="ad"
									placeholder="Address"></textarea>
							</div>

							<button class="btn btn-info" type="submit">Submit</button>
						</div>
					</div>
					<div class="card-footer"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>