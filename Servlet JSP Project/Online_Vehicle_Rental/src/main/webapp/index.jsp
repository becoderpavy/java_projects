<%@page import="com.entites.Vehicle"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/vx3.jpeg" class="d-block w-100" alt="..."
					height="350px">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img src="img/vx2.jpeg" class="d-block w-100" alt="..."
					height="350px">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img src="img/vx.png" class="d-block w-100" alt="..." height="350px">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<div class="container-fluid bg-light">


		<p class="text-center fs-5 mt-2">Vehicle</p>
		<div class="row">

			<%
			VehicleDao dao = new VehicleDao(DBConnect.getConnection());
			List<Vehicle> list = dao.getAllVehicle();
			int i = 0;

			for (Vehicle v : list) {
				i++;
				if (i <= 4) {
			%>
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<img alt="" src="img/vehicle_img/<%=v.getImage()%>" width="100%"
							height="150px">
					</div>
				</div>
			</div>
			<%
			}
			}
			%>

		</div>
	</div>

	<div class="container mt-2">
		<p class="text-center fs-3">About Us</p>
		<div class="row">
			<div class="col-md-6">
				<img alt="" src="img/tr4.png" height="300px" width="100%">
			</div>
			<div class="col-md-6 p-5">
				<p>Lorem Ipsum is simply dummy text of the printing and
					typesetting industry. Lorem Ipsum has been the industry's standard
					dummy text ever since the 1500s, when an unknown printer took a
					galley of type and scrambled it to make a type specimen book. It
					has survived not only five centuries, but also the leap into
					electronic</p>
			</div>
		</div>
	</div>



	<%@include file="component/footer.jsp"%>



</body>
</html>
