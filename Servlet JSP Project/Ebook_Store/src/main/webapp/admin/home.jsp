<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<%@include file="allCss_file.jsp"%>
<style type="text/css">
a {
	text-decoration: none !important;
	outline: none;
	color: green;
}

a:hover {
	color: green;
}

a .card {
	box-shadow: 5px 5px #f0f1f2;
}
</style>
</head>
<body>
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-5">
		<div class="row">

			<div class="col-md-4 offset-md-2">
				<a href="add_professor.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user-tie fa-3x"></i>
							<h4>Add Professor</h4>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="professor.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user-tie fa-3x"></i>
							<h4>Professor</h4>
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-4 offset-md-2 mt-4">
				<a href="add_book.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x"></i>
							<h4>Add Books</h4>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4 mt-4">
				<a href="view_book.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-address-card fa-3x"></i>
							<h4>View Books</h4>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>