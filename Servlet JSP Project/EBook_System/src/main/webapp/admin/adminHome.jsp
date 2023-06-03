<%@page import="com.entity.userDtls"%>
<%
userDtls user1=(userDtls)session.getAttribute("admin");
if(user1==null)
{
	response.sendRedirect("../login.jsp");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss_file.jsp"%>
<style type="text/css">

a{
	text-decoration: none;
	color: black
}

a:hover {
	text-decoration: none;
}

</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<h3 class="text-center">Hello,Admin</h3>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-3">
				<a href="add_books.jsp"><div class="card text-center">
						<div class="card-body">
							<div class="text-primary ">
								<i class="fas fa-plus-square fa-3x"></i>
							</div>
							<h4>Add Books</h4>
							<p>--------</p>
						</div>
					</div></a>
			</div>

		

			<div class="col-md-3">
				<a href="all_books.jsp"><div class="card text-center">
						<div class="card-body">
							<div class="text-danger">
								<i class="fas fa-book-open fa-3x"></i>
							</div>
							<h4>All Books</h4>
							<p>--------</p>
						</div>
					</div></a>
			</div>
			
				<div class="col-md-3">
				<a href="all_order.jsp"><div class="card text-center ">
						<div class="card-body">
							<div class="text-warning ">
								<i class="fas fa-box-open fa-3x"></i>

							</div>
							<h4>Order</h4>
							<p>--------</p>
						</div>
					</div></a>
			</div>

			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#lgBtn">
				<div class="card  text-center">
						<div class="card-body">
							<div class="text-primary ">
								<i class="fas fa-sign-out-alt fa-3x"></i>
							</div>
							<h4>logout</h4>
							<p>--------</p>
						</div>
					</div></a>
			</div>

		</div>
		
	
		
	</div>
	
	
	<!-- Start Edit Button Modal -->
			<div class="modal fade" id="lgBtn" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header bg-primary">

						<%-- 	<%
							if (user != null) {
							%>

							<h5 class="modal-title text-center text-white"
								id="exampleModalLongTitle"><%=user.getName()%></h5>

							<%
							}
							%> --%>


							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-center">
							<h5>Do You Want Logout</h5>
						</div>
						<div class="text-center p-3">
							<a href="../AdminLogoutServlet" class="btn btn-primary">Logout</a> <a
								type="button" class="btn btn-success" data-dismiss="modal">Close</a>

						</div>
					</div>
				</div>
			</div>
			<!--End Edit Button Modal -->
	

<div style="margin-top: 30px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>