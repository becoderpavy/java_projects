<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
<style type="text/css">
.carousel-item:after {
	content: "";
	display: block;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.1);
}
</style>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

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
				<div class="carousel-caption"></div>
				<img class="d-block w-100" src="img/bb3.jpeg" alt="First slide"
					style="width: 100%; height: 350px;">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/bb2.jpg" alt="Second slide"
					style="width: 100%; height: 350px;">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/bb1.jpg" alt="Third slide"
					style="width: 100%; height: 350px;">
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

	<div class="container p-4">
		<div class="p-3">
			<h3 class="text-center">Enter Your Details to Request for Blood</h3>
		</div>
		<form>
			<div class="row">
				<div class="col">
					<input type="text" class="form-control bg-light"
						placeholder="Enter Name">
				</div>
				<div class="col">
					<input type="text" class="form-control bg-light"
						placeholder="Enter Mobile Number">
				</div>
				<div class="col">
					<input type="text" class="form-control bg-light"
						placeholder="Enter Email Address">
				</div>
				<div class="col">
					<select id="inputState" class="form-control bg-light">
						<option selected>Choose Blood Group</option>
						<option>A+</option>
						<option>A-</option>
						<option>AB+</option>
						<option>AB-</option>
						<option>O+</option>
						<option>O-</option>
					</select>
				</div>
			</div>
			<div class="text-center p-3">
				<a href="#" class="btn btn-success">Submit</a>
			</div>
		</form>
	</div>



	<div class="container-fluid p-4" style="background-color: #f0f1f2;">
		<em><h3 class="text-center text-success">Blood Donation
				Benefit</h3></em>
		<div class="row">

			<div class="col-md-6">
				<div class="card border-left-0 border-top-0 border-bottom-0"
					style="height: 310px;">
					<div class="card-body p-5">
						<ul class="p-4">
							<li>Giving blood can reveal potential health problems.</li>
							<li>Giving blood can reduce harmful iron stores.</li>
							<li>Giving blood may lower your risk of suffering a heart
								attack.</li>
							<li>Giving blood may reduce your risk of developing cancer.</li>
							<li>Giving blood can help your liver stay healthy.</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card border-0">
					<div class="card-body">
						<img src="img/bb4.jpg" style="width: 100%; height: 100%;">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div>
		<%@include file="component/footer.jsp"%>
	</div>
</body>
</html>