<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
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
<title>Shop: Add Pet</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty shopobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-6">
						<form action="../add_pet" method="post"
							enctype="multipart/form-data">
							<div class="login-box">
								<h1 class="text-center">Add Details of Pet</h1>
								<p class="text-center">For all pet care taker and pet lovers</p>
								<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg }</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>

								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg }</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>
								<input type="hidden" value="${shopobj.id}" name="si">

								<div class="form-group">
									<label for="Catagory" class="form-label">Catagory:</label> <select
										class="form-control" name="ca">
										<option value="select">--select--</option>
										<%
										PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
										List<Category> list = dao.getAllCategory();
										for (Category c : list) {
										%>
										<option value="<%=c.getCategoryName()%>"><%=c.getCategoryName()%></option>
										<%
										}
										%>



									</select>
								</div>

								<div class="form-group">
									<label for="Pet name" class="form-label">Title</label> <input
										required type="text" class="form-control" id="txtpname"
										name="pa" placeholder="Enter breed of the pet"> <small
										id="errpname" class="form-text text-muted"></small>
								</div>

								<div class="form-group">
									<label for="last name" class="form-label">Description:</label>
									<textarea class="form-control" id="txtdesc" name="de" required
										rows="3"></textarea>
								</div>

								<div class="form-group">
									<label for="cost" class="form-label">Price:</label> <input
										required type="number" class="form-control" id="txtcost"
										name="pr" placeholder="Enter Cost"> <small
										id="errcost" class="form-text text-muted"></small>
								</div>

								<div class="form-group">
									<label for="disc" class="form-label">Stock </label> <input
										type="number" class="form-control" id="txtdisc" name="st"
										required placeholder="Enter No of Available"> <small
										id="errdisc" class="form-text text-muted"></small>
								</div>

								<div class="form-group">
									<label for="last name" class="form-label">Pet Image:</label> <input
										type="file" class="form-control" id="pic" name="img"
										placeholder="Enter your city name">
								</div>


								<button type="submit" class="btn btn-primary">Add Pet</button>

							</div>
						</form>

					</div>
					<div class="col-md-4 offset-md-1 mt-5">
						<img alt="" src="../img/pet.png" width="400" height="450">
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