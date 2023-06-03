<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook: Register</title>
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
							<div class="col-md-6">
								<h4 class="text-center">Registration Page</h4>
								<p class="text-center">For all pet care taker and pet lovers</p>
								<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg }</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>

								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg }</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>
								<nav>
									<div class="nav nav-pills" style="margin-left: 220px;"
										id="nav-tab" role="tablist">
										<a class="nav-item nav-link active" id="nav-home-tab"
											data-toggle="tab" href="#nav-home" role="tab"
											aria-controls="nav-home" aria-selected="true">User</a> <a
											class="nav-item nav-link" id="nav-profile-tab"
											data-toggle="tab" href="#nav-profile" role="tab"
											aria-controls="nav-profile" aria-selected="false">Shop</a>
									</div>
								</nav>

								<!-- User Register Tab  -->

								<div class="tab-content" id="nav-tabContent">
									<div class="tab-pane fade show active" id="nav-home"
										role="tabpanel" aria-labelledby="nav-home-tab">
										<hr>
										<div class="card border-0">
											<div class="card-body ">
												<form action="register" method="post" id="userRegister">
													<div class="form-group">
														<label for="first name" class="form-label">Full
															Name:</label> <input type="text" class="form-control"
															id="txtfname" name="na"
															placeholder="Enter your first name" required> <small
															id="errFname" class="form-text text-muted"></small>
													</div>
													<div class="form-group">
														<label for="last name" class="form-label">Email
															ID.:</label> <input type="email" class="form-control"
															id="emailid" name="em" placeholder="Enter your email id"
															required> <small id="errEmail"
															class="form-text text-muted"></small>
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Mobile
															No.:</label> <input type="text" class="form-control" id="txtmno"
															name="phno" placeholder="Enter your mobile number"
															required> <small id="errmno"
															class="form-text text-muted"></small>
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Password:</label>
														<input type="password" class="form-control" id="psw"
															name="pwd" placeholder="Enter your password" required>

													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Confirm
															Password:</label> <input type="password" class="form-control"
															id="cpwd" name="cpwd" placeholder="Re-enter your pwd"
															required> <small id="errCP"
															class="form-text text-muted"></small>
													</div>
													<button type="submit" class="btn btn-primary">Register</button>
												</form>
											</div>
										</div>
									</div>


									<!-- Shop Register Tab  -->

									<div class="tab-pane fade mt-1" id="nav-profile"
										role="tabpanel" aria-labelledby="nav-profile-tab">
										<hr>
										<form action="shop_register" method="post" id="shopreg" novalidate="novalidate"
											enctype="multipart/form-data">
											<div class="form-group">
												<label for="first name" class="form-label">Full
													Name:</label> <input type="text" class="form-control" id="txtfname"
													name="on" placeholder="Enter your first name" required>
												
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Shop Name:</label>
												<input type="text" class="form-control" id="txtlname"
													name="sn" placeholder="Enter your last name" required>
											
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Email ID.:</label>
												<input type="email" class="form-control" id="emailid"
													name="em" placeholder="Enter your email id" required>
												<small id="errEmail" class="form-text text-muted"></small>
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Mobile
													No.:</label> <input type="number" class="form-control" id="txtmno"
													name="phno" placeholder="Enter your mobile number" required>
												
											</div>

											<div class="form-group">
												<label for="Address" class="form-label">Enter Your
													Address</label>
												<textarea class="form-control" id="address" name="ad"
													rows="3" required></textarea>
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">City:</label> <input
													type="text" class="form-control" id="city" name="ci"
													placeholder="Enter your city name" required>
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">State:</label> <input
													type="text" class="form-control" id="state" name="sta"
													placeholder="Enter your state name" required>
											</div>

											<!-- <div class="form-group">
												<label for="last name" class="form-label">Username:</label>
												<input type="text" class="form-control" id="uname"
													name="uname" placeholder="Pick Your Username" required>
												<small id="errUname" class="form-text text-muted"></small>
											</div> -->

											<div class="form-group">
												<label for="last name" class="form-label">Password:</label>
												<input type="password" class="form-control" id="pwd"
													name="psw" placeholder="Enter your password" required>
												
											</div>

											<div class="form-group">
												<label for="last name" class="form-label">Confirm
													Password:</label> <input type="password" class="form-control"
													id="cpwd" name="cpwd" placeholder="Re-enter your pwd"
													required> 
											</div>
											<div class="form-group">
												<label>Upload Image</label> <input type="file" name="img"
													class="form-control">
											</div>

											<button type="submit" class="btn btn-primary">Register</button>
										</form>
									</div>
								</div>
							</div>
							<div class="col-md-4 offset-md-1">
								<img src="img/reg_img.png" width="400" height="450">
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
	<script type="text/javascript" src="js/user_script.js"></script>
	<script type="text/javascript" src="js/shop_script.js"></script>
</body>
</html>