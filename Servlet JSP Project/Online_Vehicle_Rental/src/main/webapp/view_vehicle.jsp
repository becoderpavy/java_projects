<%@page import="com.entites.Category"%>
<%@page import="com.dao.CategoryDao"%>
<%@page import="com.entites.Vehicle"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<p class="fs-3 text-center">Vehicle Details</p>

			<%
			int id = Integer.parseInt(request.getParameter("id"));
			VehicleDao dao = new VehicleDao(DBConnect.getConnection());
			CategoryDao dao2 = new CategoryDao(DBConnect.getConnection());

			Vehicle v = dao.getVehicleById(id);
			Category c = dao2.getCategoryById(v.getCategoryId());
			%>

			<div class="col-md-12 paint-card p-5">
				<div class="row">
					<div class="col-md-6 text-end">
						<img alt="" src="img/vehicle_img/<%=v.getImage()%>" width="330px"
							height="400px">
					</div>

					<div class="col-md-6">


						<p class="fs-3"><%=v.getTitle()%></p>
						<p>
							<span class="fw-bold">Description : </span><br><%=v.getDescription()%>
						</p>
						<p>
							<span class="fw-bold"> Vehcile Deatils: </span> <br>
							Vechicle Number :
							<%=v.getVehicleNumber()%>
							<br> Category :
							<%=c.getCategoryName()%>
							<br> Availability :
							<%=v.getAvailability()%>
							<br> Insurance Status :
							<%=v.getInsuranceStatus()%>
							<br> Owner Name :
							<%=v.getOwnerName()%>
							<br> Contact No :
							<%=v.getContactNo()%>
							<br>



						</p>
						<p class="fs-5 fw-bold">
							Price In Day :&nbsp; &nbsp; &nbsp; &nbsp;<i
								class="fas fa-rupee-sign"></i>
							<%=v.getPerDay()%>
						</p>

						<div class="row">
							<div class="col-md-4 text-danger text-center p-2">
								<i class="fas fa-truck-moving fa-2x"></i>
								<p>24 * 7 Service</p>
							</div>
							<div class="col-md-4 text-danger text-center p-2">
								<i class="fas fa-undo-alt fa-2x"></i>
								<p>Customer Satisfication</p>
							</div>
							<div class="col-md-4 text-danger text-center p-2">

								<i class="fa-solid fa-square-phone fa-2x"></i>
								<p>Poblem Solve</p>
							</div>


						</div>

						<c:if test="${empty userObj }">
							<a href="login.jsp" class="btn btn-danger col-md-12"> Book</a>
						</c:if>

						<c:if test="${not empty userObj }">
							<%
							if ("Booked".equals(v.getAvailability())) {
							%>
							<a href="book.jsp?id=<%=v.getId()%>"
								class="btn btn-danger col-md-12 disabled"> Not Available</a>
							<%
							} else {
							%>
							<a href="book.jsp?id=<%=v.getId()%>"
								class="btn btn-danger col-md-12"> Book</a>
							<%
							}
							%>


						</c:if>



					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>