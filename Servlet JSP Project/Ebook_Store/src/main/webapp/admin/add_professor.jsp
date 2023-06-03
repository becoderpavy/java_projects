<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add Professor</title>
<%@include file="allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-6">
							<div class="card border-0">
								<div class="card-body">
									<h4 class="text-center">Add professor</h4>

									<c:if test="${not empty succMsg}">
										<h4 class="text-center text-success">${succMsg}</h4>
										<c:remove var="succMsg" />
									</c:if>

									<c:if test="${not empty errorMsg}">
										<h4 class="text-center text-danger">${errorMsg}</h4>
										<c:remove var="errorMsg" />
									</c:if>
									<form action="../addprofessor" method="post">
										<div class="form-group">
											<label>Enter Name</label> <input type="text" name="na"
												required class="form-control form-control-sm">
										</div>

										
										<div class="form-group">
											<label>Enter Email</label> <input type="text" name="em"
												required class="form-control form-control-sm">
										</div>

										<div class="form-group">
											<label>Enter Password</label> <input type="text" name="ps"
												required class="form-control form-control-sm">
										</div>
										<button class="btn btn-block btn-success">Register</button>

									</form>
								</div>
							</div>
						</div>
						<div class="col-md-6 text-center p-5">
							<img alt="" src="../img/prof.png" width="300px" height="300px">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>