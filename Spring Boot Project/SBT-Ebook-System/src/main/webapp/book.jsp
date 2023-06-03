<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 3px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid p-5" style="background-color: #f0f1f2;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="search.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch">
						<button class="btn bg-success ms-2 text-white">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">

			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Categories</p>
						<div class="list-group" style="width: 100%;">

							<a href="?cat=all" type="button"
								class="active list-group-item list-group-item-action"
								aria-current="true">All</a> <a href="?cat=" type="button"
								class="list-group-item list-group-item-action"
								aria-current="true">Science</a> <a href="?cat=" type="button"
								class="list-group-item list-group-item-action"
								aria-current="true">Programming</a>

						</div>
					</div>
				</div>
			</div>

			<div class="col-md-9 p-0">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">BOOKS</p>

						<div class="row">


							<div class="col-md-3">
								<a href="#" class="text-decoration-none text-dark">
									<div class="card paint-card mt-2">
										<div class="card-body text-center">
											<img alt="" src="book_img/linux.jpg" height="170px"
												width="100%">
											<p class="fs-5">
												Linux<br> <span class="fs-6">Category:
													Programming</span>
											</p>
											<h5>
												<i class="fas fa-rupee-sign"></i> 300
											</h5>
											<a href="#" class="btn btn-danger col-md-12">Add To Cart</a>
										</div>
									</div>

								</a>
							</div>

							<div class="col-md-3">
								<a href="#" class="text-decoration-none text-dark">
									<div class="card paint-card mt-2">
										<div class="card-body text-center">
											<img alt="" src="book_img/c.png" height="170px" width="100%">
											<p class="fs-5">
												C Programming<br> <span class="fs-6">Category:
													Programming</span>
											</p>
											<h5>
												<i class="fas fa-rupee-sign"></i> 300
											</h5>
											<a href="#" class="btn btn-danger col-md-12">Add To Cart</a>
										</div>
									</div>

								</a>
							</div>

							<div class="col-md-3">
								<a href="#" class="text-decoration-none text-dark">
									<div class="card paint-card mt-2">
										<div class="card-body text-center">
											<img alt="" src="book_img/java.jpg" height="170px"
												width="100%">
											<p class="fs-5">
												Java<br> <span class="fs-6">Category:
													Programming</span>
											</p>
											<h5>
												<i class="fas fa-rupee-sign"></i> 300
											</h5>
											<a href="#" class="btn btn-danger col-md-12">Add To Cart</a>
										</div>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>