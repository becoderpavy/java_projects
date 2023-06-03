<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body style="background: url('img/bikex2.jpg');">
	<%@include file="component/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-8 mt-5">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Login</p>

						<c:if test="${not empty errorMsg}">
							<p class="fs-5 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg}">
							<p class=" fs-5 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="login" method="post">

							<div class="mb-3">
								<label class="form-label">Email </label> <input required
									name="email" type="text" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn bg-custom text-white col-md-12">Login</button>
						</form>
						<div class="text-center">


							<a href="forgot_password.jsp" class="clink">Forgot Password</a> <br>
							Don't have an account?<a href="signup.jsp" class="clink">
								create one</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>