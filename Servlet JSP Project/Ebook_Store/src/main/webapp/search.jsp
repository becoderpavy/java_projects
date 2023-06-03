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
<title>Insert title here</title>
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
			<em>Book</em>
		</h3>
		<hr
			style="height: 4px; width: 80%; color: white; background-color: white;">

		<div class="row">


			<%
			String ch=request.getParameter("ch");
			BookDao dao = new BookDao(DbConnect.getConn());
			List<Book> list = dao.getBookBySerch(ch);

			for (Book b : list) {
			%><div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
							<h6><%=b.getBookName()%></h6>
							<h6><%=b.getDepartment() %></h6>
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