
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.entity.Artist"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.ArtistDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist Home Page</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.clink {
	text-decoration: none;
}
</style>
</head>
<body>
	<c:if test="${empty artObj }">
		<c:redirect url="../alogin.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<p class="text-center fs-3">Artist Panel</p>
			<%
			Artist art = (Artist) session.getAttribute("artObj");
			ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
			int cat = dao.countCategories();
			int paintings = dao.countPaintings(art.getId());
			int order = dao.countOrder(art.getId());
			%>
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<p class="fs-5">Category</p>
					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=cat%></p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<p class="fs-5">Paintings</p>
					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=paintings%></p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<p class="fs-5">Orders</p>
					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=order%></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>