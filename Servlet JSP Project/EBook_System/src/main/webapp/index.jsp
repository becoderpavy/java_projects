<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.entity.bookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.BookDAO"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook:Home</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.back-img {
	background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)),
		url("img/img.jpg");
	width: 100%;
	height: 50vh;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fafafa;
}
</style>
</head>
<body style="background-color: #f0f1f2">


	<%@include file="all_component/navbar.jsp"%>
	<!-- start banner -->
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">
				<i class="fa fa-book" aria-hidden="true"></i> E-Book Management
				System
			</h1>
		</div>
	</div>
	<!-- end banner -->
	
	<!-- Recent start book -->
	<div class="container p-4">
		<h2 class="text-center">Recent Book</h2>
		<div class="row">

			<%
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book = dao.getRecentBook();

			for (bookDtls b : book) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="book/<%=b.getBookImg()%>" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthorName()%></p>
						<p>Categorie: <%=b.getCategories()%></p>
						<div class="text-white">
							<%
							String cate = b.getCategories();
							if ("New".equals(cate)) {
								if (user != null) {
							%>
							<a href="cartServlet?bid=<%=b.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a>
							<a href="view_books.jsp?bid=<%=b.getId() %>" class="btn btn-sm btn-success">View</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a>
							<a href="view_books.jsp?bid=<%=b.getId()%>" class="btn btn-sm btn-success">View</a>
							<%
							}
							%>

							<%
							} else {
							%>
							<a href="view_books.jsp?bid=<%=b.getId() %>" class="btn btn-sm btn-danger">View Details</a>
							<%
							}
							%>


							<a class="btn btn-sm btn-danger"><i
								class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>
		</div>
		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm" href="recent_book.jsp">View All</a>
		</div>
	</div>

	

	<!--Recent end book-->
	<hr>

	<!-- Recent New book -->

	<div class="container p-4">
		<h2 class="text-center">New Book</h2>
		<div class="row">
			<%
			BookDAO dao1 = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book1 = dao.getNewBook();

			for (bookDtls b : book1) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="book/<%=b.getBookImg()%>" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthorName()%></p>
						<p>
							Categorie:
							<%=b.getCategories()%></p>
						<div class="text-white">

							<%
							if (user != null) {
							%>
							<a href="cartServlet?bid=<%=b.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a>
							<a href="view_books.jsp?bid=<%=b.getId()%>" class="btn btn-sm btn-success">View</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a>
							<a href="view_books.jsp?bid=<%=b.getId()%>" class="btn btn-sm btn-success">View</a>
							<%
							}
							%>


							<a class="btn btn-sm btn-danger"><i
								class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>
		</div>
		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm" href="new_book.jsp">View All</a>
		</div>
	</div>

	<!-- End New book -->

	<hr>

	<!-- old start book -->

	<div class="container p-4">
		<h2 class="text-center">Old Book</h2>
		<div class="row">
			<%
			BookDAO dao2 = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book2 = dao.getOldBook();

			for (bookDtls b3 : book2) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img src="book/<%=b3.getBookImg()%>" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p><%=b3.getBookName()%></p>
						<p><%=b3.getAuthorName()%></p>
						<p>
							Categorie:
							<%=b3.getCategories()%></p>
						<div class="text-white">
							<a href="view_books.jsp?bid=<%=b3.getId()%>" class="btn btn-danger">View Details</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i><%=b3.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>
		</div>

		<div class="text-center text-white mt-2">
			<a class="btn btn-danger btn-sm" href="old_book.jsp">View All</a>
		</div>
	</div>

	<!-- End old book -->

	<%@include file="all_component/modal.jsp"%>


	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>


</body>
</html>