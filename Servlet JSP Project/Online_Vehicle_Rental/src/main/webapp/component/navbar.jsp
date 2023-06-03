
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-light bg-danger">
	<div class="container-fluid">
		<a class="navbar-brand text-white" href="index.jsp"><i
			class="fa-solid fa-truck"></i> Vehicle Rental</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<c:if test="${ userObj.role=='USER'}">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="categories.jsp"><i
							class="fa-solid fa-list"></i> Categories</a></li>
					<li class="nav-item"><a class="nav-link" href="vehicle.jsp">Vehicles</a></li>
					<li class="nav-item"><a class="nav-link" href="mybooking.jsp">My
							Booking</a></li>
				</ul>
			</div>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="logout"><i
							class="fa-solid fa-circle-user"></i> ${userObj.name}</a></li>

					<li class="nav-item"><a class="nav-link" href="logout"><i
							class="fa-solid fa-right-from-bracket"></i> Logout</a></li>


				</ul>
			</div>
		</c:if>


		<c:if test="${ adminObj.role=='ADMIN'}">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="home.jsp"><i
							class="fa-sharp fa-solid fa-house"></i> Home</a></li>
					<li class="nav-item"><a class="nav-link" href="category.jsp"><i
							class="fa-solid fa-list"></i> Categories</a></li>
					<li class="nav-item"><a class="nav-link"
						href="add_vehicle.jsp">Vehicles</a></li>
					<li class="nav-item"><a class="nav-link"
						href="view_vehicle.jsp">View Vehicles</a></li>
					<li class="nav-item"><a class="nav-link" href="booking.jsp">Booking</a></li>
				</ul>
			</div>


			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa-solid fa-circle-user"></i> Admin</a></li>
					<li class="nav-item"><a class="nav-link" href="../logout"><i
							class="fa-solid fa-right-from-bracket"></i> Logout</a></li>


				</ul>
			</div>

		</c:if>


		<c:if test="${empty userObj}">
			<c:if test="${empty adminObj}">

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="categories.jsp"><i class="fa-solid fa-list"></i>
								Categories</a></li>
						<li class="nav-item"><a class="nav-link" href="vehicle.jsp">Vehicles</a></li>

					</ul>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="login.jsp"><i
								class="fas fa-sign-in-alt"></i> LOGIN</a></li>
						<li class="nav-item"><a class="nav-link" href="signup.jsp">SIGNUP</a></li>
					</ul>
				</div>
			</c:if>
		</c:if>




	</div>
</nav>