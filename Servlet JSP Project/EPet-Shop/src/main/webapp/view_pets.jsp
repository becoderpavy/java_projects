<%@page import="com.entity.UserDtls"%>
<%@page import="com.entity.ShopDtls"%>
<%@page import="com.DAO.ShopDAOImpl"%>
<%@page import="com.entity.PetDtls"%>
<%@page import="com.DAO.PetDAOImpl"%>
<%@page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<%
	UserDtls u = (UserDtls) session.getAttribute("userobj");
	%>
	<%
	int pid = Integer.parseInt(request.getParameter("pid"));
	PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
	PetDtls p = dao.getPetsByIdUSer(pid);
	%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
				<img src="pet_img/<%=p.getImage()%>"
					style="height: 200px; width: 200px"><br>
			</div>

			<div class="col-md-6 p-5 border bg-white">
				<h2><%=p.getPetName()%></h2>
				<h6>
					Category :
					<%=p.getCategory()%></h6>
				<h6>
					Description :
					<%=p.getDescription()%></h6>
				<hr>
				<%
				ShopDAOImpl d = new ShopDAOImpl(DBConnect.getConn());
				ShopDtls s = d.getShopById(p.getShopid());
				%>
				<h6>Shop Details :</h6>
				<h6>
					Shop Name :
					<%=s.getShopName()%>
					<br> Address :
					<%=s.getAddress()%>,<%=s.getCity()%>,<%=s.getState()%>
				</h6>

				<div class="row">
					<div class="col-md-6 text-danger text-center p-2">
						<i class="fas fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<!-- <div class="col-md-4 text-danger text-center p-2">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>Return Available</p>
					</div> -->
					<div class="col-md-6 text-danger text-center p-2">
						<i class="fas fa-truck-moving fa-2x"></i>
						<p>Free Shipping</p>
					</div>


				</div>

				<div class=" text-center p-3">
					<%
					if (u == null) {
					%>
					<a href="login.jsp" class="btn btn-primary btn-sm ml-2"><i
						class="fas fa-cart-plus"></i> Add Cart</a>
					<%
					} else {
					if (p.getStock() <= 0) {
					%>
					<a href="#" class="btn btn-warning text-white btn-sm ml-2"><i
						class="fas fa-cart-plus"></i> Out Of Stock</a>
					<%
					} else {
					%>
					<a
						href="cart?pid=<%=p.getId()%>&&uid=<%=u.getId()%>&&sid=<%=s.getId()%>&&ca=<%=p.getCategory()%>"
						class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i>
						Add Cart</a>
					<%
					}
					}
					%>


					<a href="" class="btn btn-danger btn-sm"><i
						class="fas fa-rupee-sign"></i><%=p.getPrice() %></a>
				</div>



			</div>
		</div>
	</div>

	<%-- <div class="container">

		<div class="card paint-card">
			<div class="card-body">
				<h5 class="text-center ">Similar Product</h5>
				<div class="row p-3">

					<%
					List<PetDtls> listy = dao.getAllPetsByCategory(p.getCategory());
					for (PetDtls psx : listy) {
						ShopDtls ssx = d.getShopById(psx.getShopid());
					%>
					<div class="col-md-3">
						<div class="card crd-ho mt-2 paint-card">
							<div class="card-body text-center">
								<img alt="" src="pet_img/<%=p.getImage()%>"
									style="width: 150px; height: 150px" class="img-thumblin">
								<p><%=psx.getPetName()%></p>
								<p>
									Categories:
									<%=psx.getCategory()%></p>
								<div class="row">

									<a href="view_pets.jsp?pid=<%=p.getId()%>"
										class="btn btn-success btn-sm ml-5">View Details</a> <a
										href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%>
										<i class="fas fa-rupee-sign"></i></a>
								</div>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div> --%>
</body>
</html>