<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Treasury User Management System</title>
</head>
<body>
	<%@include file="common_nav/link.jsp"%>
	<img alt="No Image" src="images/home.jpg" width="950" height="600"
		style="vertical-align: middle; margin: 50px 0px">
	<div class="loginbox1">
		<div class="panel">
			<div class="panel-heading">
				<br> <br>

				<h3>&nbsp; Employee Self Service</h3>
				<h5 style="text-align: center;">One Map for all User</h5>
				<div class="panel-title text-center">
					<br>
					<h4 style="text-align: center;">Account Login</h4>
					<c:if test="${not empty failedmsg}">
						<h5 class="text-center text-danger">${failedmsg}</h5>
						<c:remove var="failedmsg" scope="session" />
					</c:if>

					<c:if test="${not empty succmsg}">
						<h5 class="text-center text-success">${succmsg}</h5>
						<c:remove var="succmsg" scope="session" />
					</c:if>
				</div>


			</div>

			<br>
		</div>
		<div class="panel-body p-20">
			<form action="loginServlet" class="form-horizontal" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-6 control-label">User
						Id </label>
					<div class="col-sm-10">
						<input name="un" type="text" name="un" class="form-control"
							id="inputEmail3" required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input name="ps" type="password" name="ps" class="form-control"
							id="inputPassword3" required>
					</div>
				</div>

				<div class="form-group mt-20">
					<div class="col-sm-offset-2 col-sm-10 text-center">
						<button type="submit" name="login" class="btn btn-info ">
							Sign in
						</button><br>
						<a href="forgot_password.jsp">Forgot Password</a>
					</div>
				</div>

			</form>
		</div>
	</div>

</body>
</html>
