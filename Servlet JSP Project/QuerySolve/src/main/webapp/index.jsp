<%@page import="com.entity.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.QueryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${not empty qu }">
		<div class="alert alert-success text-center" role="alert">${qu }</div>
		<c:remove var="qu" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger text-center" role="alert">${failedMsg }</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>
	<div class="container-fluid">
		<div class="row">
			<%@include file="all_component/categories.jsp"%>

			<div class="col-md-9 mt-4">
				<!-- 	<div class="card">
					<div class="card-body">
						<form action="">
							<div class="form-group">
								<textarea rows="1" cols="" placeholder="What is your question ?"
									class="form-control"></textarea>
							</div>
							<button class="btn btn-primary btn-sm">Submit</button>
						</form>
					</div>
				</div> -->

				<%
				QueryDAO dao = new QueryDAO(DBConnect.getConn());
				List<Query> list = dao.getQueries();
				for (Query q : list) {
				%>
				<div class="card mt-2">
					<div class="card-body">
						<h5><%=q.getQuestion()%></h5>
						<%
						String imgfile = q.getImg();
						if (imgfile.length() != 0) {
						%>
						<div class="text-center">
							<img alt="" src="img/<%=imgfile%>"
								style="width: 100px; height: 100px">
						</div>
						<%
						}
						%>

						<%
						String desc = q.getDescription();
						if (desc != null) {
						%>
						<p><%=desc%></p>
						<%
						}
						%>


						<div class="row p-2">
							<p class="text-danger border p-1 border-warning">
								Categories:
								<%=q.getCategories()%></p>
							<p class="text-danger ml-3 border p-1 border-warning">
								Post By:
								<%=q.getUsername()%></p>
							<p class="text-danger ml-3 border p-1 border-warning">
								Date:
								<%=q.getPostDate()%></p>
						</div>

						<a href="answer?qid=<%=q.getId()%>"
							class="btn btn-outline-primary btn-sm">Answer</a>
					</div>
				</div>
				<%
				}
				%>
			</div>

		</div>
	</div>
	<div style="margin-top: 200px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>