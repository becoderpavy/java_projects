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
<title>Admin Edit Books</title>
<%@include file="allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-6">
							<div class="card border-0">
								<div class="card-body">
									<h3 class="text-center">Add Books</h3>
									<c:if test="${not empty succMsg}">
										<h4 class="text-center text-success">${succMsg}</h4>
										<c:remove var="succMsg" />
									</c:if>

									<c:if test="${not empty errorMsg}">
										<h4 class="text-center text-danger">${errorMsg}</h4>
										<c:remove var="errorMsg" />
									</c:if>
									<%
									int id = Integer.parseInt(request.getParameter("id"));
									BookDao dao = new BookDao(DbConnect.getConn());
									Book b = dao.getBookById(id);
									%>
									<form action="../updatebook" method="post"
										enctype="multipart/form-data">

										<input type="hidden" value="<%=b.getId()%>" name="id">

										<div class="form-group">
											<label>Enter Book Name</label> <input type="text" name="bn"
												required class="form-control" value="<%=b.getBookName()%>">
										</div>

										<div class="form-group">
											<label>Author Name</label> <input type="text" name="au"
												required class="form-control" value="<%=b.getAuthor()%>">
										</div>

										<div class="form-group">
											<label>Department</label> <select name="de" required
												class="form-control form-control-sm">
												<option value="<%=b.getDepartment()%>"><%=b.getDepartment()%></option>
												<option value="IT">IT</option>
												<option value="Business administration">Business
													administration</option>
												<option value="Medical">Medical</option>
											</select>
										</div>


										<div class="form-group">
											<label>Image</label> <input type="file" name="img"
												class="form-control">

										</div>

										<div class="form-group">
											<label>Pdf File</label> <input type="file" name="pdf"
												class="form-control">
										</div>

										<div class="form-group">
											<label>Status</label> <select class="form-control" name="st">
												<option value="<%=b.getStatus()%>"><%=b.getStatus()%></option>
												<option value="Active">Active</option>
												<option value="Inactive">Inactive</option>
											</select>
										</div>

										<div class="form-group">
											<label>Description</label>
											<textarea rows="3" cols="" class="form-control" name="desc"><%=b.getDescription()%></textarea>
										</div>

										<button class="btn btn-block btn-success">Update
											Books</button>

									</form>

								</div>
							</div>
						</div>
						<div class="col-md-6 text-center p-5">
							<img alt="" src="../book_img/<%=b.getImageName()%>" width="300px"
								height="350px"><br> <br> <a
								href="../filedownload?fn=<%=b.getPdfName()%>"
								class="btn btn-primary ">Download</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>