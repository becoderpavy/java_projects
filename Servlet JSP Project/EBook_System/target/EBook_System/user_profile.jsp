<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #e5e4e2">
	<%@include file="all_component/navbar.jsp"%>
	<h3 class="text-center">Hello,Pabitra Das</h3>
	<div class="container p-5">

		<div class="row">
			<div class="col-md-6">
				<a href="sell_book.jsp"><div class="card text-center">
						<div class="card-body">
							<div class="text-primary ">
								<i class="fas fa-book-open fa-3x"></i>
							</div>
							<h4>Sell Old Book</h4>

						</div>
					</div></a>
			</div>

			<div class="col-md-6">
				<a href="exchange_book.jsp"><div class="card text-center ">
						<div class="card-body">
							<div class="text-warning ">
								<i class="fas fa-book-open fa-3x"></i>
							</div>
							<h4>Exchange Book</h4>
						</div>
					</div></a>
			</div>

		</div>


		<div class="row mt-3">
			<div class="col-md-3">
				<a href="edit_profile.jsp"><div class="card text-center">
						<div class="card-body">
							<div class="text-primary ">
								<i class="fas fa-id-card fa-3x"></i>
							</div>
							<h4>Login & Security</h4>
							<p>Edit Profile</p>
						</div>
					</div></a>
			</div>

			<div class="col-md-3">
				<a href="user_address.jsp"><div class="card text-center ">
						<div class="card-body">
							<div class="text-warning ">
								<i class="fas fa-map-marker-alt fa-3x"></i>

							</div>
							<h4>Your Address</h4>
							<p>Edit Address</p>
						</div>
					</div></a>
			</div>

			<div class="col-md-3">
				<a href="user_order.jsp"><div class="card text-center">
						<div class="card-body">
							<div class="text-danger">
								<i class="fas fa-box-open fa-3x"></i>
							</div>
							<h4>My Order</h4>
							<p>Track your Order</p>
						</div>
					</div></a>
			</div>

			<div class="col-md-3">
				<a href="#"><div class="card  text-center">
						<div class="card-body">
							<div class="text-primary ">
								<i class="fas fa-user-circle fa-3x"></i>
							</div>
							<h4>Help Center</h4>
							<p>24*7 Service</p>
						</div>
					</div></a>
			</div>

		</div>
	</div>
	<div style="margin-top: 0px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>