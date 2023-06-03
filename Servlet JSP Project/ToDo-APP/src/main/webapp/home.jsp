<%@page import="com.entity.UserDetails"%>
<%@page import="com.entity.TodoDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
</head>
<body>
	<%
	UserDetails user1 = (UserDetails) session.getAttribute("userD");

	if (user1 == null) {
		response.sendRedirect("login.jsp");
		session.setAttribute("Login-error", "Please Login..");
	}
	%>


	<%@include file="component/navbar.jsp"%>

	<h1 class="text-center text-success">TODO-APP</h1>

	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	if (sucMsg != null) {
	%>
	<div class="alert alert-success text-center" role="alert"><%=sucMsg%></div>
	<%
	session.removeAttribute("sucMsg");
	}
	%>

	<%
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (failedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=failedMsg%></div>
	<%
	session.removeAttribute("failedMsg");
	}
	%>

	<div class="container">

		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					
					<th scope="col">Name</th>
					<th scope="col">Todo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (user1 != null) {
					TodoDAO dao = new TodoDAO(DBConnect.getConn());
					List<TodoDtls> todo = dao.getTodoByUserId(user1.getId());
					for (TodoDtls t : todo) {
				%>
				<tr>
					
					<th scope="col"><%=t.getName()%></th>
					<td><%=t.getTodo()%></td>
					<td><%=t.getStatus()%></td>

					<td><a href="edit.jsp?id=<%=t.getId()%>"
						class="btn btn-sm btn-success">Edit</a> <a
						href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				}
				%>




			</tbody>
		</table>

	</div>

</body>
</html>