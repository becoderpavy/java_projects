<%@page import="com.db.DBConnect"%>
<%@page import="com.entites.Vehicle"%>
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

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>


</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-3">
		<div class="row">
			<p class="fs-3 text-center">Booking Details</p>

			<%
			int id = Integer.parseInt(request.getParameter("id"));
			VehicleDao dao = new VehicleDao(DBConnect.getConnection());

			Vehicle v = dao.getVehicleById(id);
			%>

			<div class="col-md-12 paint-card p-5">
				<div class="row">
					<div class="col-md-6 text-center">
						<img alt="" src="img/vehicle_img/<%=v.getImage()%>" width="330px"
							height="400px">

						<p class="text-center fs-4"><%=v.getTitle()%></p>
					</div>

					<div class="col-md-6 p-5">


						<form action="calculate.jsp" method="post">
							<div class="mb-3">
								<label>From Date</label> <input id="fromdate" type="text"
									class="form-control datepicker" name="fromDate">
							</div>

							<div class="mb-3">
								<label>To Date</label> <input id="todate" type="text"
									class="form-control datepicker" name="toDate">
							</div>
							<div class="mb-3">
								<label>Per Day</label> <input type="text" class="form-control"
									readonly name="fromDate" value="<%=v.getPerDay()%>">
							</div>
							<input type="hidden" name="id" value="<%=v.getId()%>">

							<button class=" btn btn-sm btn-danger col-md-12">Calculate</button>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		$('.datepicker').datepicker({
			startDate : new Date(),
			format : 'yyyy-mm-dd'
		});
	</script>


</body>
</html>