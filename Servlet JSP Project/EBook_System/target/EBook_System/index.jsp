<%@page import="com.conn.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.back-img {
	background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)),
		url("img/b2.jpg");
	width: 100%;
	height: 50vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>


<%@include file="all_component/navbar.jsp" %>
	<!-- start banner -->
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">
				<i class="fa fa-book" aria-hidden="true"></i> E-Book Management
				System
			</h1>
		</div>
	</div>
	<!-- end banner -->

	<!-- Recent start book -->
	<div class="container p-4">
		<h2 class="text-center">Recent Book</h2>
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c2.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm">View All</a>
		</div>
	</div>
	<!--Recent end book-->
	<hr>

	<!-- Recent start book -->

	<div class="container p-4">
		<h2 class="text-center">Old Book</h2>
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c2.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm">View All</a>
		</div>
	</div>

	<!-- End start book -->

	<hr>

	<!-- Recent start book -->

	<div class="container p-4">
		<h2 class="text-center">Exchange Book</h2>
		<div class="row">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c2.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm">View All</a>
		</div>
	</div>

	<!-- End start book -->




	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>