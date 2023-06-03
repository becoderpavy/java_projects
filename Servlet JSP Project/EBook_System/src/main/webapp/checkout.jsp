<%@page import="com.entity.bookDtls"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.entity.cart"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%
userDtls user4 = (userDtls) session.getAttribute("LoginUser");
if (user4 == null) {
	session.setAttribute("errorMsg", "Your Not Log in..Please login");
	response.sendRedirect("login.jsp");
}
%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook: Checkout</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
	String removeMsg = (String) session.getAttribute("removeMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");

	if (removeMsg != null) {
	%>
	<div class="alert alert-success text-center font-weight-bold"
		role="alert"><%=removeMsg%></div>
	<%
	session.removeAttribute("removeMsg");
	}
	if (errorMsg != null) {
	%>
	<div class="alert alert-danger text-center font-weight-bold"
		role="alert"><%=errorMsg%></div>
	<%
	session.removeAttribute("errorMsg");
	}
	%>


	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6">
				<!-- card -->
				<div class="card">
					<h3 class="text-center text-success mb-2">Your Selected Item</h3>
					<div class="card-body">

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								int totalprice = 0;
								if (user4 != null) {
									int uid = user4.getId();
									CartDAOImpl dao4 = new CartDAOImpl(ConnectionProvider.getConnection());
									List<cart> crt2 = dao4.getCartDetails(uid);

									for (cart c : crt2) {
										totalprice += c.getPrice();
								%>
								<tr>
									<th scope="row"><%=c.getBookName()%></th>
									<td><%=c.getAuthor()%></td>
									<td><%=c.getPrice()%></td>
									<td><a
										href="removeCartServlet?bid=<%=c.getBid()%>&&uid=<%=c.getUid()%> "
										class="btn btn-danger btn-sm text-white">Remove</a></td>
								</tr>
								<%
								}

								}
								%>
								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><%=totalprice%></td>
								</tr>
							</tbody>
						</table>

					</div>

				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<h3 class="text-center text-success mb-2">Your Details for
						Order</h3>
					<div class="card-body">
						<%
						if (user != null) {
						%>
						<form action="orderSucessServlet?uid=<%=user.getId()%>"
							method="post">

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputAddress">Name</label> <input type="text"
										class="form-control" id="inputAddress" name="name"
										value="<%=user4.getName()%>" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label for="inputAddress2">Email</label> <input type="text"
										class="form-control" id="inputAddress2" name="email"
										value="<%=user4.getEmail()%>" readonly="readonly">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputAddress2">Mobile No</label> <input type="text"
										class="form-control" id="inputAddress2" name="phone"
										value="<%=user4.getPhno()%>" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label for="inputAddress">Address</label> <input type="text"
										class="form-control" id="inputAddress" name="adress"
										value="<%=user4.getAdress()%>">
								</div>

							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputAddress2">Landmark</label> <input type="text"
										class="form-control" id="inputAddress2" name="landmark"
										value="<%=user4.getLandmark()%>">
								</div>
								<div class="form-group col-md-6">
									<label for="inputCity">City</label> <input type="text"
										name="city" class="form-control" id="inputCity"
										value="<%=user4.getCity()%>">
								</div>

							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputState">State</label> <input type="text"
										name="state" name="state" class="form-control"
										value="<%=user4.getState()%>">
								</div>
								<div class="form-group col-md-6">
									<label for="inputZip">Zip</label> <input type="text" name="pin"
										class="form-control" id="inputZip" value="<%=user4.getZip()%>">
								</div>

							</div>

							<div class="form-group">
								<label for="inputState">Payment Type</label> <select
									id="inputState" class="form-control" name="payment">
									<option selected>--select--</option>
									<option value="cod">Cash On Delivery</option>
								</select>
							</div>

							<div class="container text-center text-white">

								<%
								CartDAOImpl dao = new CartDAOImpl(ConnectionProvider.getConnection());
								int uid = user.getId();
								boolean f = dao.cartCheck(uid);
								if (f) {
								%>
								<button type="submit" class="btn btn-warning">Order Now</button>
								<%
								} else {
								%>
								<a data-toggle="modal" data-target="#checkItem" type="submit"
									class="btn btn-warning">Order Now</a>
								<%
								}
								%>



								<a href="index.jsp" type="submit" class="btn btn-success">Continue
									Shopping</a>
							</div>
						</form>
						<%
						}
						%>



					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Item Not available Modal -->
	<div class="modal fade" id="checkItem" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center text-success">
					<h5 class="modal-title" id="exampleModalLabel"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="text-center">
						<%
						if (user != null) {
						%>
						<h2 class="text-center text-danger"><%=user.getName()%></h2>
						<%
						}
						%>
						<h5 class="text-center text-danger">Add Item</h5>
						<a href="index.jsp" class="btn btn-primary"><i
							class="fas fa-home">Select Books</i></a>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- Item Not available Modal -->



</body>
</html>