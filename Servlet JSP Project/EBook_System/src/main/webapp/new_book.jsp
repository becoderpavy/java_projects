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
<title>EBook: New Book</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-3">
		<h2 class="text-center">New Book</h2>
		<div class="row">

			<!-- start toast -->
			<%
			String addMsg = (String) session.getAttribute("addMsg");
			String notaddMsg = (String) session.getAttribute("notaddMsg");
			if (addMsg != null) {
			%>
			<div id="toast"><%=addMsg%>
			</div>
			<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}
		
		</script>
			<%
			session.removeAttribute("addMsg");
			}

			if (notaddMsg != null) {
			%>
			<div id="toast"><%=notaddMsg%>
			</div>
			<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}
		
		</script>
			<%
			session.removeAttribute("notaddMsg");
			}
			%>
			<!-- end toast -->

			<%
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());

			List<bookDtls> book = dao.getNewAllBook();

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
								class="btn btn-sm btn-success">View</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-sm btn-danger"> <i
								class="fas fa-cart-plus"></i>Add Cart
							</a> <a href="view_books.jsp?bid=<%=b.getId() %>" class="btn btn-sm btn-success">View</a>
							<%
							}
							%>

							<%
							} else {
							%>
							<a href="" class="btn btn-danger">View Details</a>
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

		<%@include file="all_component/modal.jsp"%>
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>