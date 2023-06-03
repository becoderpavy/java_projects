<%@page import="com.entity.Book"%>
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
<title>Professor : View book</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-2">


		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BookDao dao = new BookDao(DbConnect.getConn());
						Book b = dao.getBookById(id);
						%>

						<div class="col-md-6 text-center p-2">
							<img alt="" src="book_img/<%=b.getImageName()%>" width="300px"
								height="300px">
						</div>
						<div class="col-md-6">
							<div class="card border-0">
								<div class="card-body">


									<table class="mt-5">
										<tbody>
											<tr>
												<td><h4>Name :</h4></td>
												<td><%=b.getBookName()%></td>
											</tr>

											<tr>
												<td><h4>Author :</h4></td>
												<td><%=b.getAuthor()%></td>
											</tr>

											<tr>
												<td><h4>Department : &nbsp</h4></td>
												<td><%=b.getAuthor()%></td>
											</tr>

											<tr>
												<td><h4>Description :</h4></td>
												<td><%=b.getDescription()%></td>
											</tr>

										</tbody>
									</table>

									<div class="text-center mt-4">
										<a href="filedownload?fn=<%=b.getPdfName()%>"
											class="btn btn-primary btn-block"><i
											class="fas fa-arrow-circle-down"></i> Download</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>