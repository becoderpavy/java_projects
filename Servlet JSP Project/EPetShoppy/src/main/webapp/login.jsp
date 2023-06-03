<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>

<!-- CSS Only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<link rel="stylesheet" href="css\bootstrap.min.css">
<link rel="stylesheet" href="fonts\icomoon\icomoon.css">
<link rel="stylesheet" href="css\main.css">

<script src="js\jquery.js"></script>
<script src="js\tether.min.js"></script>
<script src="js\bootstrap.min.js"></script>

</head>
<body>
	<!-- BEGIN .app-wrap -->
	<div class="app-wrap">
		<!-- BEGIN .app-heading -->
		<header class="app-header">
			<div class="container-fluid">
				<div class="row gutters">
					<div class="col-xl-7 col-lg-7 col-md-6 col-sm-7 col-4">
						<img src="images/logo.png" alt="logo here" height="50">
					</div>
					<div class="col-xl-5 col-lg-5 col-md-6 col-sm-5 col-4">
						<ul class="header-actions">
							<li><a href="E_PetShoppy">Home</a></li>
							<li><a href="">About</a></li>
							<li><a href="">Breeds</a></li>
							<li><a href="">Login</a></li>
							<li><a href="">Contact</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<!-- END: .app-heading -->
		<div class="container">
			<div class="login-screen row align-items-center">
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
					<div class="card">
						<div class="card-body">
							<form action=BuyerDashboard.jsp method=post>
								<div class="login-container">
									<div class="row no-gutters">
										<div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
											<div class="login-box">
												<div class="input-group">
													<input type="text" class="form-control" id="txtuname"
														name="uname" placeholder="Username" aria-label="username"
														aria-describedby="username">
												</div>
												<br>
												<div class="input-group">
													<input type="password" class="form-control" id="txtpwd"
														name="pwd" placeholder="Password" aria-label="Password"
														aria-describedby="password">
												</div>
												<div class="actions clearfix">
													<a href="forgot-pwd.htm">Lost password?</a>
													<button type="submit" class="btn btn-primary">Login</button>
												</div>
												<div class="or"></div>
												<div class="mt-4">
													<a href="buyer_reg.jsp" class="additional-link">Don't
														have an Account? <span>Create Now</span>
													</a>
												</div>
											</div>
										</div>
										<div class="col-xl-8 col-lg-7 col-md-6 col-sm-12">
											<div class="login-slider"></div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- BEGIN .main-footer -->
		<footer class="main-footer fixed-btm"> Copyright Shruti
			Shiradwade MCA Mini Project 2021. </footer>
		<!-- END: .main-footer -->
	</div>
	<!-- END: .app-wrap -->

</body>
</html>