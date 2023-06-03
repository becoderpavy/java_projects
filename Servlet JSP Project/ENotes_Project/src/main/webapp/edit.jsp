<%@page import="com.DAO.PostDAO"%>
<%@page import="com.entity.Note"%>
<%@page import="com.Db.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login..");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%
	Integer noteid = Integer.parseInt(request.getParameter("note_id"));

	PostDAO post = new PostDAO(DBConnect.getConn());
	Note p = post.getDataById(noteid);
	%>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="NoteEditServlet" method="post" enctype="multipart/form-data">

						<input type="hidden" value="<%=noteid%>" name="noteid">
						<div class="form-group">

							<label for="exampleInputEmail1"> Title</label> <input type="text"
								class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required"
								value="<%=p.getTitle()%>" />
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1"> Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"><%=p.getContent()%></textarea>

						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Upload File</label> <input
								type="file" class="form-control" name="file"> <small
								class="font-weight-bold">uploaded file: <a
								href="downloadFile?fileName=<%=p.getFileName()%>"> <%=p.getFileName()%></a></small>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Update
								Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>


</body>
</html>