<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
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
<title>Admin: Student Attendance</title>
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
					<%
					String cou = request.getParameter("co");
					String sem = request.getParameter("sem");
					%>


					<h3 class="text-center"><%=cou%>,<%=sem%>
						Attendance
					</h3>
				</div>


				<table class="table table-bordered mt-2 bg-light">
					<thead class="bg-primary text-white">
						<tr>
							<th scope="col">Roll</th>
							<th scope="col">Name</th>
							<th scope="col">Course</th>
							<th scope="col">Semestar</th>
							<th scope="col">DOB</th>
							<th scope="col">Gender</th>
							<th scope="col">Adress</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						StudentDAO da = new StudentDAO(DBConnect.getConn());
						List<Student> list = da.getData(cou, sem);

						if (list != null) {
							for (Student s : list) {
						%>
						<tr>
							<td><%=s.getRoll()%></td>
							<td><%=s.getName()%></td>
							<td><%=s.getCourse()%></td>
							<td><%=s.getSemestar()%></td>
							<td><%=s.getDob()%></td>
							<td><%=s.getGender()%></td>
							<td><%=s.getAddress()%></td>
							<td><%=s.getEmail()%></td>
							<td class="text-center"><a
								href="edit_student.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-success text-white"><i
									class="fas fa-edit"></i> Edit</a> <a
								href="../delete_student?id=<%=s.getId()%>"
								class="btn btn-sm btn-danger text-white"><i
									class="fas fa-trash-alt"></i> Delete</a></td>
						</tr>
						<%
						}
						}
						%>
					</tbody>
				</table>


			</div>
		</div>
	</div>
</body>
</html>