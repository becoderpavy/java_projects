<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
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
							<div class="col-md-4 ">
								<img src="img/orphans.jpg" width="400" height="450">
							</div>
							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">Registration Page</h4>
								<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg }</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>

								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg }</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>
								<form action="addOrphanage" method="post" id="orgRegister"
									novalidate>
									<div class="form-group">
										<label for="first name" class="form-label">Institute
											name :</label> <input type="text" class="form-control" id="txtfname"
											name="on" required> <small id="errFname"
											class="form-text text-muted"></small>
									</div>

									<div class="form-group">
										<label for="Address" class="form-label">Address </label>
										<textarea class="form-control" id="address" name="ad" rows="3"
											required></textarea>
									</div>

									<div class="form-group">
										<label for="last name" class="form-label">Email ID.:</label> <input
											type="email" class="form-control" id="emailid" name="em"
											placeholder="Enter your email id" required> <small
											id="errEmail" class="form-text text-muted"></small>
									</div>

									<div class="form-group">
										<label for="last name" class="form-label">Mobile No :</label>
										<input type="number" class="form-control" id="txtmno"
											name="ph" placeholder="Enter your mobile number" required>
										<small id="errmno" class="form-text text-muted"></small>
									</div>



									<div class="form-group">
										<label for="last name" class="form-label">Password:</label> <input
											type="password" class="form-control" id="pwd" name="psw"
											placeholder="Enter your password" required> <small
											id="errPs" class="form-text text-muted"></small>
									</div>

									<button type="submit" class="btn btn-primary">Register</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/org_script.js"></script>
</body>
</html>