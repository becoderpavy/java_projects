
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	 <c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if> 
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-6 offset-md-3">
			<c:if test="${not empty succMsg }">
				<div class="alert alert-success" role="alert">${ succMsg}</div>
				<c:remove var="succMsg" />
			</c:if>
			<c:if test="${not empty failedMsg }">
				<h5 class="text-center text-danger">${failedMsg}</h5>
				<c:remove var="failedMsg" scope="session" />
			</c:if>
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>
						<h5>Profile</h5>
					</div>
					<form action="#" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>First Name</label> <input type="text" name="ti" readonly
									required class="form-control" value="${userObj.firstName }">
							</div>

							<div class="form-group col-md-6">
								<label>Last Name</label> <input type="text" name="ti" readonly
									required class="form-control" value="${userObj.lastName }">
							</div>


						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Age</label> <input type="text" name="ti" readonly
									required class="form-control" value="${userObj.age }">
							</div>

							<div class="form-group col-md-6">
								<label>Gender</label> <input type="text" name="ti" readonly
									required class="form-control" value="${userObj.gender }">
							</div>


						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Mobile Number</label> <input type="text" name="ti"
									readonly required class="form-control"
									value="${userObj.mobileNumber }">
							</div>

							<div class="form-group col-md-6">
								<label>Email</label> <input type="text" name="ti" readonly
									required class="form-control" value="${userObj.email }">
							</div>
						</div>

						<div class="form-group">
							<label>Address</label>
							<textarea readonly name="address" rows="2" cols="" class="form-control">${userObj.address }</textarea>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>