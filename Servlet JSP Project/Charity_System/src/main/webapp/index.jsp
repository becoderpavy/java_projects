<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">
.carousel-item:after {
	content: "";
	display: block;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.4);
}

.carousel-caption {
	color: #fff;
	top: 20%;
}
</style>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<div class="carousel-caption ">
					<h1 class=" text-white">Donate A better World</h1>
					<h5>No has never ever become poor by giving</h5>
					<a href="home.jsp" class="btn btn-warning text-white"><i class="fas fa-hand-holding-usd" ></i>  Donate Now</a>
				</div>
				<img class="d-block w-100" src="img/ch1.jpg" alt="First slide"
					style="width: 100%; height: 550px;">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/ch2.jpg" alt="Second slide"
					style="width: 100%; height: 550px;">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/ch3.jpg" alt="Third slide"
					style="width: 100%; height: 550px;">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>



</body>
</html>