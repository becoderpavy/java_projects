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
					<%
					String cou = request.getParameter("co");
					String sem = request.getParameter("sem");
					String type = request.getParameter("type");
					String name = "";
					if ("attend".equals(type))
						name = "Attendance";
					else if ("view".equals(type))
						name = "Student Details";
					else if ("res".equals(type))
						name = "Result";
					%>

					<c:if test="${not empty succMsg}">
						<div class="alert alert-success" role="alert">${succMsg }</div>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<h3 class="text-center"><%=cou%>,<%=sem%>
						<%=name%>
					</h3>
				</div>

				<div class="card">
					<div class="card-body">

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

									<%
									if (type.equals("attend")) {
									%>
									<td class="text-center"><a
										href="view_attend.jsp?id=<%=s.getId()%>"
										class="btn btn-sm btn-warning text-white"><i
											class="far fa-eye"></i> View</a> <a
										href="take_atten.jsp?id=<%=s.getId()%>"
										class="btn btn-sm btn-success text-white"><i
											class="fas fa-address-book"></i> Attend</a></td>
									<%
									} else if (type.equals("view")) {
									%>
									<td class="text-center"><a
										href="edit_student.jsp?id=<%=s.getId()%>"
										class="btn btn-sm btn-success text-white"><i
											class="fas fa-edit"></i> Edit</a> <a
										href="../delete_student?id=<%=s.getId()%>&&co=<%=s.getCourse()%>&&sem=<%=s.getSemestar()%>"
										class="btn btn-sm btn-danger text-white"><i
											class="fas fa-trash-alt"></i> Delete</a></td>
									<%
									} else if (type.equals("res")) {
									%>
									<td><a href="add_mark.jsp?id=<%=s.getId()%>"
										class="btn btn-sm btn-success"><i
											class="fas fa-plus-square"></i> Add Mark</a> <a
										href="view_result.jsp?sid=<%=s.getId()%>&&sem=<%=s.getSemestar()%>"
										class="btn btn-sm btn-success"><i class="fas fa-eye"></i>
											View</a></td>
									<%
									}
									%>
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
		</div>
	</div>
</body>
</html>