
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

		<%-- <div
			class="col-md-3 d-flex justify-content-center mt-3 font-weight-bold">
			<%
				LocalDate d = LocalDate.now();
				String w = d.getDayOfWeek().toString();
				int day = d.getDayOfMonth();
				String mo = d.getMonth().toString();
				int y = d.getYear();
				String date = w + "," + day + "-" + mo + "-" + y;

				LocalTime t = LocalTime.now();
				String time = t.getHour() + ":" + t.getMinute();
				
			%>
			<i class="far fa-calendar-alt mr-1 mt-1 text-primary"></i>
			<%=date%>
			<%=time%>
		</div> --%>

		<!-- 	<div class="col-md-6 text-center font-weight-bold">
			<div class="row mt-3">
				<div class="col-md-4">
					<i class="fas fa-phone-square-alt text-success"></i> +0671 1234567
				</div>
				<div class="col-md-4 ">
					<i class="fas fa-envelope-square text-success"></i> help@Mybank.com
				</div>
				<div class="col-md-4 ">
					<i class="fab fa-facebook-square text-primary fa-2x  "></i> <i
						class="fab fa-youtube text-danger fa-2x"></i> <i
						class="fab fa-instagram-square text-warning fa-2x"></i> <i
						class="fab fa-whatsapp-square text-success  fa-2x "></i>
				</div>
			</div>
			
		</div> -->

		<div class="col-md-6 d-flex justify-content-center">
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
				

			</form>

		</div>

		<div class="col-md-4 mt-2">
			<a class="text-primary" style="font-size: 30px;">
					<i class="fas fa-cart-plus"></i>cart
				</a>
			<a class="btn btn-primary " href="login.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> Login</a>
				<a class="btn btn-success" href="create_account.jsp"><i
				class="fas fa-sign-in-alt"></i> Register</a>
				
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top ">
	<a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
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
			<li class="nav-item"><a class="nav-link"
				href="new_book.jsp"><i class="fas fa-book-open"></i> New Book</a></li>
			<li class="nav-item"><a class="nav-link" href="old_book.jsp"><i class="fas fa-book"></i> Old Book</a></li>
			<li class="nav-item"><a class="nav-link" href="user_profile.jsp"><i class="fas fa-user-cog"></i> Setting</a></li>
			
		</ul>
		
		<a href="" class="btn btn-light my-2 my-sm-0 mr-2" data-toggle="modal" data-target="#exampleModal"
			type="submit"><i class="fas fa-user-circle"></i>
			Pabitra Das</a> 
			
			<a href="LogoutServlet" class="btn btn-light my-2 my-sm-0"
			type="submit"><i
				class="fas fa-sign-in-alt"></i>
			Logout</a>

	</div>
</nav>

