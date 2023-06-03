<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
} 
</style>

</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty shopobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container-fluid">
		
		<img alt="" src="../img/petshop.jpg" width="100%" height="470px;">
		
		<!-- <h3 class="text-center text-success bg-white p-1">
			Hello Welcome to Happy Paws
		</h3> -->
		<div class="row" style="padding: 20px;">
		<div class="col-md-3">
				<a href="shop_details.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x text-primary"></i><br>
							<h4>Shop Details</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="add_pet.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x text-primary"></i><br>
							<h4>Add Pet</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-3">
				<a href="view_pets.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-address-card fa-3x text-success"></i></i><br>
							<h4>View Pet</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-3">
				<a href="order.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-shopping-cart fa-3x text-danger"></i></i><br>
							<h4>Orders</h4>
							-----------
						</div>
					</div>
				</a>
			</div>



		</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="text-center">
						<h4>Do You want logout</h4>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<a href="../logout" type="button"
							class="btn btn-primary text-white">Logout</a>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<!-- end logout modal -->

	<div style="margin-top: 200px;">
		<%@include file="footer.jsp"%></div>


</body>
</html>