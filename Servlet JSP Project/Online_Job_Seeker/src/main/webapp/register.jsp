
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
<%@include file="all_component/allcss.jsp"%>
<title>Register Page</title>
<!-- <style type="text/css">
input.error, textarea.error {
	border: 1px solid red;
	font-weight: 300;
	color: red;
}
</style> -->

<style>
.error {
	color: red;
}
</style>

</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">

						<div class="row">
							<div class="col-md-5">
								<div class="card border-0">
									<div class="card-body">
										<h4 class="text-center">Register</h4>
										<c:if test="${not empty failedMsg }">
											<h5 class="text-center text-danger">${failedMsg}</h5>
											<c:remove var="failedMsg" scope="session" />
										</c:if>

										<c:if test="${not empty succMsg }">
											<h5 class="text-center text-success">${succMsg}</h5>
											<c:remove var="succMsg" scope="session" />
										</c:if>

										<form action="register" method="post">
											<div class="form-group">
												<label>First Name</label> <input type="text" required
													name="firstName" class="form-control form-control-sm">
											</div>

											<div class="form-group">
												<label>Last Name</label> <input required type="text" name="lastName"
													class="form-control form-control-sm">
											</div>

											<div class="form-group">
												<label>Age</label> <input required type="number" name="age"
													class="form-control form-control-sm  ">
											</div>

											<div>
												<label>Gender</label>
												<div class="form-check form-check-inline ml-3">
													<input required class="form-check-input" type="radio" name="gender"
														id="inlineRadio1" value="Male"> <label
														class="form-check-label" for="inlineRadio1">Male</label>
												</div>
												<div class="form-check form-check-inline">
													<input required class="form-check-input" type="radio" name="gender"
														id="inlineRadio2" value="Female"> <label
														class="form-check-label" for="inlineRadio2">Female</label>
												</div>
											</div>
											<div class="form-group">
												<label>Mobile Number</label> <input required type="number"
													name="mobileNumber" class="form-control form-control-sm  ">
											</div>

											<div class="form-group">
												<label>Email</label> <input required type="email" name="email"
													class="form-control form-control-sm  ">
											</div>

											<div class="form-group">
												<label>Password</label> <input required type="password"
													name="password" class="form-control form-control-sm  ">
											</div>

											<div class="form-group">
												<label>Address</label>
												<textarea required name="address" rows="3" cols=""
													class="form-control"></textarea>
											</div>

											<button type="submit" class="btn btn-primary col-md-12">Register</button>
										</form>
									</div>
								</div>
							</div>
							<div class="col-md-4 offset-md-1">
								<img src="img/job.jpg" width="400" height="450">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="all_component/script.js"></script>
</body>
</html>