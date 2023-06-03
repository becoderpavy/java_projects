<%@page import="com.entity.bookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.entity.userDtls"%>
<%
userDtls user1 = (userDtls) session.getAttribute("admin");
if (user1 == null) {
	response.sendRedirect("../login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Books Show</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center mt-1">Hello, Admin</h3>

	<%
	String sucessMsg = (String) session.getAttribute("sucessMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	/* String DsucessMsg = (String) session.getAttribute("DsucessMsg");
	String DerrorMsg = (String) session.getAttribute("DerrorMsg"); */
	%>

	<%
	if (sucessMsg != null) {
	%>
	<h5 class="text-success text-center"><%=sucessMsg%></h5>
	<%
	session.removeAttribute("sucessMsg");
	}

	if (errorMsg != null) {
	%>
	<h5 class="text-danger text-center"><%=errorMsg%></h5>
	<%
	session.removeAttribute("errorMsg");
	}
	%>

	<%-- <%
	if (DsucessMsg != null) {
	%>
	<h5 class="text-success text-center"><%=DsucessMsg%></h5>
	<%
	session.removeAttribute("DsucessMsg");
	}

	if (DerrorMsg != null) {
	%>
	<h5 class="text-danger text-center"><%=DerrorMsg%></h5>
	<%
	session.removeAttribute("errorMsg");
	}
	%> --%>

	<div class="container-fluid mt-3">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author Name</th>
					<th scope="col">Price</th>
					<th scope="col">Book Categories</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				BookDAOImpl dao = new BookDAOImpl(ConnectionProvider.getConnection());
				List<bookDtls> book = dao.getAllBook();

				for (bookDtls b : book) {
				%>

				<tr>
					<th scope="row"><%=b.getId()%></th>
					<td><img src="../book/<%=b.getBookImg()%>"
						style="width: 50px; height: 50px;"> <%=b.getBookName()%></td>
					<td><%=b.getAuthorName()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getCategories()%></td>
					<td><%=b.getBookStatus()%></td>
					<td><a class="btn btn-primary btn-sm text-white"
						href="../editBookAdminServlet?id=<%=b.getId()%>">Edit</a> <a
						class="btn btn-danger btn-sm text-white"
						href="../deleteBookAdminServlet?id=<%=b.getId()%>">Delete</a></td>
				</tr>


				<%
				}
				%>

			</tbody>
		</table>

	</div>




	<div style="margin-top: 30px;">
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>