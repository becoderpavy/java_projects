<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.OrganizationDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NGO : Home</title>
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
	<c:if test="${empty adobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid">
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg }">
			<h5 class="text-center text-success">${succMsg}</h5>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<div class="text-center">
			<img alt="" src="../img/admin.jpg" width="50%" height="300px;">
		</div>

		<!-- <h3 class="text-center text-success bg-white p-1">
			Hello Welcome to Happy Paws
		</h3> -->
		<div class="row" style="padding: 20px;">

			<div class="col-md-3">
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
			<div class="col-md-3">
				<a href="help_seeker.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user-circle fa-3x text-primary"></i><br>
							<h4>Help Seeker</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-3">
				<a href="orphans.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user-circle fa-3x text-primary"></i><br>
							<h4>Orphans</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-3">
				<a href="donor.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-donate fa-3x text-success"></i></i><br>
							<h4>Donor</h4>
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



	
</body>
</html>