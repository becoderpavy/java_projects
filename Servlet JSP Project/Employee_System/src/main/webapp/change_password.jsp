<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #eceff1;">
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/empnav.jsp"%>
	<div class="loginbox">
		<div class="container padding-bottom-3x mb-2 mt-5">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-md-10">
					<h2 class="display-5">Change Your Password?</h2>
					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<form class="card mt-4" action="changepassword" method="post">
						<div class="card-body">
							<div class="form-group">
								<label for="id">Old Password</label> <input class="form-control"
									type="text" id="empid" required name="op">
							</div>
							<div class="form-group">
								<label for="email-for-pass">Enter New Password</label> <input
									class="form-control" type="text" id="email-for-pass" name="np"
									required>
							</div>
							<input type="hidden" value="${userobj.id}" name="uid">
						</div>
						<div class="card-footer">
							<button class="btn btn-info" type="submit">Update
								Password</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>