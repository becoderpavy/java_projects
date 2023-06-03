<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop: Details</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
input[readonly] {
	background-color: red;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty shopobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">
				<div class="text-right">
					<a href="edit_shop.jsp" class="btn btn-danger text-white"><i
						class="fas fa-edit"></i> Edit</a>
				</div>
				<div class="row">

					<div class="col-md-4 p-5">
						<img alt="" src="../shop_img/${shopobj.image }" width="300" height="300">
					</div>
					<div class="col-md-6 offset-md-1">
						<h1 class="text-center">Details of Shop</h1>
						
						<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg }</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>

								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg }</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>

						<form class="mt-3">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="Catagory" class="form-label">User Name:</label> <input
										required type="text" class="form-control" id="txtcat"
										name="txtcat" readonly value="${shopobj.ownerName }">

								</div>
								<div class="form-group col-md-6">
									<label for="Pet name" class="form-label">Shop Name:</label> <input
										readonly required type="text" class="form-control"
										id="txtpname" name="txtpname" value="${shopobj.shopName }">

								</div>
							</div>

							<div class="form-row ">
								<div class="form-group col-md-6">
									<label for="cost" class="form-label">Email Id:</label> <input
										readonly required type="text" class="form-control"
										id="txtcost" name="txtcost" value="${shopobj.email }">
								</div>

								<div class="form-group col-md-6">
									<label for="disc" class="form-label">Mobile No </label> <input
										readonly type="number" class="form-control" id="txtdisc"
										name="txtdisc" value="${shopobj.phno}">
								</div>
							</div>


							<div class="form-group">
								<label for="last name" class="form-label">Address:</label>
								<textarea class="form-control" id="txtdesc" name="txtdesc"
									readonly required rows="3">${shopobj.address},${shopobj.city},${shopobj.state}</textarea>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!-- end logout modal -->

	<div style="margin-top: 200px;">
		<%@include file="footer.jsp"%></div>


</body>
</html>