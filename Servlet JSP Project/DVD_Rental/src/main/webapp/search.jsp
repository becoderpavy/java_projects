<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
.paint-card {
	box-shadow: 0 0 7px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

	<div class="container-fluid p-5"
		style="background: linear-gradient(rgba(0, 0, 0, .7), rgba(0, 0, 0, .7)), url('img/background.jpg'); height: 120vh">
		<div class="row">

			<div class="col-md-2 offset-md-1">
				<a href="search_category.jsp?cat=Action"
					class="text-decoration-none">
					<div class="card">
						<div class="card-header">
							<img alt="" src="img/action.jpg" width="100%" height="200px">
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="search_category.jsp?cat=Drama"
					class="text-decoration-none">
					<div class="card">
						<div class="card-header">
							<img alt="" src="img/drama.jpg" width="100%" height="200px">
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="search_category.jsp?cat=Family"
					class="text-decoration-none">
					<div class="card">
						<div class="card-header">
							<img alt="" src="img/family.jpg" width="100%" height="200px">
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="search_category.jsp?cat=Horror"
					class="text-decoration-none">
					<div class="card">
						<div class="card-header">
							<img alt="" src="img/horror.jpg" width="100%" height="200px">
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-2">
				<a href="search_category.jsp?cat=Comedy"
					class="text-decoration-none">
					<div class="card">
						<div class="card-header">
							<img alt="" src="img/comedy.jpg" width="100%" height="200px">
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-8 offset-md-2 mt-5">
				<form action="search_result.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch"
							placeholder="Enter movie name">
						<button
							class="btn btn-primary ms-2 text-white col-md-3 badge rounded-pill">
							<i class="fa-solid fa-magnifying-glass"></i> Search
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>