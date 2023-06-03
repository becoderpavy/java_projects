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
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fafafa;
}
</style>

</head>
<body>


	<%@include file="all_component/navbar.jsp"%>


	<!-- Recent start book -->
	<div class="container">
		<h2 class="text-center">All Book</h2>
		<div class="row">

			<%
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book = dao.getRecentAllBook();

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
							<%
							String cate = b.getCategories();
							if ("New".equals(cate)) {
								if (user != null) {
							%>
							<a href="cartServlet?bid=<%=b.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-sm btn-danger"> <i class="fas fa-cart-plus"></i>Add
								Cart
							</a> <a href="view_books.jsp?bid=<%=b.getId()%>"
								class="btn btn-sm btn-success" href="view_books.jsp?bid=<%=b.getId() %>" >View</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a> <a href="view_books.jsp?bid=<%=b.getId()%>"
								class="btn btn-sm btn-success">View</a>
							<%
							}
							%>

							<%
							} else {
							%>
							<a href="view_books.jsp?bid=<%=b.getId()%>"
								class="btn btn-sm btn-danger">View Details</a>
							<%
							}
							%>


							<a class="btn btn-sm btn-danger"><i class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>





						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>


			<%
			if (book.isEmpty()) {
			%>

			<h3 class="text-center text-primary">Not Available</h3>

			<%
			}
			%>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>