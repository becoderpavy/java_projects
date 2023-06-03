<%@page import="com.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.BookDao"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.DepartmentDAO"%>
<%@page import="com.entity.Professor"%>
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

</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row">

			<%
			Professor p = (Professor) session.getAttribute("userobj");
			int id = p.getId();
			String nm = request.getParameter("nm");
			BookDao dao = new BookDao(DbConnect.getConn());
			DepartmentDAO dao2 = new DepartmentDAO(DbConnect.getConn());
			boolean f = dao2.checkDepartBy(id, nm);

			if ("IT".equals(nm) && f) {
				List<Book> list = dao.getBookByStatusIT();
				for (Book b : list) {
			%>
			<div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
							<h6><%=b.getBookName()%></h6>
							<h6><%=b.getDepartment()%></h6>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			} else if ("Medical".equals(nm) && f) {
			List<Book> list = dao.getBookByStatusMedical();
			for (Book b : list) {
			%>

			<div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
							<h6><%=b.getBookName()%></h6>
							<h6><%=b.getDepartment()%></h6>
						</div>
					</div>
				</a>
			</div>


			<%
			}
			} else if ("Business administartion".equals(nm) && f) {
			List<Book> list = dao.getBookByStatus();
			for (Book b : list) {
			%>
			<div class="col-md-3 p-2">
				<a href="view_one_book.jsp?id=<%=b.getId()%>">
					<div class="card">
						<div class="card-body text-center">
							<img src="book_img/<%=b.getImageName()%>"
								style="width: 130px; height: 170px;">
							<h6><%=b.getBookName()%></h6>
							<h6><%=b.getDepartment()%></h6>
						</div>
					</div>
				</a>
			</div>

			<%
			}
			}
			%>

		</div>
	</div>



</body>
</html>