
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page isELIgnored="false"%>

<div class="container-fluid border"
	style="background-color: #01579b; height: 7px;"></div>


<div class="container-fluid p-1" style="background-color: #FFFFFF;">
	<div class="row">
		<div class="col-md-3 d-flex justify-content-center">
			<h1 class="text-success">
				<i class="fas fa-university"></i> Banking System
			</h1>
		</div>

		<div
			class="col-md-3 d-flex justify-content-center mt-3 font-weight-bold">
			<%
			LocalDate d = LocalDate.now();
			String w = d.getDayOfWeek().toString();
			int day = d.getDayOfMonth();
			String mo = d.getMonth().toString();
			int y = d.getYear();
			String date = w + "," + day + "-" + mo + "-" + y;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
			String ctime = LocalTime.now().format(formatter).toString();
			%>
			<i class="far fa-calendar-alt mr-1 mt-1 text-primary"></i>
			<%=date%>,
			<%=ctime%>
		</div>

		<div class="col-md-6 text-center font-weight-bold">
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
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top ">
	<a class="navbar-brand" href="#"><i class="fas fa-university"></i></a>
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
			<c:if test="${empty userobj}">
				<li class="nav-item"><a class="nav-link"
					href="create_account.jsp">Create Account</a></li>
				<li class="nav-item"><a class="nav-link" href="netbanking.jsp">Net
						Banking</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>

			</c:if>

			<c:if test="${not empty userobj}">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Account Info </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="viewprofile.jsp">View Profile</a> <a
							class="dropdown-item" href="chngpswd.jsp">Change Password</a>
						<div class="dropdown-divider"></div>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Transaction </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="send_money.jsp">Send Money</a>
						<div class="dropdown-divider"></div>
					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Reports </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="all_transaction.jsp">All
							Transaction</a> <a class="dropdown-item" href="debit.jsp">Debit</a> <a
							class="dropdown-item" href="credit.jsp">Credit</a>
						<div class="dropdown-divider"></div>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="balance.jsp">Balance</a></li>
				<li class="nav-item"><a class="nav-link" href="apply_check.jsp">Check</a></li>
				
		</ul>

		<!-- <form class="form-inline my-2 my-lg-0"> -->
		<button class="btn btn-white my-2 my-sm-0" type="submit">${userobj.firstName}
			${userobj.lastName}</button>

		<button class="btn btn-white btn-sm ml-1 nav-link active"
			data-toggle="modal" data-target="#logoutMen">
			<i class="fas fa-sign-out-alt"></i> Logout
		</button>
		<!-- Modal -->


		<!-- </form> -->
		</c:if>

	</div>
</nav>


<div class="modal fade" id="logoutMen" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header bg-primary">

				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h5 class="text-center">Do You Want Logout</h5>

				<div class="text-center">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="logout" type="button" class="btn btn-primary">Logout</a>
				</div>
			</div>
			<div class="modal-footer bg-primary"></div>
		</div>
	</div>
</div>
