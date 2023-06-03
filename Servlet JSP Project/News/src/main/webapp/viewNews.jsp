<%@page import="com.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.DAO.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All News</title>
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
	<c:if test="${not empty msg}">
		<h5 class="text-success text-center" role="alert">${sessionScope.msg}</h5>
		<c:remove var="msg" scope="session" />
	</c:if>



	<div class="container">
		<div class="row p-3">
			<div class="col-md-10 offset-md-1">
				<div class="text-center text-primary">
					<h2>All News</h2>
				</div>

				<c:forEach items="${requestScope.newsList}" var="news">
					<div class="card mt-3">
						<div class="card-body">
							<h3>${news.title}</h3>

							<c:set value="${news.description}" var="descri"></c:set>
							<c:choose>
								<c:when test="${fn:length(news.description)>100}">
									<p>${fn:substring(descri,0,300)}<span
											style="font-size: 20px;"><a
											href="oneNews?nid=${news.id }"> view more..</a></span>
									</p>
								</c:when>
							</c:choose>

							<c:if test="${fn:length(news.description)<100}">
								<p>${news.description}</p>

							</c:if>

							<br>
							<div class=" row text-primary">
								<div class="col-md-12">
									<h6>Time:${news.date}</h6>
								</div>
								<div class="col-md-6">
									<h6>Posted By: ${news.userName}</h6>

								</div>
								<div class="col-md-6 text-right">
									<a href="oneNews?nid=${news.id }"
										class="btn btn-primary btn-sm text-white"> Comment: </a>
								</div>

							</div>

						</div>
					</div>
				</c:forEach>
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