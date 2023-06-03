<%@page import="com.entity.PetDtls"%>
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
<title>Shop: Edit Pet</title>
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
				<%
				int pid = Integer.parseInt(request.getParameter("pid"));
				int sid = Integer.parseInt(request.getParameter("sid"));
				PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
				PetDtls p = dao.getPetsById(pid, sid);
				%>
				<div class="row">
					<div class="col-md-6">
						<form action="../update_pet" method="post"
							enctype="multipart/form-data">
							<div class="login-box">
								<h1 class="text-center">Edit Details of Pet</h1>
								<p class="text-center">For all pet care taker and pet lovers</p>

								<input type="hidden" value="<%=pid%>" name="pid"> <input
									type="hidden" value="<%=sid%>" name="sid">

								<div class="form-group">
									<label for="Catagory" class="form-label">Catagory:</label> <select
										class="form-control" name="ca">
										<option value="<%=p.getCategory()%>"><%=p.getCategory()%></option>
										<option value="Animal">Animal</option>
										<option value="Bird">Bird</option>
										<option value="Others">Others</option>
									</select>
								</div>


								<div class="form-group">
									<label for="Pet name" class="form-label">Pet Name:</label> <input
										required type="text" class="form-control" id="txtpname"
										name="pa" value="<%=p.getPetName()%>">
								</div>

								<div class="form-group">
									<label for="last name" class="form-label">Description:</label>
									<textarea class="form-control" id="txtdesc" name="de" required
										rows="3"><%=p.getDescription()%></textarea>
								</div>

								<div class="form-group">
									<label for="cost" class="form-label">Price:</label> <input
										required type="number" class="form-control" id="txtcost"
										name="pr" value="<%=p.getPrice()%>">
								</div>

								<div class="form-group">
									<label for="disc" class="form-label">Stock </label> <input
										type="number" class="form-control" id="txtdisc" name="st"
										required value="<%=p.getStock()%>">
								</div>

								<div class="form-group">
									<label for="Catagory" class="form-label">Status:</label> <select
										class="form-control" name="sta">
										<option value="<%=p.getStatus()%>"><%=p.getStatus()%></option>
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									</select>
								</div>

								<button type="submit" class="btn btn-primary">Update</button>

							</div>
						</form>

					</div>
					<div class="col-md-4 offset-md-1 mt-5">
						<img alt="" src="../pet_img/<%=p.getImage()%>" width="400"
							height="450">
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