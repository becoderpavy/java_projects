
<%@page import="com.dao.StoreDAO"%>
<%@page import="com.entity.MedicineStore"%>
<%@page import="com.entity.Medicine"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.dao.CartDAO"%>
<%@page import="com.entity.User"%>

<%@page import="com.util.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
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
	<div class="container p-3">
		<div class="row">
			<p class="fs-3 text-center">Medicine Details</p>
			<c:if test="${not empty errorMsg}">
				<p class="fs-5 text-center text-danger">${errorMsg}</p>
				<c:remove var="errorMsg" scope="session" />
			</c:if>
			<c:if test="${not empty succMsg}">
				<div class="alert alert-success text-center" role="alert">${succMsg}</div>
				<c:remove var="succMsg" scope="session" />
			</c:if>
			<%
			StoreDAO dao = new StoreDAO(DBConnect.getConnection());

			Medicine p = dao.getPaintById(Integer.parseInt(request.getParameter("id")));
			MedicineStore art = dao.getArtist(p.getArt_id());
			%>
			<div class="col-md-12 paint-card p-5">
				<div class="row">
					<div class="col-md-6 text-end">
						<img alt="" src="paint_img/<%=p.getImageName()%>" width="330px" height="400px">
					</div>

					<div class="col-md-6">


						<p class="fs-3"><%=p.getName()%></p>
						<p>
							Description:<br><%=p.getDescription()%></p>
						<p>
							Shop Deatils:<br>Shop Name:
							<%=art.getShopName()%>
							<br>Address:
							<%=art.getAddress()%>,<%=art.getCity()%>,<%=art.getState()%>,<%=art.getPincode()%>

						</p>
						<p class="fs-5 fw-bold">
							Price :&nbsp; &nbsp; &nbsp; &nbsp;<i class="fas fa-rupee-sign"></i>
							<%=p.getPrice()%>
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
							CartDAO dao2 = new CartDAO(DBConnect.getConnection());
							if (dao2.checkCart(p.getId(), user.getId())) {
							%>
							<button disabled class="btn btn-danger col-md-12">Added
								To Cart</button>
							<%
							} else {
							%>
							<a href="onecart?pid=<%=p.getId()%>&&uid=${userObj.id}"
								class="btn btn-danger col-md-12">Add To Cart</a>
							<%
							}
							%>
						</c:if>


					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>