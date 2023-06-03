<%@page import="com.entity.bookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DAO.BookDAO"%>
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
		<h2 class="text-center">Old Book</h2>
		<div class="row ">

			<%
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book = dao.getOldAllBook();

			for (bookDtls b : book) {
			%>

			<div class="col-md-3 mt-4">
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
							<a href="view_books.jsp?bid=<%=b.getId() %>" class="btn btn-small btn-danger">View Details</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>





			<!-- 		<div class="col mb-4">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col mb-4">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col mb-4">
				<div class="card">
					<div class="card-body text-center">
						<img src="book/c.png" class="img-thumbnail"
							style="width: 150px; height: 200px;">
						<p>Hello world</p>
						<div class="text-white">
							<a class="btn btn-small btn-danger"><i
								class="fas fa-cart-plus"></i>Add Cart</a> <a
								class="btn btn-small btn-danger"><i
								class="fas fa-rupee-sign"></i>200</a>
						</div>
					</div>
				</div>
			</div> -->


		</div>

		<%
		if (book.isEmpty()) {
		%>

		<h3 class="text-center text-primary">Not Available</h3>

		<%
		}
		%>

	</div>
	<div style="margin-top: 30px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>