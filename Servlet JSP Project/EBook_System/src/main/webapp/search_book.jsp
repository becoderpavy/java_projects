<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.entity.bookDtls"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook: Search Book</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #FFFF99;
}
</style>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<%
			int z = 0;
			String ch = request.getParameter("ch".trim());
			BookDAOImpl dao = new BookDAOImpl(ConnectionProvider.getConnection());
			List<bookDtls> blist = dao.getBookBySearch(ch);
			for (bookDtls b : blist) {
				z = 1;
			%>
			<div class="col-md-3 mt-2">
				<div class="card crd-ho" style="height: 330px;">
					<div class="card-body text-center">
						<img src="book/<%=b.getBookImg()%>" class="img-thumbnail"
							style="width: 100px; height: 150px;">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthorName()%></p>
						<p>
							Categorie:<%=b.getCategories()%></p>
						<!-- <div class="text-white"> -->
						<%
						String cate = b.getCategories();
						if ("New".equals(cate)) {
							if (user != null) {
						%>
						<a href="cartServlet?bid=<%=b.getId()%>&&uid=<%=user.getId()%>"
							class="btn btn-sm btn-danger"> <i class="fas fa-cart-plus"></i>Add
							Cart
						</a> <a href="view_books.jsp?bid=<%=b.getId()%>"
							class="btn btn-sm btn-success">View</a>
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
						<a href="view_books.jsp?bid=<%=b.getId()%>" class="btn btn-danger btn-sm">View Details</a>
						<%
						}
						%>


						<a class="btn btn-sm btn-danger text-white"><i
							class="fas fa-rupee-sign"></i><%=b.getPrice()%></a>
						<!-- </div> -->
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>

		<%
		if (z == 0) {
		%>
		<h1 class="text-center text-danger">Item Is not available</h1>
		<%
		}
		%>

	</div>


	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>