
<%@page import="com.dao.CartDAO"%>

<%@page import="com.entites.Store"%>
<%@page import="com.dao.StoreDAO"%>
<%@page import="com.entites.Movies"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.MoviesDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
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
	<%@include file="component/navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<p class="fs-3 text-center">VCD Details</p>
			<c:if test="${not empty errorMsg}">
				<p class="fs-5 text-center text-danger">${errorMsg}</p>
				<c:remove var="errorMsg" scope="session" />
			</c:if>
			<c:if test="${not empty succMsg}">
				<div class="alert alert-success text-center" role="alert">${succMsg}</div>
				<c:remove var="succMsg" scope="session" />
			</c:if>

			<%
			int id = Integer.parseInt(request.getParameter("id"));
			MoviesDAO dao = new MoviesDAO(DBConnect.getConn());
			StoreDAO dao2 = new StoreDAO(DBConnect.getConn());
			Movies m = dao.getMoviesById(id);
			Store s = dao2.getStoreById(m.getStoreId());
			%>

			<div class="col-md-12 paint-card p-4">
				<div class="row">
					<div class="col-md-6 text-end">
						<img alt="" src="movies_img/<%=m.getImg()%>" width="330px"
							height="400px">
					</div>

					<div class="col-md-6">


						<p class="fs-3"><%=m.getMoviesName()%></p>

						<p>
							<span class="fw-bold">Language : </span>
							<%=m.getLanguage()%><br> <span class="fw-bold">Category
								: </span><%=m.getCategory()%><br> <span class="fw-bold">
								Ratings :</span>
							<%=m.getRatings()%><br>

						</p>



						<p>
							<span class="fw-bold ">Description :</span><br><%=m.getDescription()%>

						</p>

						<p>
							<span class="fw-bold fs-5">Store Details </span><br> <span>Store
								Name :</span><%=s.getStoreName()%><br> <span>Mob No :</span><%=s.getMobNo()%><br>
							<span>Address :</span><%=s.getAddress()%><br>
						</p>


						<p class="fs-5 ">
							<span class="fw-bold">Price :</span>&nbsp; &nbsp; &nbsp; &nbsp;<i
								class="fas fa-rupee-sign"></i>
							<%=m.getCost()%>
						</p>

						<div class="row">
							<div class="col-md-4 text-danger text-center p-2">
								<i class="fas fa-money-bill-wave fa-2x"></i>
								<p>Cash On Delivery</p>
							</div>
							<div class="col-md-4 text-danger text-center p-2">
								<i class="fas fa-undo-alt fa-2x"></i>
								<p>Return Available</p>
							</div>
							<div class="col-md-4 text-danger text-center p-2">
								<i class="fas fa-truck-moving fa-2x"></i>
								<p>Free Shipping</p>
							</div>


						</div>


						<c:if test="${empty userObj }">
							<a href="login.jsp" class="btn btn-danger col-md-12">Add To
								Cart</a>
						</c:if>
						<c:if test="${not empty userObj }">

							<%
							User user = (User) session.getAttribute("userObj");
							CartDAO dao3 = new CartDAO(DBConnect.getConn());
							if (dao3.checkCart(m.getId(), user.getId())) {
							%>
							<button disabled class="btn btn-danger col-md-12">Added
								To Cart</button>
							<%
							} else {
							%>
							<a href="cart?mid=<%=m.getId()%>&&uid=${userObj.id}&&pg=vm"
								class="btn btn-danger btn-sm col-md-12">Add To Cart</a>
							<%
							}
							%>


						</c:if>


					</div>
				</div>
			</div>

		</div>
	</div>

	<div style="margin-top: 30px">
		<%@include file="component/footer.jsp"%>
	</div>
</body>
</html>