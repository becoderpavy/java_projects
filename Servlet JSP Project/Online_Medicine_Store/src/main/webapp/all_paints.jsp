
<%@page import="com.entity.Medicine"%>
<%@page import="com.dao.StoreDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.CartDAO"%>

<%@page import="com.util.DBConnect"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Paintings</title>
<%@include file="component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 3px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body style="background: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid p-5" style="background-color: #f0f1f2;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="search.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch">
						<button class="btn bg-custom ms-2 text-white">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">

			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Categories</p>
						<div class="list-group" style="width: 100%;">
							<%-- <%
							if ("all".equals(request.getParameter("cat"))) {
							%>
							<a type="button" class="active list-group-item list-group-item-action"
								aria-current="true">All</a>
							<%
							}
							%> --%>
							<a href="?cat=all" type="button"
								class="active list-group-item list-group-item-action"
								aria-current="true">All</a>
							<%
							StoreDAO dao = new StoreDAO(DBConnect.getConnection());
							List<Category> list = dao.getCategory();
							for (Category c : list) {
							%>
							<a href="?cat=<%=c.getCategoryName()%>" type="button"
								class="list-group-item list-group-item-action"
								aria-current="true"><%=c.getCategoryName()%></a>
							<%
							}
							%>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-9 p-0">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Medicine</p>
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
							String cat = request.getParameter("cat");
							String sql = null;
							if ("all".equals(cat)) {
								sql = "select * from medicine order by id desc";
							} else {
								sql = "select * from medicine where category='" + cat + "' order by id desc";
							}

							List<Medicine> list2 = dao.getPaintByCategory(sql);
							for (Medicine p : list2) {
							%>
							<div class="col-md-3">
								<a href="one_art.jsp?id=<%=p.getId()%>"
									class="text-decoration-none text-dark">
									<div class="card paint-card mt-2">
										<div class="card-body text-center">
											<img alt="" src="paint_img/<%=p.getImageName()%>"
												height="170px" width="100%">
											<p class="fs-5">
												<%=p.getName()%><br> <span class="fs-6">Category:
													<%=p.getCategory()%></span>
											</p>
											<h5>
												<i class="fas fa-rupee-sign"></i>
												<%=p.getPrice()%>
											</h5>
											<c:if test="${empty userObj }">
												<a href="login.jsp" class="btn btn-danger col-md-12">Add
													To Cart</a>
											</c:if>
											<c:if test="${not empty userObj }">

												<%
												User user = (User) session.getAttribute("userObj");
												CartDAO dao2 = new CartDAO(DBConnect.getConnection());
												if (dao2.checkCart(p.getId(), user.getId())) {
												%>
												<button disabled class="btn btn-danger col-md-12">Added
													To Cart</button>
												<%
												} else {
												%>
												<a href="cart?pid=<%=p.getId()%>&&uid=${userObj.id}"
													class="btn btn-danger col-md-12">Add To Cart</a>
												<%
												}
												%>


											</c:if>

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
		</div>
	</div>






</body>
</html>