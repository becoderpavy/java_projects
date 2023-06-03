<%@page import="com.DAO.PostDAO"%>
<%@page import="com.entity.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");

if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login..");
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0efeb">
	<%@include file="all_component/navbar.jsp"%>
	<%
	String updateMsg = (String) session.getAttribute("updateMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	if (updateMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=updateMsg%></div>
	<%
	session.removeAttribute("updateMsg");
	}

	if (errorMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=errorMsg%></div>
	<%
	session.removeAttribute("errorMsg");
	}
	%>

	<div class="container">
		<h2 class="text-center">All Notes:</h2>

		<div class="row">
			<div class="col-md-12">
				<%
				if (user3 != null) {
					int uid = Integer.parseInt(request.getParameter("uid"));
					String ch = request.getParameter("ch");
					PostDAO ob = new PostDAO(DBConnect.getConn());
					List<Note> post = ob.getDataBySearch(ch, uid);
					for (Note po : post) {
				%>


				<div class="card mt-3">

					<img alt="" src="img/paper.png" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">


					<div class="card-body">
						<h5 class="card-title ml-3 "><%=po.getTitle()%></h5>
						<p class="ml-3"><%=po.getContent()%>
							.
						</p>


						<p>
							<b class="text-success ml-3">Published By: <span
								class="text-dark"><%=user3.getName()%></span>
							</b> | <b class="text-success ml-3">Published Date: <span
								class="text-dark"><%=po.getPdate()%></span>
							</b>| <b class="text-success ml-3">upload file: <%
							if (po.getFileName().equals("NA")) {
							%> <span class="text-dark"><%=po.getFileName()%></span> <%
 } else {
 %> <span class="text-dark"><a href="#"><i
										class="fa fa-arrow-circle-o-down" aria-hidden="true"></i> <%=po.getFileName()%></a></span>
								<%
								}
								%>
							</b>
						</p>

						<p></p>
						<p></p>

						<div class="container text-center">

							<a href="edit.jsp?note_id=<%=po.getId()%>"
								class="btn btn-primary btn-sm text-white">Edit</a> <a
								href="deleteServlet?note_id=<%=po.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>



			</div>
		</div>
	</div>


</body>
</html>