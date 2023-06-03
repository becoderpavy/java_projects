
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook: Index</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: linear-gradient(rgba(0, 0, 0, .1), rgba(0, 0, 0, .1)),
		url("img/home.jpg");
	height: 100vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>

</head>
<body style="background-color: #f7f7f7;">

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img text-white text-center p-5">
		<h2 class="text-center">Humanizing Them!</h2>
		<p>Money can buy you a fine dog, but only love can make him wag his tail.</p>
	</div>


	<!-- Start Recent Book -->

	<!-- <div class="container">
		<h3 class="text-center">Categories</h3>
		<div class="row">

			<div class="col-md-4">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<a href="animals.jsp"> <img alt="" src="img/animal.jpg"
							style="width: 280px; height: 200px" class="img-thumblin"><br>
							<br>
							<h4>Animal</h4>
						</a>

					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<a href="birds.jsp"> <img alt="" src="img/bird.jpg"
							style="width: 280px; height: 200px" class="img-thumblin"><br>
							<br>
							<h4>Bird</h4>
						</a>

					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<a href="others.jsp"> <img alt="" src="img/others.jpg"
							style="width: 150px; height: 200px" class="img-thumblin"><br>
							<br>
							<h4>Others</h4>
						</a>
					</div>
				</div>
			</div>


		</div>
	</div> -->
	<!-- End Recent Book -->


	<%@include file="all_component/footer.jsp"%>

</body>
</html>