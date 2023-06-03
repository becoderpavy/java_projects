<%@page import="com.entity.Student"%>
<%@page import="com.admin.dao.StudentDAO"%>
<%@page import="com.entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher: Student-Details</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<c:if test="${empty tobj }">
		<c:redirect url="../tlogin.jsp" />
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
					<h3 class="text-center">Attendance</h3>
					<div class="card">
						<div class="card-body">
							<form class="form-inline" action="../tserch_student"
								method="post">
								<div class="form-group col-md-5 mt-1">
									<h5>Course</h5>
								</div>

								<div class="form-group col-md-4 mt-1">

									<h5>Semestar</h5>
								</div>


								<div class="form-group col-md-5">
									<select name="course" class="custom-select "
										id="inlineFormCustomSelectPref">
										<option selected>Choose...</option>
										<%
										CourseDAO dao = new CourseDAO(DBConnect.getConn());
										List<Course> course = dao.getCourse();
										for (Course c : course) {
										%>
										<option value="<%=c.getCourse()%>"><%=c.getCourse()%></option>
										<%
										}
										%>
									</select>
								</div>

								<div class="form-group col-md-5 mt-1">
									<select class="custom-select " id="inlineFormCustomSelectPref"
										name="semestar">
										<option selected>Semestar</option>
										<option value="1st Sem">1st Sem</option>
										<option value="2nd Sem">2nd Sem</option>
										<option value="3rd Sem">3rd Sem</option>
										<option value="4th Sem">4th Sem</option>
										<option value="5th Sem">5th Sem</option>
										<option value="6th Sem">6th Sem</option>
										<option value="7th Sem">7th Sem</option>
										<option value="8th Sem">8th Sem</option>
									</select>

								</div>
								<input type="hidden" name="viewtype" value="attend">
								<button class="btn btn-success">View</button>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>