
<%@page import="com.entity.Medicine"%>
<%@page import="com.dao.StoreDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search page</title>
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid p-5" style="background-color: #f0f1f2;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="search.jsp" method="post">
					<div class="input-group">
						<input class="form-control" name="ch">
						<button class="btn bg-custom ms-2 text-white" type="button">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">

			<div class="col-md-12 p-0">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">
							Medicines</p>
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
							String ch = request.getParameter("ch");
							String sql = null;
							StoreDAO dao = new StoreDAO(DBConnect.getConnection());

							List<Medicine> list2 = dao.getPaintingForSearch(ch);
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