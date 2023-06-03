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
	%>

	<div class="container p-5">
		<div class="card">
			<div class="card-body">
				<div class="row">

					<div class="col-md-4 p-5">
						<img alt="" src="../img/pet.png" width="300" height="300">
					</div>
					<div class="col-md-6 offset-md-1">
						<h1 class="text-center">Edit Shop Details</h1>

						<form action="../update_shop" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="Catagory" class="form-label">User Name:</label> <input
										required type="text" class="form-control" id="txtcat"
										name="on" value="${shopobj.ownerName }">

								</div>
								<div class="form-group col-md-6">
									<label for="Pet name" class="form-label">Shop Name:</label> <input
										required type="text" class="form-control" id="txtpname"
										name="sn" value="${shopobj.shopName }">

								</div>
							</div>

							<div class="form-row ">
								<div class="form-group col-md-6">
									<label for="cost" class="form-label">Email Id:</label> <input
										required type="text" class="form-control" id="txtcost"
										name="em" value="${shopobj.email }">
								</div>

								<div class="form-group col-md-6">
									<label for="disc" class="form-label">Mobile No </label> <input
										type="number" class="form-control" id="txtdisc" name="phno"
										value="${shopobj.phno}">
								</div>
							</div>

							<div class="form-row ">
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Address:</label>
									<textarea class="form-control" id="txtdesc" name="ad"
										required rows="3">${shopobj.address}</textarea>
								</div>

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">City:</label> <input
										required type="text" class="form-control" id="ci"
										name="ci" value="${shopobj.city}">
								</div>
							</div>
							<div class="form-row ">
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">State:</label> <input
										required type="text" class="form-control" id="txtpname"
										name="sta" value="${shopobj.state}">
								</div>

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Password:</label> <input
										required type="text" class="form-control" id="txtpname"
										name="psw" value="${shopobj.password }">
								</div>
								<input type="hidden" name="id" value="${shopobj.id }">
							</div>
							<button class="btn btn-primary">Update</button>
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