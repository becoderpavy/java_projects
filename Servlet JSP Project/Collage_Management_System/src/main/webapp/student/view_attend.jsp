<%@page import="com.entity.Attendance"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.AttendanceDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<c:if test="${empty sobj }">
		<c:redirect url="../slogin.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<i class="fas fa-bars m-3 fa-2x" onclick="toogleSidebar()"></i>
				<div class="container-fluid">
					<c:if test="${not empty succMsg}">
						<div class="alert alert-success" role="alert">${succMsg }</div>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<h3 class="text-center">Attendance</h3>
					<div class="card">
						<div class="card-body">

							<table class="table table-bordered text-center">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Year</th>
										<th scope="col">Month</th>
										<th scope="col">No Of Days</th>

									</tr>
								</thead>
								<tbody>
									<%
									AttendanceDAO dao = new AttendanceDAO(DBConnect.getConn());
									List<Attendance> list = dao.getAttance(Integer.parseInt(request.getParameter("id")));
									for (Attendance a : list) {
									%>
									<tr>
										<td><%=a.getYear()%></td>
										<td><%=a.getMonth()%></td>
										<td><%=a.getDays()%></td>


									</tr>
									<%
									}
									%>


								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>