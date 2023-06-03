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
<title>Professor: Home</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
.back-img {
	background: 
		url("img/im1.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	width: 100%;
	height: 60vh;
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
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="back-img"></div>
	<div class="container">
		<h3 class="text-center mt-2">
			<em>Top Recommendation</em>
		</h3>
		<hr
			style="height: 4px; width: 80%; color: white; background-color: white;">

		<div class="row p-5">
			<%
			BookDao dao = new BookDao(DbConnect.getConn());
			List<Book> list = dao.getBookByRecommend();
			for (Book b : list) {
			%>

			<div class="col-md-3">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 150px; height: 200px;">
								
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