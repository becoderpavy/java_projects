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
								<img src="img/ngo2.jpg" width="400" height="450">
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
								<nav>
									<div class="nav nav-pills" style="margin-left: 180px;"
										id="nav-tab" role="tablist">
										<a class="nav-item nav-link active" id="nav-home-tab"
											data-toggle="tab" href="#nav-home" role="tab"
											aria-controls="nav-home" aria-selected="true">Donor</a> <a
											class="nav-item nav-link" id="nav-profile-tab"
											data-toggle="tab" href="#nav-profile" role="tab"
											aria-controls="nav-profile" aria-selected="false">Organization</a>
									</div>
								</nav>

								<!-- Donor Register Tab  -->

								<div class="tab-content" id="nav-tabContent">
									<div class="tab-pane fade show active" id="nav-home"
										role="tabpanel" aria-labelledby="nav-home-tab">
										<hr>
										<div class="card border-0">
											<div class="card-body ">
												<form action="add_don" method="post" id="orgRegister" novalidate="novalidate">
													<div class="form-group">
														<label for="first name" class="form-label">Full
															Name:</label> <input type="text" class="form-control"
															id="txtfname" name="na"
															placeholder="Enter your first name" required>
													</div>
													<div class="form-group">
														<label for="last name" class="form-label">Email
															ID.:</label> <input type="email" class="form-control"
															id="emailid" name="em" placeholder="Enter your email id"
															required>
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Mobile
															No.:</label> <input type="number" class="form-control"
															id="txtmno" name="ph"
															placeholder="Enter your mobile number" required>

													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Password:</label>
														<input type="password" class="form-control" id="pwd"
															name="ps" placeholder="Enter your password" required>

													</div>
													<button type="submit" class="btn btn-primary">Register</button>
												</form>
											</div>
										</div>
									</div>


									<!-- organization Register Tab  -->

									<div class="tab-pane fade mt-1" id="nav-profile"
										role="tabpanel" aria-labelledby="nav-profile-tab">
										<hr>
										<form action="add_org" method="post" id="userRegister" novalidate="novalidate">
											<div class="form-group">
												<label for="first name" class="form-label">Organization
													Name:</label> <input type="text" class="form-control" id="txtfname"
													name="on" >
											</div>

											<div class="form-group">
												<label for="Address" class="form-label">Address </label>
												<textarea class="form-control" id="address" name="ad"
													rows="3" ></textarea>
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Email ID.:</label>
												<input type="email" class="form-control" id="emailid"
													name="em" placeholder="Enter your email id" >

											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Mobile No
													:</label> <input type="number" class="form-control" id="txtmno"
													name="ph" placeholder="Enter your mobile number" >

											</div>
											<div class="form-group">
												<label for="last name" class="form-label">Password:</label>
												<input type="password" class="form-control" id="pwd"
													name="psw" placeholder="Enter your password" >
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
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/user_script.js"></script>
	<script type="text/javascript" src="js/org_script.js"></script>
</body>
</html>