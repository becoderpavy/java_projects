<%@page import="com.entity.Student"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Take Attendance</title>
<%@include file="all_css.jsp"%>

</head>
<body class="bg-card-color">
	<c:if test="${empty adobj }">
		<c:redirect url="../alogin.jsp" />
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
					<h3 class="text-center">Take Attendance</h3>
					<div class="card">
						<div class="card-body">
							<%
							StudentDAO dao = new StudentDAO(DBConnect.getConn());
							Student s = dao.getStudentById(Integer.parseInt(request.getParameter("id")));
							%>

							<form action="../attend" method="post">

								<input type="hidden" name="sid" value="<%=s.getId()%>">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label>Full Name</label> <input type="text" name="sname"
											class="form-control" value="<%=s.getName()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Course</label> <input type="text" name="course"
											class="form-control" value="<%=s.getCourse()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Semestar</label> <input type="text" name="sem"
											class="form-control" value="<%=s.getSemestar()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Year</label> <input type="number" name="year"
											class="form-control">
									</div>

									<div class="form-group col-md-4">
										<label>Month</label> <input type="text" name="month"
											class="form-control">
									</div>
									<div class="form-group col-md-4">
										<label>No of Days</label> <input type="number" name="days"
											class="form-control">
									</div>
								</div>
								<button class="btn btn-success">Submit</button>
							</form>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
</html>