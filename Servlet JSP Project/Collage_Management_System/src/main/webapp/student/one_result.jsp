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
<title>Student: Result</title>
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
					<c:if test="${not empty dmsg}">
						<div class="alert alert-success" role="alert">${dmsg }</div>
						<c:remove var="dmsg" scope="session" />
					</c:if>
					<h3 class="text-center">Result</h3>

					<%
					int id = Integer.parseInt(request.getParameter("id"));
					String sem = request.getParameter("semestar");
					StudentDAO dao = new StudentDAO(DBConnect.getConn());
					Student s = dao.getStubySem(id, sem);
					%>

					<div class="card">
						<div class="card-body">
							<table class="table table-bordered">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Name</th>
										<th scope="col">Course</th>
										<th scope="col">Semestar</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<%
									if (s != null) {
									%>
									<tr>
										<td><%=s.getName()%></td>
										<td><%=s.getCourse()%></td>
										<td><%=s.getSemestar()%></td>
										<td><a
											href="view_result.jsp?sid=<%=s.getId()%>&&sem=<%=s.getSemestar()%>"
											class="btn btn-sm btn-success"><i class="fas fa-eye"></i>
												View</a> <a
											href="../download_pdf?sid=<%=s.getId()%>&&sem=<%=s.getSemestar()%>"
											class="btn btn-sm btn-danger"><i class="fas fa-download"></i>
												Download</a></td>
									</tr>
									<%
									} else {
									%>
									<h5>Marksheet Not Available</h5>
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