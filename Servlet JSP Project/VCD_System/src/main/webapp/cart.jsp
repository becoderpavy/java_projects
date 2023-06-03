
<%@page import="com.entites.Movies"%>
<%@page import="com.dao.MoviesDAO"%>
<%@page import="com.entites.Cart"%>
<%@page import="java.util.List"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Cart Page</title>

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
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>
	<p class="fs-3 fw-bold text-center text-success mt-4">
		VCD Cart Page <i class="fas fa-cart-plus"></i>
	</p>
	<c:if test="${not empty succMsg}">
		<div class="alert alert-success text-center" role="alert">${succMsg}</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<div class="container p-2">

		<div class="row">

			<div class="col-md-8">
				<table class="table table-bordered">
					<thead class="text-center bg-dark text-white">
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Total Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<%
						User user = (User) session.getAttribute("userObj");
						CartDAO dao = new CartDAO(DBConnect.getConn());
						MoviesDAO dao2 = new MoviesDAO(DBConnect.getConn());

						List<Cart> list = dao.getCart(user.getId());
						int totalBillingPrice = 0;
						for (Cart c : list) {
							Movies m = dao2.getMoviesById(c.getMid());
						%>

						<tr>
							<th scope="row"><img src="movies_img/<%=m.getImg()%>"
								width="50px" height="50px"></th>
							<td><%=m.getMoviesName()%></td>
							<td><%=m.getCost()%></td>
							<td><%=c.getQuantity()%></td>
							<td>
								<%
								int totalprice = Integer.parseInt(m.getCost()) * c.getQuantity();
								totalBillingPrice = totalBillingPrice + totalprice;
								%> <%=totalprice%>
							</td>


							<td class="text-center"><a
								href="cartin?qu=<%=c.getQuantity()%>&&cid=<%=c.getId()%>&&si=plus"
								class="text-success"><i class="fas fa-2x  fa-plus-circle"></i></a>

								<a
								href="cartin?qu=<%=c.getQuantity()%>&&cid=<%=c.getId()%>&&si=neg"
								class="text-danger"><i class="fas fa-2x fa-minus-circle"></i></a></td>
						</tr>
						<%
						}
						%>



					</tbody>
				</table>

			</div>

			<div class="col-md-4">
				<div class="col-md-12">
					<div class="card paint-card">
						<div class="card-body">
							<p class="fs-6 text-Secondary text-center">Delivery Address</p>

							<p style="color: black;">
								${userObj.fullName } <br>${userObj.address} <br>${userObj.city }
								,${userObj.state } ${userObj.pin } <br>Mobile No:
								${userObj.mobNo }

							</p>
							<a class="fs-5 text-decoration-none" href="edit_profile.jsp">Change
								Address</a>
						</div>
					</div>
				</div>

				<div class="col-md-12 mt-2">
					<div class="card paint-card">
						<div class="card-body">
							<div class="card-body">
								<p class="fs-6 text-Secondary text-center">Payment</p>
								<p class="fw-bold" style="color: black;">
									Amount: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<i
										class="fas fa-rupee-sign"></i>
									<%=totalBillingPrice%><br> Shipping Charge:&nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<i
										class="fas fa-rupee-sign"></i> 60 <br> Tax :&nbsp; &nbsp;
									&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
									&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
									&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<i
										class="fas fa-rupee-sign"></i> 30
								</p>
								<hr>
								<p class="fw-bold">
									Total Amount:&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
									&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
									&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; <i
										class="fas fa-rupee-sign"></i>
									<%=totalBillingPrice + 60 + 30%><br>

									<!-- Payment Type:&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
								&nbsp;&nbsp; &nbsp;&nbsp; Cash On Delivary -->


								</p>




								<form class="row g-3" action="orders" method="post">
									<div class="form-group">
										<label class="form-label">Payment Mode</label> <select
											name="type" class="form-control form-control-sm">
											<option>--select--</option>
											<option value="Debit card">Debit Card</option>
											<option value="COD">Cash On Delivary</option>
										</select>
									</div>
									<input type="hidden" name="amt"
										value="<%=totalBillingPrice + 60 + 30%>"> <input
										type="hidden" value="${userObj.id}" name="uid">

									<%
									if (list.isEmpty()) {
									%>
									<button class="btn btn-custom col-md-12 text-white" disabled>Place
										Order</button>
									<%
									} else {
									%>
									<button class="btn btn-custom col-md-12 text-white">Place
										Order</button>
									<%
									}
									%>

								</form>


							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>