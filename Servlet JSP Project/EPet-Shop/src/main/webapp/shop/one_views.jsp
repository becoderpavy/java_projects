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
<title>Shop: View One Pet</title>
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
				<%
				int pid = Integer.parseInt(request.getParameter("pid"));
				int sid = Integer.parseInt(request.getParameter("sid"));
				PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
				PetDtls p = dao.getPetsById(pid, sid);
				%>
				<div class="row">
					<div class="col-md-4 p-5">
						<img alt="" src="../pet_img/<%=p.getImage()%>" width="300"
							height="300">
					</div>
					<div class="col-md-6 offset-md-1">
						<h1 class="text-center">Details of Pet</h1>

						<form>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="Catagory" class="form-label">Catagory:</label> <input
										required type="text" class="form-control" id="txtcat"
										name="txtcat" readonly value="<%=p.getCategory()%>">

								</div>
								<div class="form-group col-md-6">
									<label for="Pet name" class="form-label">Pet Name:</label> <input
										readonly required type="text" class="form-control"
										id="txtpname" name="txtpname" value="<%=p.getPetName()%>">

								</div>
							</div>

							<div class="form-row ">
								<div class="form-group col-md-6">
									<label for="cost" class="form-label">Price:</label> <input
										readonly required type="number" class="form-control"
										id="txtcost" name="txtcost" value="<%=p.getPrice()%>">
								</div>

								<div class="form-group col-md-6">
									<label for="disc" class="form-label">Stock </label> <input
										readonly value="<%=p.getStock()%>" type="number"
										class="form-control" id="txtdisc" name="txtdisc">
								</div>
							</div>


							<div class="form-group">
								<label for="last name" class="form-label">Description:</label>
								<textarea class="form-control" id="txtdesc" name="txtdesc"
									readonly required rows="3"><%=p.getDescription()%></textarea>
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