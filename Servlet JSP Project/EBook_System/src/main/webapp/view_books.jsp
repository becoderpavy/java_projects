<%@page import="com.entity.bookDtls"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">

			<%
			int id = Integer.parseInt(request.getParameter("bid"));
			BookDAOImpl dao = new BookDAOImpl(ConnectionProvider.getConnection());
			bookDtls bk = dao.getBookById(id);
			String bcate = bk.getCategories();
			%>

			<div class="col-md-6 border p-5 text-center bg-white">
				<img src="book/<%=bk.getBookImg()%>"
					class="img-thumbnail mx-auto d-block"
					style="width: 150px; height: 200px;">
				<h5>
					Book Name: <span class="text-success"> <%=bk.getBookName()%></span>
				</h5>
				<h5>
					Author Name: <span class="text-success"><%=bk.getAuthorName()%></span>
				</h5>
				
				<h5>Category: <span class="text-success"><%=bk.getCategories() %></span></h5>

			</div>



			<div class="col-md-6 border p-5 bg-white">
				<h2 class="text-center"><%=bk.getBookName()%></h2>
				<%
				if (bcate.equals("Old")) {
				%>
				<div>
					<h4 class="text-center text-primary">Contct to Seller</h4>
					<h6 class="text-center text-primary">
						<i class="fas fa-envelope"></i>Email:
						<%=bk.getUserEmail()%></h6>

				</div>
				<%
				}
				%>


				<div class="row p-3">
					<div class="col-md-4 text-center text-danger p-2">
						<i class="fas fa-money-bill-wave fa-2x"></i><br>Cash On
						Delivery
					</div>
					<div class="col-md-4 text-center  text-danger p-2">
						<i class="fas fa-undo-alt fa-2x"></i><br>Return Available
					</div>
					<div class="col-md-4 text-center text-danger p-2">
						<i class="fas fa-truck fa-2x"></i></i><br>Free Delivery
					</div>
				</div>
				<div class="text-center">
					<%
					if ("New".equals(bcate)) {
						if (user != null) {
					%>
					<a href="cartServlet?bid=<%=bk.getId()%>&&uid=<%=user.getId()%>"
						class="btn text-white btn-warning"> <i class="fas fa-cart-plus"></i>Add
						Cart
					</a>
					<%
					} else {
					%>
					<a href="login.jsp" class="btn text-white btn-primary"> <i
						class="fas fa-cart-plus"></i>Add Cart
					</a>
					<%
					}
					} else {
					%>
					<a href="index.jsp" class="btn btn-success text-white">Continue Shopping</a>
					<%
					}
					%>
					<a class="btn text-white btn-danger"><i class="fas fa-rupee-sign"></i><%=bk.getPrice()%></a>
				</div>
			</div>


		</div>
	</div>

	<div style="margin-top: 100px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>