<%@page import="com.entites.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<p class="text-center fs-3">All Categories</p>

			<%
			CategoryDao dao = new CategoryDao(DBConnect.getConnection());
			List<Category> list = dao.getCategory();
			for (Category ca : list) {
			%>
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<img alt="" src="img/category_img/<%=ca.getImage()%>" width="100%"
							height="200px">
						<p class="text-center fs-5"><%=ca.getCategoryName()%></p>
						<a
							href="category_vehicle.jsp?id=<%=ca.getId()%>&&nm=<%=ca.getCategoryName()%>"
							class="btn btn-sm btn-primary col-md-12">view</a>
					</div>
				</div>
			</div>
			<%
			}
			%>


		</div>
	</div>
</body>
</html>