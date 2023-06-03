<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
	<a class="navbar-brand" href="home.jsp"><i class="fas fa-book"></i>
		E-Manage</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto">



			<c:if test="${ empty userobj }">
				<!-- <li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact
						Us</a></li> -->

				<li class="nav-item"><a class="nav-link" href="index.jsp"><i
						class="fas fa-sign-in-alt"></i> Login</a></li>
			</c:if>



			<c:if test="${not empty userobj }">

				<form class="form-inline my-2 my-lg-0 mr-5" action="search.jsp">
					<input class="form-control mr-sm-2" type="search" name="ch"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-light  my-2 my-sm-0" type="submit">Search</button>
				</form>

				<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
						class="fas fa-home"></i> Home <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="view_book.jsp"><i
						class="fas fa-book-open"></i> Book</a></li>

				<li class="nav-item"><a class="nav-link" href="Depart.jsp"><i
						class="fas fa-book-open"></i> Department</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fas fa-user-circle"></i>
						${userobj.name }
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="view_profile.jsp">View Profile</a>
						<a class="dropdown-item" href="change_password.jsp">Change
							Password</a>
						<div class="dropdown-divider"></div>
					</div></li>

				<li class="nav-item"><a class="nav-link" href="logout"><i
						class="fas fa-sign-out-alt"></i> Logout</a></li>
			</c:if>


		</ul>
		<!--   <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success text-white my-2 my-sm-0" type="submit">Search</button>
    </form> -->
	</div>
</nav>