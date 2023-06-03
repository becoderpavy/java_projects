<%@page import="com.entity.Department"%>
<%@page import="com.dao.DepartmentDAO"%>
<%@page import="com.entity.Professor"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.ProfessorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin View Professor</title>
<%@include file="allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="col-md-12 p-3">
			<h4 class="text-center">All Professor list</h4>
			<c:if test="${not empty succMsg}">
				<h4 class="text-center text-success">${succMsg}</h4>
				<c:remove var="succMsg" />
			</c:if>

			<c:if test="${not empty errorMsg}">
				<h4 class="text-center text-danger">${errorMsg}</h4>
				<c:remove var="errorMsg" />
			</c:if>
			<table class="table">
				<thead class="bg-success text-white">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Department</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody class="bg-light">
					<%
					ProfessorDao dao = new ProfessorDao(DbConnect.getConn());
					DepartmentDAO dao2=new DepartmentDAO(DbConnect.getConn());
					List<Professor> list = dao.getAllProfessor();
					for (Professor p : list) {
					%>
					<tr>
						<th scope="row"><%=p.getName()%></th>
						<td><%=p.getEmail()%></td>

						<td>
							<%  List<Department> list2= dao2.getDepartment(p.getId());
								for(Department d:list2)
								{%>
								<p><%=d.getDeprtName() %></p>	
								<%}
							%>

						</td>

						<td><a
							href="deprt.jsp?id=<%=p.getId()%>&&nm=<%=p.getName()%>"
							class="btn btn-primary btn-sm">Add Department</a> <a
							href="edit_prof.jsp?id=<%=p.getId()%>"
							class="btn btn-sm btn-primary">Edit</a> <a
							href="../deleteprof?id=<%=p.getId()%>"
							class="btn btn-sm btn-primary">Delete</a></td>

					</tr>
					<%
					}
					%>


				</tbody>
			</table>
		</div>
	</div>
</body>
</html>