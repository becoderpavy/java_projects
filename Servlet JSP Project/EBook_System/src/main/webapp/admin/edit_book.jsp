<%@page import="com.entity.bookDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<%
	String sucessMsg = (String) session.getAttribute("sucessMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	bookDtls b = (bookDtls) session.getAttribute("book");
	%>
	
	<a href="all_books.jsp"><h3 class="text-primary ml-3"><i class="fas fa-chevron-circle-left"></i>Back</h3></a>


	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<h5 class="text-primary">Update Book Details</h5>
							<%
							if (sucessMsg != null) {
							%>
							<p class="text-success"><%=sucessMsg%></p>
							<%
							session.removeAttribute("sucessMsg");
							}

							if (errorMsg != null) {
							%>
							<p class="text-danger"><%=errorMsg%></p>
							<%
							session.removeAttribute("errorMsg");
							}
							%>
						</div>

						<form action="../bookUpdateServlet" method="post">
							<input type="hidden" value="<%= b.getId()%>" name="bookId">
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									name="bname" type="text" class="form-control"
									value="<%=b.getBookName()%>" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									name="author" type="text" class="form-control"
									value="<%=b.getAuthorName()%>" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									value="<%=b.getPrice()%>" id="exampleInputPassword1">
							</div>

							<div class="form-group">
								<label for="inputState">Book Categories</label> <select
									id="inputState" name="btype" class="form-control">
									<option value="<%=b.getCategories()%>"><%=b.getCategories()%></option>
									<%
									if ((b.getCategories()).equals("New")) {
									%>
									<option value="Old">Old Book</option>
									<%
									} else {
									%>
									<option value="New">New Book</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="bstatus" class="form-control">
									<option value="<%=b.getBookStatus()%>"><%=b.getBookStatus()%></option>
									<%
									if ((b.getBookStatus()).equals("Active")) {
									%>
									<option value="Inactive">Inactive</option>
									<%
									} else {
									%>
									<option value="Active">Active</option>
									<%
									}
									%>
								</select>
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>