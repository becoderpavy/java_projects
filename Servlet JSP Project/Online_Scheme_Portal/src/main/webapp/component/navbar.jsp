
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-list"></i> Online Scheme Portal</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp"><i class="fas fa-home"></i>
						HOME</a></li>



				<c:if test="${empty userObj }">
					<li class="nav-item"><a class="nav-link" href="login.jsp"><i
							class="fas fa-sign-in-alt"></i> LOGIN</a></li>
					<li class="nav-item"><a class="nav-link" href="signup.jsp">SIGNUP</a></li>
				</c:if>

				<c:if test="${not empty userObj }">
					
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"><i
								class="fas fa-user-circle"></i> ${userObj.fullName } </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<li><a class="dropdown-item" href="edit_profile.jsp">
										View Profile</a></li>
								<li><a class="dropdown-item" href="userLogout">logout</a></li>

							</ul></li>





					</ul>
				</c:if>

			</ul>
		</div>
	</div>
</nav>