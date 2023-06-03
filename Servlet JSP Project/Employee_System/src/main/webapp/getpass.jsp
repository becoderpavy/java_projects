<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TESS-Password Recovery</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: whitesmoke;">
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/link.jsp"%>
	<div class="loginbox">
		<div class="container padding-bottom-3x mb-2 mt-5">
			<div class="row justify-content-center">
				<div class="col-lg-8 col-md-12">
					<h3 class="display-5 text-center text-success">User Password
						Details</h3>
					<div class="forgot"></div>
					<form class="card mt-8" action="index.jsp">
						<div class="card-body">
							<div class="form-group">
								<table class="table table-bordered ">
									<br>
									<tr>
										<th scope="row">User Name</th>
										<td>.....</td>
									</tr>
									<tr>
										<th scope="row">Email</th>
										<td>smiqbal09@gmail.com</td>
									</tr>
									<tr>
										<th scope="row">Password</th>
										<td>admin@123</td>
									</tr>

								</table>




							</div>

							<br>
							<button class="btn btn-primary btn-lg btn-block" type="submit">Click
								to Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>