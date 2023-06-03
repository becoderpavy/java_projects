<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="home.jsp"><i class="fa-solid fa-house-chimney-medical"></i> Medi Shop</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp"><i class="fas fa-home"></i> HOME</a></li>
				<li class="nav-item"><a class="nav-link" href="category.jsp">Category</a></li>
				<li class="nav-item"><a class="nav-link" href="painting.jsp">Medicine</a></li>
				<li class="nav-item"><a class="nav-link" href="order.jsp">Orders</a></li>

				<c:if test="${not empty artObj}">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user-circle"></i>
							${artObj.fullName } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="aedit_profile.jsp">View Profile</a></li>
							<li><a class="dropdown-item" href="../alogout">logout</a></li>

						</ul></li>
				</c:if>

			</ul>
			<form class="d-flex"></form>
		</div>
	</div>
</nav>