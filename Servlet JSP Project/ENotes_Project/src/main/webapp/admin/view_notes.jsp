<%@page import="com.DAO.UserDAO"%>
<%@page import="com.entity.Note"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcss.jsp"%>

</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<h2 class="text-center">All Notes:</h2>

		<div class="row">
			<div class="col-md-12">
				<%
				int nid = Integer.parseInt(request.getParameter("nid"));
				PostDAO dao = new PostDAO(DBConnect.getConn());
				Note po = dao.getDataById(nid);

				UserDAO dao2 = new UserDAO(DBConnect.getConn());
				UserDetails user = dao2.getUserById(po.getUserId());
				%>


				<div class="card mt-3 paint-card">

					<img alt="" src="img/paper.png" class="card-img-top mt-2 mx-auto"
						style="max-width: 70px;">


					<div class="card-body">
						<h5 class="card-title ml-3 "><%=po.getTitle()%></h5>
						<p class="ml-3"><%=po.getContent()%>
							.
						</p>


						<p>
							<b class="text-success ml-3">Published By: <span
								class="text-dark"><%=user.getName()%></span>
							</b> | <b class="text-success ml-3">Published Date: <span
								class="text-dark"><%=po.getPdate()%></span>
							</b>| <b class="text-success ml-3">upload file: <%
							if (po.getFileName().equals("NA")) {
							%> <span class="text-dark"><%=po.getFileName()%></span> <%
 } else {
 %> <span class="text-dark"><a
									href="downloadFile?fileName=<%=po.getFileName()%>"><i
										class="fa fa-arrow-circle-o-down" aria-hidden="true"></i> <%=po.getFileName()%></a></span>
								<%
								}
								%>
							</b>
						</p>

						<p></p>
						<p></p>

						<div class="container text-center">

							<a href="edit.jsp?nid=<%=po.getId()%>"
								class="btn btn-primary btn-sm text-white">Edit</a> <a
								href="../deleteNotes?nid=<%=po.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>


</body>
</html>