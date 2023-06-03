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
<title>Admin View Book</title>
<%@include file="allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="col-md-12 p-3">
			<h4 class="text-center">All Books list</h4>
			<c:if test="${not empty succMsg}">
				<h4 class="text-center text-success">${succMsg}</h4>
				<c:remove var="succMsg" />
			</c:if>

			<c:if test="${not empty errorMsg}">
				<h4 class="text-center text-danger">${errorMsg}</h4>
				<c:remove var="errorMsg" />
			</c:if>
			<table class="table">
				<thead class="bg-success text-white">
					<tr>
						<th scope="col">Image</th>
						<th scope="col">Book Name</th>
						<th scope="col">Author</th>
						<th scope="col">Department</th>
						<th scope="col">Status</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody class="bg-light">
					<%
					BookDao dao = new BookDao(DbConnect.getConn());
					List<Book> list = dao.getAllBook();
					for (Book b : list) {
					%>
					<tr>
						<th scope="row"><img alt=""
							src="../book_img/<%=b.getImageName()%>" width="50px;"
							height="50px"></th>
						<td><%=b.getBookName()%></td>
						<td><%=b.getAuthor()%></td>
						<td><%=b.getDepartment()%></td>
						<td><%=b.getStatus()%></td>
						<td><a href="edit_book.jsp?id=<%=b.getId()%>"
							class="btn btn-sm btn-primary">Edit</a> <a
							href="../filedownload?fn=<%=b.getPdfName()%>"
							class="btn btn-sm btn-primary ">Download</a> <a
							href="../delete?id=<%=b.getId()%>" class="btn btn-sm btn-primary">Delete</a>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>