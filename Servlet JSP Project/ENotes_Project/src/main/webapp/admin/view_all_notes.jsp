<%@page import="com.entity.Note"%>
<%@page import="java.util.List"%>
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

<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<div class="card mt-4 paint-card">
					<div class="card-body">
						<h3 class="text-center text-primary">All Notes</h3>
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
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">File</th>
									<th scope="col">Published Date</th>
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>
								<%
								PostDAO dao = new PostDAO(DBConnect.getConn());
								List<Note> list = dao.getAllNotes();
								for (Note n : list) {
								%>
								<tr>
									<th scope="row"><a class="clink"
										href="view_notes.jsp?nid=<%=n.getId()%>"><%=n.getTitle()%></a></th>
									<th scope="row"><a
										href="../downloadFile?fileName=<%=n.getFileName()%>"><i
											class="fa fa-arrow-circle-o-down" aria-hidden="true"></i> <%=n.getFileName()%></a></th>
									<td><%=n.getPdate()%></td>
									<td><a href="edit.jsp?nid=<%=n.getId()%>"
										class="btn btn-primary">Edit</a> <a
										href="../deleteNotes?nid=<%=n.getId()%>" class="btn btn-danger">Delete</a></td>
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
</body>
</html>