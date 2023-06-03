
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.OrdersDAO"%>
<%@page import="com.entites.Movies"%>
<%@page import="java.util.Random"%>
<%@page import="com.entites.Orders"%>
<%@page import="com.entites.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.MoviesDAO"%>
<%@page import="com.dao.CartDAO"%>
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
<title>Card Payment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style type="text/css">
.error {
	color: red;
}
</style>

<link rel="stylesheet" href="css/card.css">

</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="wrapper">
		<h4 class="text-uppercase text-center">Payment Details</h4>
		<form class="form mt-4" id="cardform" novalidate
			action="card_payment.jsp">

			<div class="form-group">
				<label for="card" class="text-uppercase">card number</label>
				<div class="card-number">
					<input type="text" class="card-no" name="cno"
						placeholder="1234 4567 5869 1234"> <span class="">
						<img
						src="https://www.freepnglogos.com/uploads/mastercard-png/mastercard-marcus-samuelsson-group-2.png"
						alt="" width="30" height="30">
					</span>
				</div>
			</div>
			<div class="d-flex w-100">
				<div class="d-flex w-50 pr-sm-4">
					<div class="form-group">
						<label for="expiry" class="text-uppercase">exp.date</label> <input
							name="dt" type="text" class="form-control" placeholder="03/2020">
					</div>
				</div>
				<div class="d-flex w-50 pl-sm-5 pl-3">
					<div class="form-group">
						<label for="cvv">CVV</label> <a href="#"
							title="CVV is a credit or debit card number, the last three digit number printed on the signature panel">what's
							this</a> <input name="cvv" type="password" class="form-control pr-5">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="text-uppercase">name on the card</label> <input
					name="cname" type="text" class="form-control">
			</div>
			<%
			String amount = request.getParameter("amt");
			String uid = request.getParameter("uid");
			%>
			<div class="form-group">
				<label for="name" class="text-uppercase">Total Amount</label> <input
					name="" type="text" class="form-control" value="<%=amount%>"
					readonly>
			</div>

			<div class="my-3">
				<input type="submit" value="Pay Now"
					class="text-uppercase btn btn-primary btn-block p-3">
			</div>
			<div id="form-footer">
				<p>By placing your order, you agree to our</p>
				<p>
					<a href="#">privacy notice</a> & <a href="#">terms of use</a>.
				</p>
			</div>



			<input type="hidden" value="<%=amount%>" name="amount"> <input
				type="hidden" value="<%=uid%>" name="userid">

		</form>
	</div>



	<%
	String amt = request.getParameter("amount");
	String userid = request.getParameter("userid");

	if (userid != null) {
		CartDAO dao = new CartDAO(DBConnect.getConn());
		MoviesDAO dao2 = new MoviesDAO(DBConnect.getConn());

		List<Cart> list = dao.getCart(Integer.parseInt(userid));

		Orders order = null;

		List<Orders> orderList = new ArrayList<Orders>();
		Random random = new Random();

		for (Cart c : list) {
			order = new Orders();
			order.setOrderId("ORD-" + random.nextInt(1000));
			order.setMovieId(c.getMid());
			order.setUserId(c.getUid());
			order.setQuantity(c.getQuantity());
			order.setTotalAmount(amt);
			order.setPaymentType("Online Payment (CARD))");

			Movies m = dao2.getMoviesById(c.getMid());
			order.setStoreId(m.getStoreId());

			orderList.add(order);
		}

		OrdersDAO dao3 = new OrdersDAO(DBConnect.getConn());

		boolean f = dao3.addOrder(orderList);

		if (f) {
			response.sendRedirect("order_sucess.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
	}
	%>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/card.js"></script>
</body>
</html>