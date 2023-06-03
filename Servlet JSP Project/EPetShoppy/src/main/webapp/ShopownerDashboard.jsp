<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopOwner Dashboard</title>
<!-- CSS Only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<link rel="stylesheet" href="css\bootstrap.min.css">
<link rel="stylesheet" href="fonts\icomoon\icomoon.css">
<link rel="stylesheet" href="css\main.css">

<script src="js\jquery.js"></script>
<script src="js\tether.min.js"></script>
<script src="js\bootstrap.min.js"></script>

<script>
		function DisplayPet()
		{
			ob = new XMLHttpRequest();
			ob.open("GET","DisplayBuyerList.jsp");
			ob.send();
			ob.onreadystatechange=function()
			{
				if(ob.status==200 && ob.readyState==4)
					{
						document.getElementById("output").innerHTML=ob.responseText;
					}
			}
		}
		
		
</script>

</head>
<body onload="DisplayPet()">
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
								<li><a href="">Add Pets</a></li>
								<li><a href="">View Pets</a></li>
								<li><a href="">View Adopted Pets</a></li>
								<li class="nav-item dropdown">
        							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          							Dropdown
        							</a>
        							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          							<a class="dropdown-item" href="#">Profile</a>
          							<a class="dropdown-item" href="#">Logout</a>
          							
        							</div>
     							 </li>										
							</ul>
						</div>
					</div>
				</div>
			</header>
			<!-- END: .app-heading -->
			<!-- BEGIN .app-container -->
			<div class="app-container">
				<!-- BEGIN .app-main -->
				<div class="app-main">
				<!-- Row start -->
						
						
									
				<!-- Row end -->
					
					<!-- BEGIN .main-content -->
					<div class="main-content">
						<!-- Row start -->
						<div class="row gutters">
						<h4 style="text-align:center;">Catagories</h4>
							<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
								<div class="card">
									<div class="card-body">
										<div class="stats-widget">
											<div class="stats-widget-header">
												<i class="icon-facebook"></i>
											</div>
											<div class="stats-widget-body">
												<!-- Row start -->
												<ul class="row no-gutters">
													<img src="images/Catagory-dog.jpg">
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
								<div class="card">
									<div class="card-body">
										<div class="stats-widget">
											<div class="stats-widget-header">
												<i class="icon-twitter"></i>
											</div>
											<div class="stats-widget-body">
												<!-- Row start -->
												<ul class="row no-gutters">
													<img src="images/Catagory-cat.jpg" height="172" width="229">
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
								<div class="card">
									<div class="card-body">
										<div class="stats-widget">
											<div class="stats-widget-header">
												<i class="icon-googleplus"></i>
											</div>
											<div class="stats-widget-body">
												<!-- Row start -->
												<ul class="row no-gutters">
													<img src="images/Catagory-parrot.jpg" height="172" width="229">
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
								<div class="card">
									<div class="card-body">
										<div class="stats-widget">
											<div class="stats-widget-header">
												<i class="icon-rss"></i>
											</div>
											<div class="stats-widget-body">
												<!-- Row start -->
												<ul class="row no-gutters">
													<img src="images/others.jpg" height="172" width="229">
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Row end -->
						
						<!-- Row start -->
							<div class="row gutters">
								<div class="card">
									<div class="card-body">
										<div class="row form-group">
											<input type="text" class="form-control" id="textsearch" name="textsearch" onkeyUp="DisplayPets()" placeholder="Search Here">
										</div>
										<table class="table m-0" id="output">
										
											
										</table>
									</div>
								</div>
							</div>
						<!-- Row end -->
						
						<!-- Row start -->
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
								<div class="card">	
									<div class="card-body">
										<!-- Row start -->
										<div class="row gutters">
											<div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
												<h6 class="card-title mt-0"></h6>
												<div class="chartist custom-one">
													<div class="line-chart"></div>
												</div>
												<div class="download-details">
													<p></p>
												</div>
											</div>
											<div class="col-xl-2 col-lg-2 col-md-2 col-sm-12">
												<div class="monthly-avg">
													<h6></h6>
													<div class="avg-block">
														<h4 class="avg-total text-secondary"></h4>
														<h6 class="avg-label">
															
														</h6>
													</div>
													<div class="avg-block">
														<h4 class="avg-total text-primary"><sup></sup></h4>
														<h6 class="avg-label">
															
														</h6>
													</div>
												</div>
											</div>
											<div class="col-xl-5 col-lg-5 col-md-5 col-sm-12">
												<h6 class="card-title mt-0"></h6>
												<div class="chartist custom-two">
													<div class="line-chart2"></div>
												</div>
												<div class="download-details">
													<p><sup></sup> </p>
												</div>
											</div>
										</div>
										<!-- Row end -->
									</div>
								</div>
							</div>
						</div>
						<!-- Row end -->
					</div>
					<!-- END: .main-content -->
				</div>
				<!-- END: .app-main -->
			</div>
			<!-- END: .app-container -->
			<!-- BEGIN .main-footer -->
			<footer class="main-footer fixed-btm">
				Copyright Shruti Shiradwade MCA Mini Project 2021.
			</footer>
			<!-- END: .main-footer -->
		</div>
		<!-- END: .app-wrap -->
</body>
</html>