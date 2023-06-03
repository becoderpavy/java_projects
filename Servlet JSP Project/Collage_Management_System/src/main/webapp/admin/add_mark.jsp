<%@page import="java.util.List"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.entity.Student"%>
<%@page import="com.admin.dao.SubjectDAO"%>
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
<title>Admin: Add Mark</title>

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

					<c:if test="${not empty failedMsg}">
						<div class="alert alert-danger" role="alert">${failedMsg }</div>
						<c:remove var="failedMsg" scope="session" />
					</c:if>
					<h3 class="text-center">Add Mark</h3>
					<div class="card">
						<%
						StudentDAO sdao = new StudentDAO(DBConnect.getConn());
						SubjectDAO sudao = new SubjectDAO(DBConnect.getConn());
						int sid = Integer.parseInt(request.getParameter("id"));
						Student s = sdao.getStudentById(Integer.parseInt(request.getParameter("id")));
						List<Subject> sub = sudao.getSubject(s.getCourse(), s.getSemestar());
						%>


						<div class="card-body">
							<form action="../add_mark" method="post">

								<input type="hidden" value="<%=sid%>" name="sid">

								<div class="form-row">
									<div class="form-group col-md-3">
										<label>ROll</label> <input type="text" class="form-control"
											readonly value="<%=s.getRoll()%>" name="roll">
									</div>
									<div class="form-group col-md-3">
										<label>Name</label> <input type="text" class="form-control"
											readonly value="<%=s.getName()%>" name="sname">
									</div>


									<div class="form-group col-md-3">
										<label>Course</label> <input type="text" class="form-control"
											readonly value="<%=s.getCourse()%>" name="course">
									</div>

									<div class="form-group col-md-3">
										<label>Semestar</label> <input type="text"
											class="form-control" readonly value="<%=s.getSemestar()%>"
											name="sem">
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-5">
										<label>Subject</label> <select name="subject"
											class="custom-select " id="inlineFormCustomSelectPref">
											<option selected>Choose...</option>
											<%
											for (Subject su : sub) {
											%>
											<option value="<%=su.getSubject()%>"><%=su.getSubject()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="form-group col-md-5">
										<label>Mark</label> <input type="number" class="form-control"
											name="mark">
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