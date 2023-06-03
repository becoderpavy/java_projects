<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.PetDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>

</head>
<body>
	<c:if test="${empty adminObj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<h5 class="text-center">Add Category</h5>
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="category.jsp">
							<div class="form-group">
								<label>Category Name</label> <input type="text" name="cn"
									class="form-control">
							</div>
							<button class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<h5 class="text-center">Category Details</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Name</th>
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>
								<%
								PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
								List<Category> list = dao.getAllCategory();
								for (Category c : list) {
								%>
								<tr>
									<th scope="row"><%=c.getId()%></th>
									<td><%=c.getCategoryName()%></td>
									<td><a href="edit_category.jsp?id=<%=c.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a
										href="category.jsp?id=<%=c.getId()%>&&ty=delete"
										class="btn btn-sm btn-danger">Delete</a></td>

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

	<%
	String cn = request.getParameter("cn");
	String ty = request.getParameter("ty");

	if (cn != null) {

		boolean f = dao.addCategory(cn);
		if (f) {
			session.setAttribute("succMsg", "Category Add Successfully");
			response.sendRedirect("category.jsp");
		}
	}

	if ("delete".equals(ty)) {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean f = dao.deleteCategory(id);
		if (f) {
			session.setAttribute("succMsg", "Category Delete Successfully");
			response.sendRedirect("category.jsp");
		}
	}
	%>
</body>
</html>