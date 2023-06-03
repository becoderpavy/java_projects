<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.OrganizationDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NGO : Add Patient</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty orgobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<%@include file="navbar.jsp"%>

	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-4 ">
								<img src="../img/ch4.jpg" width="400" height="450">
							</div>
							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">Add User</h4>
								<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg }</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>

								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg }</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>

								<form action="../add_patient" method="post"
									enctype="multipart/form-data">
									<div class="form-row">
										<input type="hidden" value="${orgobj.id}" name="oid">

										<div class="form-group col-md-6">
											<label>Enter Name</label> <input type="text" name="na"
												required class="form-control form-control-sm">
										</div>

										<div class="form-group col-md-6">
											<label>Problem</label> <input type="text" name="pr" required
												class="form-control form-control-sm">
										</div>
									</div>

									<div class="form-group">
										<label>Address</label>
										<textarea required rows="3" cols="" class="form-control"
											name="ad"></textarea>
									</div>
									<div class="form-group">
										<label>User Image</label> <input required type="file"
											name="img" class="form-control form-control-sm">
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label>Document</label> <input required type="file"
												name="doc" class="form-control form-control-sm">
										</div>
										<div class="form-group col-md-6">
											<label>Need Money</label> <input required type="number"
												name="nm" class="form-control ">
										</div>
									</div>

									<div class="form-group">
										<label for="inputState"> Categories</label> <select
											id="inputState" name="categories" class="form-control form-control-sm">
											<option selected>--select--</option>
											<%
											OrganizationDAOImpl dao = new OrganizationDAOImpl(DBConnect.getConn());
											List<Category> list = dao.getAllCategory();
											for (Category c : list) {
											%>
											<option value="<%=c.getCategoryName()%>"><%=c.getCategoryName()%></option>
											<%
											}
											%>

										</select>
									</div>

									<button type="submit" class="btn btn-primary btn-block">Submit</button>


								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>