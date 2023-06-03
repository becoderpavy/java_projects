
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
<% out.print(DBConnect.getConnection()); %>
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
				<img src="img/paint3.jpg" class="d-block w-100" alt="..."
					height="450px">
				<div class="carousel-caption d-none d-md-block">
					<a href="#"
						class="btn btn-light btn-outline-primary text-custom col-md-4">Buy
						Now</a>
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/paint2.jpg" class="d-block w-100" alt="..."
					height="450px">
				<div class="carousel-caption d-none d-md-block">
					<a href="#"
						class="btn btn-light btn-outline-primary text-custom col-md-4">Buy
						Now</a>
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/paint.jpg" class="d-block w-100" alt="..."
					height="450px">
				<div class="carousel-caption d-none d-md-block">
					<a href="#"
						class="btn btn-light btn-outline-primary text-custom col-md-4">Buy
						Now</a>
				</div>
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
	<p class="fs-3 text-center">Latest Painting</p>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/paint4.jpg" height="250px" width="100%">


					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/paint5.jpg" height="250px" width="100%">


					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/paint2.jpg" height="250px" width="100%">


					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/paint6.jpg" height="250px" width="100%">


					</div>
				</div>
			</div>


		</div>
	</div>
	<%@include file="component/footer.jsp"%>



</body>
</html>
