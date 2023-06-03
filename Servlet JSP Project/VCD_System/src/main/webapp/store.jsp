
<%@page import="com.entites.Store"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.StoreDAO"%>
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
<title>All Paintings</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 3px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container-fluid p-5" style="background-color: #f0f1f2;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="store_search.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch">
						<button class="btn bg-custom ms-2 text-white">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12 p-0">
				<p class="fs-3 text-center">All Store</p>
				<c:if test="${not empty errorMsg}">
					<p class="fs-5 text-center text-danger">${errorMsg}</p>
					<c:remove var="errorMsg" scope="session" />
				</c:if>
				<c:if test="${not empty succMsg}">
					<div class="alert alert-success text-center" role="alert">${succMsg}</div>
					<c:remove var="succMsg" scope="session" />
				</c:if>
				<div class="row">

					<%
					StoreDAO dao = new StoreDAO(DBConnect.getConn());
					List<Store> list = dao.getAllStores();
					for (Store s : list) {
					%>
					<div class="col-md-3">
						<a href="store_movies.jsp?id=<%=s.getId()%>"
							class="text-decoration-none text-dark">
							<div class="card paint-card mt-2">
								<div class="card-body text-center">
									<img alt="" src="store_img/<%=s.getStoreImg()%>" height="170px"
										width="100%">
									<p class="fs-5">
										<%=s.getStoreName()%><br>
									</p>
								</div>
							</div>
						</a>
					</div>
					<%
					}
					%>
				</div>

			</div>
		</div>
	</div>


	<div style="margin-top: 130px">
		<%@include file="component/footer.jsp"%>
	</div>



</body>
</html>