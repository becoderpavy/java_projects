
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
<title>Artist | Edit Profile</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty artObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>

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
						<form action="../achangepassword" method="post">
							<div class="mb-3">
								<label class="form-label">New Password</label> <input required
									name="newpassword" type="text" class="form-control">
							</div>
							<!-- <div class="mb-3">
								<label class="form-label">confirm new password</label> <input
									required type="text" name="confirmpassword"
									class="form-control">
							</div> -->

							<div class="mb-3">
								<label class="form-label">old Password</label> <input required
									type="text" name="oldpassword" class="form-control">
							</div>
							<input name="id" value="${artObj.id}" type="hidden">

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
						<form action="../aeditProfile" method="post" class="row g-3">
							<div class="col-6">
								<label class="form-label">Full Name</label> <input
									name="fullname" type="text" value="${artObj.fullName }"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Shop Name</label> <input type="text"
									value="${artObj.shopName }" name="shopname"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									value="${artObj.email }" name="email"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Mob No</label> <input
									value="${artObj.mobNo }" name="mobno" type="text"
									class="form-control form-control-sm">
							</div>





							<div class="col-12">
								<label for="inputAddress" class="form-label">Address</label> <input
									value="${artObj.address }" name="address" type="text"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-6">
								<label for="inputCity" class="form-label">City</label> <input
									value="${artObj.city }" name="city" type="text"
									class="form-control form-control-sm">
							</div>
							<div class="col-md-4">
								<label for="inputState" class="form-label">State</label> <select
									class="form-control form-control-sm " name="state">
									<option value="${artObj.state}">${artObj.state}</option>
									<option value="Odisha">Odisha</option>
								</select>
							</div>
							<div class="col-md-2">
								<label for="inputZip" class="form-label">Pin code</label> <input
									value="${artObj. pincode}" name="pin" type="text"
									class="form-control form-control-sm" id="inputZip">
							</div>
							<input type="hidden" name="id" value="${artObj.id }">

							<div class="col-12">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>