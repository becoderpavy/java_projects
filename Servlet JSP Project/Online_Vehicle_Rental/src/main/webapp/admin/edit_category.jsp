
<%@page import="com.entites.Category"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.CategoryDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Category</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/navbar.jsp"%>

	<div class="conatiner text-center p-4">
		<i class="fas fa-layer-group fa-3x text-success"></i>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Edit Category</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						CategoryDao dao = new CategoryDao(DBConnect.getConnection());
						Category ca = dao.getCategoryById(id);
						%>

						<form action="../updateCategory" method="post"
							enctype="multipart/form-data">
							<div class="mb-3">
								<label class="form-label">Title</label> <input name="title"
									required type="text" class="form-control"
									value="<%=ca.getCategoryName()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Image</label> <input type="file"
									name="img" class="form-control"> <img class="mt-2"
									src="../img/category_img/<%=ca.getImage()%>" width="100px"
									height="100px"> <br> <small>uploaded img: <%=ca.getImage()%></small>
							</div>
							<input type="hidden" name="id" value="<%=ca.getId()%>">

							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>