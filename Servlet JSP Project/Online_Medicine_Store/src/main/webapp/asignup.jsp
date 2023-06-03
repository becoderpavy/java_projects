
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
<title>User Signup</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.error {
	color: red
}
</style>
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Medicine Store Register</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form id="artRegister" novalidate action="asignup" method="post"
							class="row g-3">
							<div class="col-6">
								<label class="form-label">Full Name</label> <input
									name="fullname" type="text"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Shop Name</label> <input type="text"
									name="shopname" class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									name="email" class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Mob No</label> <input
									name="mobno" type="text" class="form-control form-control-sm">
							</div>

							<div class="col-md-6">
								<label class="form-label">Password</label> <input type="text"
									id="pass" name="password" class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label class="form-label">Confirm Password</label> <input
									name="confirmpassword" type="password"
									class="form-control form-control-sm">
							</div>



							<div class="col-12">
								<label for="inputAddress" class="form-label">Address</label> <input
									name="address" type="text" class="form-control form-control-sm">
							</div>
							<div class="col-md-4">
								<label for="inputCity" class="form-label">City</label> <input
									name="city" type="text" class="form-control form-control-sm">
							</div>
							<div class="col-md-4">
								<label for="inputState" class="form-label">State</label> <select
									class="form-control form-control-sm " name="state">
									<option value="">--select--</option>
									<option value="Andhra Pradesh">Andhra Pradesh</option>
									<option value="Bihar">Bihar</option>
									<option value="Goa">Goa</option>
									<option value="Himachal Pradesh">Himachal Pradesh</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Odisha">Odisha</option>
									<option value="Maharashtra">Maharashtra</option>
									<option value="Punjab">Punjab</option>
									<option value="Tamil Nadu">Tamil Nadu</option>
									<option value="West Bengal">West Bengal</option>
								</select>
							</div>
							<div class="col-md-4">
								<label for="inputZip" class="form-label">Pin code</label> <input
									name="pin" type="text" class="form-control form-control-sm"
									id="inputZip">
							</div>
							<div class="col-12 text-center">
								<button type="submit" class="btn bg-custom text-white col-md-6">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/artist_script.js"></script>
</body>
</html>