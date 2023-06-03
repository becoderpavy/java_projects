
<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("../login.jsp");
	session.setAttribute("Login-error", "Please Login..");
}
%>

<%@page import="com.entity.UserDetails"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
	<a class="navbar-brand" href="index.jsp"><i class="fa fa-book"
		aria-hidden="true"></i> ENotes</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
					class="fa fa-home" aria-hidden="true"></i> Home <span
					class="sr-only">(current)</span></a></li>
			<!-- <li class="nav-item"><a class="nav-link" href="addNotes.jsp"><i
					class="fa fa-plus-circle" aria-hidden="true"></i> Add Notes</a></li> -->

			<li class="nav-item"><a class="nav-link"
				href="view_all_notes.jsp"><i class="fa fa-address-book-o"
					aria-hidden="true"></i> View Notes</a></li>
		</ul>




		<a href="" class="btn btn-light my-2 my-sm-0 mr-2" data-toggle="modal"
			data-target="#exampleModal" type="submit"><i
			class="fa fa-user-circle-o" aria-hidden="true"></i> Admin</a> <a
			data-toggle="modal" data-target="#exampleModalCenter"
			class="btn btn-light my-2 my-sm-0" type="submit"><i
			class="fa fa-sign-out" aria-hidden="true"></i> Logout</a>


		<!-- Logout Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"></h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<h5 class="text-center text-success">Do You want logout</h5>
						<a href="../adminLogoutServlet" class="btn btn-primary text-white">Logout</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end logout modal  -->








	</div>



</nav>