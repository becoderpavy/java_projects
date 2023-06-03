<%@page import="com.entites.Vehicle"%>
<%@page import="java.util.List"%>
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
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<p class="text-center fs-3">All Vehicles</p>

			<%
			VehicleDao dao = new VehicleDao(DBConnect.getConnection());
			List<Vehicle> list = dao.getAllVehicle();

			for (Vehicle v : list) {
			%>

			<div class="col-md-3 mt-2">
				<div class="card paint-card">
					<div class="card-body">
						<img alt="" src="img/vehicle_img/<%=v.getImage()%>" width="100%"
							height="200px">
						<p class="text-center fs-5"><%=v.getTitle()%>
							<br> Status :
							<%=v.getAvailability()%>
						</p>
						<a href="view_vehicle.jsp?id=<%=v.getId()%>"
							class="btn btn-sm btn-primary col-md-12">view</a>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
</body>
</html>