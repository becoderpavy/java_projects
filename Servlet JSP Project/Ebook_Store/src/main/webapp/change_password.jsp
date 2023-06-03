<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<%@include file="all_component/allCss_file.jsp"%>

</head>
<body style="background-color: #f0f1f2;">
 <c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if> 
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-info">Change Password</h4>
						<c:if test="${not empty succMsg}">
							<h4 class="text-center text-success">${succMsg}</h4>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<h4 class="text-center text-danger">${errorMsg}</h4>
							<c:remove var="errorMsg" />
						</c:if>
						<form class="card mt-4" action="chngpass" method="post">
							<input type="hidden" name="id" value="${userobj.id }">
							<div class="card-body">
								<div class="form-group">
									<label for="id">Old Password</label> <input
										class="form-control" type="text" id="empid" required name="op">
								</div>
								<div class="form-group">
									<label for="email-for-pass">New Password</label> <input
										class="form-control" type="text" id="email-for-pass" name="np"
										required>
								</div>
							</div>
							<div class="card-footer">
								<button class="btn btn-info" type="submit">Change
									Password</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		>
	</div>
</body>
</html>