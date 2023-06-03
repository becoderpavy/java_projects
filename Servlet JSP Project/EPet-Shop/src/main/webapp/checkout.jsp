<%@page import="com.entity.CartDtls"%>
<%@page import="com.entity.UserDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%@page import="com.entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	<c:if test="${not empty succMsg}">
		<h4 class="alert alert-success text-center" role="alert">${succMsg }</h4>
		<c:remove var="succMsg" scope="session" />

	</c:if>

	<c:if test="${not empty failedMsg}">
		<h4 class="alert alert-danger text-center" role="alert">${failedMsg }</h4>
		<c:remove var="failedMsg" scope="session" />

	</c:if>


	<div class="container-fluid p-5">
		<div class="row p-2">
			<div class="col-md-6">

				<div class="card bg-white p-3">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table ">
							<thead>
								<tr>
									<th scope="col">Pet Name</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								UserDtls u = (UserDtls) session.getAttribute("userobj");
								CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
								List<CartDtls> list = dao.getCartPetsByUser(u.getId());
								Double totalPrice = 0.00;
								for (CartDtls c : list) {
									totalPrice = c.getTotalPrice();
								%>
								<tr>
									<th scope="row"><%=c.getPetsName()%></th>
									<td><%=c.getPrice()%></td>
									<td><a
										href="remove_pet?id=<%=c.getId()%>&&uid=<%=c.getUserId()%>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>
								<%
								}
								%>



								<tr>
									<td>Total Price</td>
									<td></td>
									<td><%=totalPrice%></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
							<input type="hidden" value="${userobj.id}" name="id">

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										name="username" class="form-control" id="inputEmail4"
										value="${userobj.name}" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										name="email" class="form-control" id="inputPassword4"
										value="${userobj.email }" required readonly="readonly">
								</div>
							</div>


							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										name="phno" type="number" class="form-control"
										id="inputEmail4" value="${userobj.phno }" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Adress</label> <input type="text"
										name="address" class="form-control" id="inputPassword4"
										required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										name="landmark" class="form-control" id="inputEmail4" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text"
										name="city" class="form-control" id="inputPassword4" required>
								</div>
							</div>


							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										name="state" class="form-control" id="inputEmail4" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin code</label> <input
										type="number" name="pincode" class="form-control"
										id="inputPassword4" required>
								</div>
							</div>

							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control"
									name="payment">
									<option value="noselect">--Select--</option>
									<option value="COD">Cash On Dlivery</option>
									<option value="ONLINE">Online Payment</option>
								</select>
							</div>

							<input type="hidden" name="totalPrice" value="<%=totalPrice%>">

							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>

						</form>
					</div>

				</div>

			</div>


		</div>
	</div>
</body>
</html>