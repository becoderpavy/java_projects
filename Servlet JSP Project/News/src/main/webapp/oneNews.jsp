<%@page import="com.entity.Comment"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.DAO.NewsDAO"%>
<%@page import="com.entity.News"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Single News</title>
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
<body style="background-color: #f2eded;">
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



	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="text-center text-primary">
					<h2>All News</h2>
				</div>

				<div class="card mt-3">
					<div class="card-body">
						<h3>${singleNews.title}</h3>

						<p>${singleNews.description }</p>



						<br>
						<div class=" row text-primary">
							<div class="col-md-12">
								<h6>Time: ${singleNews.date}</h6>
							</div>
							<div class="col-md-6">
								<h6>Posted By: ${singleNews.userName}</h6>

							</div>


						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-10 ">
				<div class="card">
					<div class="card-body">
						<form action="comment" method="get">
							<input type="hidden" value="${singleNews.id}" name="nid">
							<div class="form-group">
								<input type="text" name="username" class="form-control"
									placeholder="Enter Your Name">
							</div>
							<div class="form-group">
								<textarea rows="3" cols="" placeholder="Comment"
									class="form-control" name="comment"></textarea>
							</div>
							<button class="btn btn-primary btn-sm text-white">Post
								Comment</button>
						</form>
					</div>
					<div class="card-footer ">
						<h3 class="text-center text-danger">All Comment</h3>
						<c:forEach var="cmt" items="${requestScope.comntList}">

							<h5>Name:${cmt.userName}</h5>
							<p>Comment: ${cmt.comment}</p>
							<hr>
						</c:forEach>
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