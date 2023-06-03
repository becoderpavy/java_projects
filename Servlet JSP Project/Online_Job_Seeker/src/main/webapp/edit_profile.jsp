<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<h3 class="text-center">Edit Profile</h3>

						<form action="updateProfile" method="post">
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label>First Name</label> <input type="text" name="firstName"
											value="${userObj.firstName }"
											class="form-control form-control-sm">
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>Last Name</label> <input type="text" name="lastName"
											value="${userObj.lastName }"
											class="form-control form-control-sm">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label>Age</label> <input type="number" name="age"
											value="${userObj.age }"
											class="form-control form-control-sm  ">
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>Mobile Number</label> <input type="number"
											name="mobileNumber" class="form-control form-control-sm"
											value="${userObj.mobileNumber}">
									</div>

								</div>
							</div>

							<div>
								<label>Gender</label>

								<c:if test="${userObj.gender eq 'Male' }">
									<div class="form-check form-check-inline ml-3">
										<input class="form-check-input" type="radio" name="gender"
											checked id="inlineRadio1" value="Male"> <label
											class="form-check-label" for="inlineRadio1">Male</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											id="inlineRadio2" value="Female"> <label
											class="form-check-label" for="inlineRadio2">Female</label>
									</div>

								</c:if>

								<c:if test="${userObj.gender eq 'Female' }">
									<div class="form-check form-check-inline ml-3">
										<input class="form-check-input" type="radio" name="gender"
											id="inlineRadio1" value="Male"> <label
											class="form-check-label" for="inlineRadio1">Male</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											checked id="inlineRadio2" value="Female"> <label
											class="form-check-label" for="inlineRadio2">Female</label>
									</div>

								</c:if>


							</div>

							<div class="form-group">
								<label>Email</label> <input type="email" name="email" readonly
									class="form-control form-control-sm" value="${userObj.email }">
							</div>


							<div class="form-group">
								<label>Address</label>
								<textarea name="address" rows="3" cols="" class="form-control">${userObj.address}</textarea>
							</div>
							<input type="hidden" name="id" value="${userObj.id }">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>