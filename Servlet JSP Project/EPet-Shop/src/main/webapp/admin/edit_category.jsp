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
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
						Category ca = dao.getCategoryById(id);
						%>
						<h5 class="text-center">Edit Category</h5>
						<form action="edit_category.jsp">
							<div class="form-group">
								<label>Category Name</label> <input type="text" name="cn"
									value="<%=ca.getCategoryName()%>" class="form-control">
								<input type="hidden" name="id" value="<%=ca.getId()%>">
							</div>
							<button class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>


		</div>
	</div>

	<%
	String cn = request.getParameter("cn");

	if (cn != null) {
		int idx = Integer.parseInt(request.getParameter("id"));
		boolean f = dao.updateCategory(cn, idx);
		if (f) {
			session.setAttribute("succMsg", "Category update Successfully");
			response.sendRedirect("category.jsp");
		}
	}
	%>
</body>
</html>