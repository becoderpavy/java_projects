<%@page import="com.admin.dao.TeacherDAO"%>
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
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<c:if test="${empty adobj }">
		<c:redirect url="../alogin.jsp" />
	</c:if>

	<%@include file="navbar.jsp"%>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10 ">

				<i class="fas fa-bars m-3 fa-2x" onclick="toogleSidebar()"></i>
				<c:if test="${not empty succMsg}">
					<div class="alert alert-success" role="alert">${succMsg }</div>
					<c:remove var="succMsg" scope="session" />
				</c:if>

				<h3 class="text-center text-primary">Welcome Admin</h3>

				<hr>


				<div class="row p-4">
					<div class="col-md-6">
						<div class="card bg-success text-white">
							<div class="card-body text-center">
								<i class="fas fa-chalkboard-teacher fa-2x"></i>
								<h4>Teacher</h4>
								<%
								TeacherDAO dao = new TeacherDAO(DBConnect.getConn());
								int c = dao.teacherCount();
								%>
								<h5><%=c%></h5>

							</div>
						</div>
					</div>

					<div class="col-md-6 ">
						<div class="card bg-primary text-white">
							<div class="card-body text-center">
								<i class="fas fa-users fa-2x"></i>
								<h4>Student</h4>
								<%
								StudentDAO dao2 = new StudentDAO(DBConnect.getConn());
								int s = dao2.studentCount();
								%>
								<h5><%=s%></h5>
							</div>
						</div>
					</div>


				</div>
			</div>


		</div>
	</div>
</body>
</html>