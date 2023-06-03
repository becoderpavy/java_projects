<%@page import="com.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Professor: View Book</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.card {
	box-shadow: 4px 6px #f0f1f2;
}

.card:hover {
	background-color: #f4f7d7;
}

a {
text-decoration: none;
outline: none;
}
a:hover {
	text-decoration: none;
	outline: none;
}

</style>
</head>
<body>
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<h3 class="text-center mt-2">
			<em>IT</em>
		</h3>
		<hr
			style="height: 4px; width: 80%; color: white; background-color: white;">

		<div class="row">


			<%
			BookDao dao = new BookDao(DbConnect.getConn());
			List<Book> list = dao.getBookByStatusIT();

			for (Book b : list) {
			%><div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
								<h6><%=b.getBookName() %></h6>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	
	<div class="container">
		<h3 class="text-center mt-2">
			<em>Medical</em>
		</h3>
		<hr
			style="height: 4px; width: 80%; color: white; background-color: white;">

		<div class="row">


			<%
			BookDao dao2 = new BookDao(DbConnect.getConn());
			List<Book> list2 = dao2.getBookByStatusMedical();

			for (Book b : list2) {
			%><div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
								<h6><%=b.getBookName() %></h6>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	
	<div class="container">
		<h3 class="text-center mt-2">
			<em>Business administartion </em>
		</h3>
		<hr
			style="height: 4px; width: 80%; color: white; background-color: white;">

		<div class="row">


			<%
			BookDao dao3 = new BookDao(DbConnect.getConn());
			List<Book> list3 = dao3.getBookByStatus();

			for (Book b : list3) {
			%><div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
								<h6><%=b.getBookName() %></h6>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>




</body>
</html>