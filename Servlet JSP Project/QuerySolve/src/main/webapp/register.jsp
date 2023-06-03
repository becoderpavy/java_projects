<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<%@include file="all_component/allcss.jsp"%>

</head>
<body style="background-color: #f7f7f7;">
	<%@include file="all_component/navbar.jsp"%>
	<div class="continer-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Registration</h5>
						</div>
						<c:if test="${ not empty succMsg }">
							<h4 class="text-center text-success">${succMsg }</h4>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty failedMsg }">
							<h4 class="text-center text-danger">${failedMsg }</h4>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						<form action="register" method="post">
							<div class="form-group">
								<label>Full Name</label> <input type="text" required="required"
									class="form-control form-control-sm" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" required="required"
									class="form-control form-control-sm" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">
							</div>

							<div class="from-group">
								<label>Gender</label><br>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Male">Male
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Female">Female
									</label>
								</div>
							</div>
							<br>
							<div class="form-group">
								<label>Collage Id</label> <input type="text" name="cid"
									required="required" class="form-control form-control-sm"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="cid">
							</div>


							<div class="form-group">
								<label>User Category</label><br>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Student">Student
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Faculity">Faculity
									</label>
								</div>

								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Others">Others
									</label>
								</div>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1"> Password</label> <input
									required="required" type="password"
									class="form-control form-control-sm" id="exampleInputPassword1"
									name="password">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>