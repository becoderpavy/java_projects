
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
<title>Edit Profile</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 12px 0 rgba(0, 0, 0, 0.3);
}

.clink {
	text-decoration: none;
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-1">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Change Password</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form id="chnagepsw" action="chngps" method="post">
							<div class="mb-3">
								<label class="form-label">New Password</label> <input required
									name="newpassword" type="text" class="form-control">
							</div>
							<!-- <div class="mb-3">
								<label class="form-label">confirm new password</label> <input required
									type="text" name="confirmpassword" class="form-control">
							</div> -->

							<div class="mb-3">
								<label class="form-label">old Password</label> <input required
									type="text" name="oldpassword" class="form-control">
							</div>
							<input name="id" value="${userObj.id}" type="hidden">

							<button type="submit" class="btn bg-primary text-white col-md-12">Change
								Password</button>
						</form>

					</div>
				</div>
			</div>

			<div class="col-md-6 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Profile Details</p>
						<c:if test="${not empty errorMsgp}">
							<p class="fs-4 text-center text-danger">${errorMsgp}</p>
							<c:remove var="errorMsgp" scope="session" />
						</c:if>
						<c:if test="${not empty succMsgp}">
							<p class=" fs-4 text-center text-success">${succMsgp}</p>
							<c:remove var="succMsgp" scope="session" />
						</c:if>
						<form class="row g-3" action="updateprofile" method="post"
							id="userRegister" novalidate>
							<div class="col-12">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control form-control-sm"
									value="${userObj.fullName }">
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									readonly required value="${userObj.email }" name="email"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Mob No</label> <input
									required value="${userObj.mobNo }" name="mobno" type="text"
									class="form-control form-control-sm">
							</div>



							<div class="col-12">
								<label for="inputAddress" class="form-label">Address</label> <input
									required value="${userObj.address }" name="address" type="text"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label for="inputCity" class="form-label">City</label> <input
									required value="${userObj.city }" name="city" type="text"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-4">
								<label for="inputState" class="form-label">State</label> <select
									required name="state" class="form-control form-control-sm ">
									<option value="${userObj.state }">${userObj.state }</option>
									<option value="odisha">Odisha</option>
								</select>
							</div>
							<div class="col-md-2">
								<label for="inputZip" class="form-label">Pin Code</label> <input
									required value="${userObj.pin }" name="pincode" type="text"
									class="form-control form-control-sm" id="inputZip">
							</div>
							<input type="hidden" name="id" value="${userObj.id }">
							<div class="col-12">
								<button type="submit" class="btn btn-primary">Update</button>
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
	<script type="text/javascript" src="js/user_script.js"></script>
</body>
</html>