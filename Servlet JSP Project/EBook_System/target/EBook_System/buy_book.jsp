<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 border p-5 text-center">
				<img src="book/c.png" class="img-thumbnail mx-auto d-block"
					style="width: 150px; height: 200px;">
					<h5>Book Name:- <span class="text-success"> C Programming</span></h5>
					<h5>Author Name:- <span class="text-success">Balguruswamy</span></h5>

			</div>
			<div class="col-md-6 border p-5">
				<h2>C programming</h2>
				<p>C is a powerful general-purpose programming language. It can
					be used to develop software like operating systems, databases,
					compilers, and so on. C programming is an excellent language to
					learn to program for beginners.</p>
				<div class="row p-3">
					<div class="col-md-4 text-center  text-primary p-2">
						<i class="fas fa-money-bill-wave fa-2x"></i><br>Cash On
						Delivery
					</div>
					<div class="col-md-4 text-center  text-primary p-2">
						<i class="fas fa-undo-alt fa-2x"></i><br>Return Available
					</div>
					<div class="col-md-4 text-center  text-primary p-2">
						<i class="fas fa-truck fa-2x"></i></i><br>Free Delivery
					</div>
				</div>
				<div class="text-center">
					<a class="btn btn-warning"><i class="fas fa-cart-plus"></i> Add to Cart</a>
					<a class="btn btn-warning"><i class="fas fa-shopping-bag"></i> Buy</a>
				</div>
			</div>
		</div>
	</div>

<div style="margin-top: 100px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>