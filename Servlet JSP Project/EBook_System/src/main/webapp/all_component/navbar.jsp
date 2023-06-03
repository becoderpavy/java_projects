<%@page import="com.entity.userDtls"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>


<div class="container-fluid border"
	style="background-color: #01579b; height: 7px;"></div>


<div class="container-fluid p-3" style="background-color: #FFFFFF;">
	<div class="row">
		<div class="col-md-2 d-flex justify-content-center">
			<h1 class="text-success">
				<i class="fas fa-book"></i> E-Book
			</h1>
		</div>


		<div class="col-md-6 d-flex justify-content-center">
			<form class="form-inline" action="search_book.jsp" method="post">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="ch">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form>

		</div>

		<div class="col-md-4 mt-2">

			<%
			userDtls user = (userDtls) session.getAttribute("LoginUser");
			if (user == null) {
			%>
			<a class="btn btn-primary" href="login.jsp"><i
				class="fa fa-user-plus" aria-hidden="true"></i> Login</a> <a
				class="btn btn-success" href="create_account.jsp"><i
				class="fas fa-sign-in-alt"></i> Register</a>
			<%
			} else {
			%>
			<a href="checkout.jsp" class="text-primary" style="text-decoration: none;color: black;">
				<i class="fas fa-cart-plus fa-2x"></i><span style="font-size: 30px;">cart</span>
			</a> 
			
			<a href="" class="btn btn-primary my-2 my-sm-0 mr-2"
				data-toggle="modal" data-target="#exampleModal" type="submit"><i
				class="fas fa-user-circle"></i> <%=user.getName()%></a>


			<button type="button" data-toggle="modal" data-target="#lgBtn"
				class="btn btn-success my-2 my-sm-0" type="submit">
				<i class="fas fa-sign-in-alt"></i> Logout
			</button>
			<%
			}
			%>

			<!-- Start Edit Button Modal -->
			<div class="modal fade" id="lgBtn" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header bg-primary">

							<%
							if (user != null) {
							%>

							<h5 class="modal-title text-center text-white"
								id="exampleModalLongTitle"><%=user.getName()%></h5>

							<%
							}
							%>


							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-center">
							<h5>Do You Want Logout</h5>
						</div>
						<div class="text-center p-3">
							<a href="logoutServlet" class="btn btn-primary">Logout</a> <a
								type="button" class="btn btn-success" data-dismiss="modal">Close</a>

						</div>
					</div>
				</div>
			</div>
			<!--End Edit Button Modal -->

		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top ">
	<a class="navbar-brand" href="index.jsp"><i class="fas fa-home"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="recent_book.jsp"><i
					class="fas fa-book-open"></i> Recent Book</a></li>
			
			<li class="nav-item"><a class="nav-link" href="new_book.jsp"><i
					class="fas fa-book-open"></i> New Book</a></li>
			<li class="nav-item"><a class="nav-link" href="old_book.jsp"><i
					class="fas fa-book"></i> Old Book</a></li>


		</ul>

		<a href="user_profile.jsp" class="btn btn-light"><i
			class="fas fa-user-cog"></i> Setting</a> <a href="contact.jsp"
			class="btn btn-light ml-2"><i class="fas fa-user-cog"></i>
			Contact Us</a>

	</div>
</nav>

