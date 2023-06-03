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
							<div class="col-md-6">
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
									<div class="nav nav-pills" style="margin-left: 220px;"
										id="nav-tab" role="tablist">
										<a class="nav-item nav-link active" id="nav-home-tab"
											data-toggle="tab" href="#nav-home" role="tab"
											aria-controls="nav-home" aria-selected="true">User</a> <a
											class="nav-item nav-link" id="nav-profile-tab"
											data-toggle="tab" href="#nav-profile" role="tab"
											aria-controls="nav-profile" aria-selected="false">Recruiter</a>
									</div>
								</nav>

								<!-- User Register Tab  -->

								<div class="tab-content" id="nav-tabContent">
									<div class="tab-pane fade show active" id="nav-home"
										role="tabpanel" aria-labelledby="nav-home-tab">
										<hr>
										<div class="card border-0">
											<div class="card-body ">
												<form novalidate id="register" action="user_reg"
													method="post">
													<div class="form-group">
														<label for="name" class="form-label">Full Name </label> <input
															type="text" class="form-control" id="name" name="fn"
															required>
													</div>
													<div class="form-group">
														<label for="email" class="form-label">Email ID </label> <input
															id="emailid" type="email" class="form-control" id="email"
															name="em" required>
													</div>

													<div class="form-group">
														<label for="password" class="form-label">Password
														</label> <input type="password" class="form-control" id="password"
															name="ps" required>
													</div>

													<div class="form-group">
														<label for="confirmpassword" class="form-label">Confirm
															Password </label> <input type="password" class="form-control"
															id="confirmpassword" name="cps" required>
													</div>

													<div class="form-group">
														<label for="mobno" class="form-label">Mobile No </label> <input
															type="text" class="form-control" id="mobno" name="mb"
															required>
													</div>

													<div class="form-group">
														<label for="primaryskill" class="form-label">Primary
															Skill </label> <input type="text" class="form-control"
															id="primaryskill" name="pk" required>
													</div>

													<div class="form-group">
														<label for="experince" class="form-label">Experience
														</label> <input type="text" class="form-control" id="experince"
															name="ex" required>
													</div>




													<button type="submit" class="btn btn-primary">Register</button>
												</form>
											</div>
										</div>
									</div>


									<!-- Recruiter Register Tab  -->

									<div class="tab-pane fade mt-1" id="nav-profile"
										role="tabpanel" aria-labelledby="nav-profile-tab">
										<hr>
										<div class="card border-0">
											<div class="card-body ">
												<form novalidate action="rec_register" method="post" id="register2">
													<div class="form-group">
														<label for="first name" class="form-label">Company
															Name</label> <input type="text" class="form-control"
															 name="cn" > 
													</div>

													<div class="form-group">
														<label for="first name" class="form-label">Recruiter
															Name</label> <input type="text" class="form-control"
															 name="rna" > 
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Address</label>
														<input type="text" class="form-control"
															name="ad">
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Mobile
															No.:</label> <input type="text" class="form-control"
															 name="mb" >
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Email ID</label>
														<input type="email" class="form-control" id="emailid"
															name="em" >
													</div>

													<div class="form-group">
														<label for="last name" class="form-label">Password
														</label> <input type="password" class="form-control" id="pwd"
															name="ps" >
													</div>

													 <div class="form-group">
														<label for="last name" class="form-label">Confirm
															Password:</label> <input type="password" class="form-control"
															id="cpwd" name="cpwd" > 
													</div> 

													<button type="submit" class="btn btn-primary">Register</button>
												</form>
											</div>
										</div>
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