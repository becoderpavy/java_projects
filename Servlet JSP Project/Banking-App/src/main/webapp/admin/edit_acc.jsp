<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin :Edit Account</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f7e7e6;">
	<%@include file="main_navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 p-4 offset-md-2">
				<div class="card">
					<c:if test="${not empty user}">
						<div class="card-body">
							<div
								class="container d-flex justify-content-center align-items-center">
								<div
									style="width: 100px; height: 100px; border: 1px black solid;">
									<img alt="" src="../img/pf.png"
										style="width: 100px; height: 100px">
								</div>
							</div>


							<form action="../update" method="post">
								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">Account</label>
									<div class="col-sm-3">
										<input type="number" class="form-control form-control"
											id="colFormLabel" value="${user.accountNo}" name="accno" readonly="readonly">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">Username</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.userid}" name="uname" readonly="readonly" >
									</div>

								</div>


								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">First
										Name</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.firstName }" name="fname">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">Last
										Name</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.lastName}" name="lname">
									</div>

								</div>


								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">Email</label>
									<div class="col-sm-3">
										<input type="email" class="form-control form-control"
											id="colFormLabel" value="${user.email }" name="email">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">Phone
										No</label>
									<div class="col-sm-3">
										<input type="number" class="form-control form-control"
											id="colFormLabel" value="${user.number}" name="phno">
									</div>

								</div>


								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">Date
										Of Birth</label>
									<div class="col-sm-3">
										<input type="date" class="form-control form-control"
											id="colFormLabel" value="${user.dob}" name="dob">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">Aadhar
										No</label>
									<div class="col-sm-3">
										<input type="number" class="form-control form-control"
											id="colFormLabel" value="${user.adhar}" name="adhno">
									</div>

								</div>

								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">Address</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.address}" name="address">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">City</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.city}" name="city">
									</div>
								</div>

								<div class="form-group row mt-3">
									<label for="colFormLabel"
										class="col-sm-2 offset-sm-1 col-form-label col-form-label">State</label>
									<div class="col-sm-3">
										<input type="text" class="form-control form-control"
											id="colFormLabel" value="${user.state}" name="state">
									</div>

									<label for="colFormLabel"
										class="col-sm-2  col-form-label col-form-label">Status</label>
									<div class="col-sm-3">
										<c:if test="${user.status eq 'active'}">
											<select class="form-control " name="sts">
												<option value="active">Active</option>
												<option value="inactive">Inactive</option>
											</select>
										</c:if>

										<c:if test="${user.status eq 'inactive'}">
											<select class="form-control" name="sts">
												<option value="inactive">Inactive</option>
												<option value="active">active</option>
											</select>
										</c:if>
									</div>
								</div>
								
								<div class="text-center">
								<button class="btn btn-success">Update</button>
								</div>
								
							</form>
						</div>
					</c:if>
					<!--  -->

				</div>
			</div>
		</div>
	</div>


</body>
</html>