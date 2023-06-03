
<%@page import="com.entites.Scheme"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SchemeDAO"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>


	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-header">
						<p class="text-center fs-3">All Scheme List</p>
						<form action="search.jsp" method="post">
							<div class="row">
								<div class="form-group col-md-8 offset-md-1">
									<select class="form-control" name="category">
										<option class="text-center">-- choose category --</option>
										<option>Student</option>
										<option>Women</option>
										<option>Farmer</option>
										<option>BPL Families</option>
										<option>Children</option>

									</select>
								</div>

								<div class="form-group col-md-2">
									<button class="btn btn-primary">Search</button>
								</div>

							</div>
						</form>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Scheme Name</th>
									<th scope="col">Category</th>
									<th scope="col">Description</th>
									<th scope="col">Official Link</th>
									<th scope="col">Publish Date</th>
									<th scope="col">File</th>
								</tr>
							</thead>
							<tbody>
								<%
								SchemeDAO dao = new SchemeDAO(DBConnect.getConnection());
								List<Scheme> list = dao.getAllScheme();
								for (Scheme sc : list) {
								%>
								<tr>
									<th scope="row"><%=sc.getSchemeName()%></th>
									<td><%=sc.getCategory()%></td>
									<td><%=sc.getDescription()%></td>
									<td><a class="text-decoration-none"
										href="https://<%=sc.getSiteLink()%>" target="_blank">click
											here</a></td>
									<td><%=sc.getPublishDate()%></td>

									<td>
										<%
										if ("NA".equals(sc.getFileName())) {
											out.print("NA");
										} else {
										%> <a class="text-decoration-none"
										href="downloadFile?fileName=<%=sc.getFileName()%>"><i class="fa-solid fa-circle-arrow-down"></i> Download</a>

										<%
										}
										%>
									</td>

								</tr>

								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%-- <div style="margin-top: 200px">
		<%@include file="../component/footer.jsp"%>
	</div> --%>



</body>
</html>
