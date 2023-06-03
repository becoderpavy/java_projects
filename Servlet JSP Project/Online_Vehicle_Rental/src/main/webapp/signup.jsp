
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Signup</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<%@include file="component/css.jsp"%>
</head>
<body
	style="background: url('img/carx2.jpeg'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="component/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Signup</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form id="userRegister" class="row g-3" action="register"
							method="post">
							<div class="col-6">
								<label class="form-label">Full Name</label> <input type="text"
									required name="name" class="form-control form-control-sm">
							</div>

							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									required name="email" class="form-control form-control-sm">
							</div>

							<div class="col-md-12">
								<label class="form-label">Mobile Number</label> <input type="text"
									required name="mobno" class="form-control form-control-sm">
							</div>


							<div class="col-md-6">
								<label class="form-label">Password</label> <input id="pass"
									required type="password" name="password"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label class="form-label">Confirm Password</label> <input
									 required type="password" name="confirmpassword"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Address</label> <input type="text"
									required name="address" class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">City</label> <input type="text"
									required name="city" class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">State</label> <input type="text"
									required name="state" class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Pincode</label> <input type="text"
									required name="pincode" class="form-control form-control-sm">
							</div>
							<input type="hidden" required name="role" value="USER"
								class="form-control form-control-sm">

							<button class="btn bg-custom text-white col-md-12 mt-3">Register</button>
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
	<script type="text/javascript" src="js/user_script.js"></script>

</body>
</html>