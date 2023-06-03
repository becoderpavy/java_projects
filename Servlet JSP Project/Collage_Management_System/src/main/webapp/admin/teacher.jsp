<%@page import="com.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.TeacherDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Teacher-Details</title>
<%@include file="all_css.jsp"%>
</head>
<body>
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
					<h3 class="text-center text-success">Staff Details</h3>
					<div class="card">
						<div class="card-header">Staff Details</div>

						<div class="card-body">

							<table class="table table-bordered mt-2 table-striped">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Name</th>
										<th scope="col">Email</th>
										<th scope="col">DOB</th>
										<th scope="col">Gender</th>
										<th scope="col">Qualification</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<%
									TeacherDAO dao = new TeacherDAO(DBConnect.getConn());
									List<Teacher> teach = dao.getTeacher();
									for (Teacher t : teach) {
									%>
									<tr>
										<td><%=t.getName()%></td>
										<td><%=t.getEmail()%></td>
										<td><%=t.getDob()%></td>
										<td><%=t.getGender()%></td>
										<td><%=t.getQualification()%></td>
										<td class="text-center"><a href="edit_teacher.jsp?id=<%=t.getId()%>"
											class="btn btn-sm btn-success text-white"><i
												class="fas fa-edit"></i> Edit</a>
												
												<a
											href="../delete_teacher?id=<%=t.getId()%>"
											class="btn btn-sm btn-danger text-white"><i
												class="fas fa-trash-alt"></i> Delete</a></td>
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