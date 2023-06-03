<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allCss.jsp"%>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/admin_navbar.jsp"%>


	<div class="container p-4">
		<p class="text-center fs-2">Admin Dashboard</p>
		<div class="row">
			<div class="col-md-4">
				<a href="add_store.jsp" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-store fa-2x"></i>
							<p class="fs-3">Store</p>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="add_vcd.jsp" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-compact-disc fa-2x"></i>
							<p class="fs-3">Add VCD</p>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="view_vcd.jsp" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-compact-disc fa-2x"></i>
							<p class="fs-3">View VCD</p>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4 mt-2">
				<a href="order.jsp" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-compact-disc fa-2x"></i>
							<p class="fs-3">Orders</p>
						</div>
					</div>
				</a>
			</div>
		</div>

	</div>




</body>
</html>