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
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty recObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
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
								<label>Comapny Name</label> <input type="text" name="ti"
									readonly required class="form-control"
									value="${recObj.companyName }">
							</div>

							<div class="form-group col-md-6">
								<label>Recruiter Name</label> <input type="text" name="ti"
									readonly required class="form-control"
									value="${recObj.recruiterName }">
							</div>


						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Mobile Number</label> <input type="text" name="ti"
									readonly required class="form-control" value="${recObj.mobno }">
							</div>

							<div class="form-group col-md-6">
								<label>Email Id</label> <input type="text" name="ti" readonly
									required class="form-control" value="${recObj.email }">
							</div>


						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Account Status</label> <input type="text" name="ti"
									readonly required class="form-control"
									value="${recObj.status }">
							</div>

							<div class="form-group col-md-6">
								<label>Gold Membership</label> <input type="text" name="ti"
									readonly required class="form-control"
									value="${recObj.payment }">
							</div>


						</div>


						<div class="form-group">
							<label>Address</label>
							<textarea required rows="3" cols="" name="de" readonly
								class="form-control">${recObj.address }</textarea>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>