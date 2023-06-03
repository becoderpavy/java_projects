<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.bg-custom {
	background-color: #fb8c00;
}

.navbar .nav-item .nav-link {
	font-size: 20px;
	color: white;
}

.navbar-custom .nav-item:hover .nav-link {
	background: white;
	color: black !important;
	border-radius: 10px;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background-color: #f0f1f2">
	<!-- Start Navbar -->

	<nav
		class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
		<a class="navbar-brand" href="#">News</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="AddNews.jsp">Add News</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="viewServlet">View News</a></li>
			</ul>

		</div>
	</nav>

	<!-- end navbar -->

	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Add News Here</h4>

						<c:if test="${not empty msg}">
							<h5 class="text-success text-center" role="alert">${sessionScope.msg}</h5>
							<c:remove var="msg" scope="session" />
						</c:if>

						<form action="AddNewsServlet" method="post">
							<div class="form-froup">
								<label>Enter Title</label> <input type="text"
									class="form-control" name="title">
							</div>

							<div class="form-froup">
								<label>Enter Description</label>
								<textarea rows="5" cols="" name="description"
									class="form-control"></textarea>
							</div>

							<div class="form-froup">
								<label>Enter Your Name</label> <input type="text"
									class="form-control" name="name">
							</div>
							<div class="text-center mt-3">
								<button type="submit" class="btn btn-success btn-block">Add</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>