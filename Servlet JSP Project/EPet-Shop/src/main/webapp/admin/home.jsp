<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.PetDAOImpl"%>
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

	<c:if test="${empty adminObj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">
		<h3 class="text-center text-success bg-white p-1">
			Hello Admin<br> Welcome to Happy Paws
		</h3>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg }">
			<h5 class="text-center text-success">${succMsg}</h5>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<div class="row" style="padding: 120px;">

			<div class="col-md-4">
				<a href="category.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-sign-out-alt fa-3x text-primary"></i><br>
							<h4>Category</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="view_user.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user fa-3x text-primary"></i><br>
							<h4>User</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-4">
				<a href="view_shop.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-store fa-3x text-danger"></i></i><br>
							<h4>Shop</h4>
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

	<div style="margin-top: 150px;">
		<%@include file="footer.jsp"%></div>


</body>
</html>