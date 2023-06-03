<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<a class="navbar-brand" href="home.jsp"><i
		class="fas fa-hand-holding-heart"></i>The Charity</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="add_user.jsp">Add user</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="view_user.jsp">View user</a></li>

		</ul>



		<ul class="navbar-nav ml-auto">
		

			<c:if test="${not empty orgobj}">
				<li><a href="#" class="btn  btn-success ml-1 mr-1"><i
						class="fas fa-user-circle"></i> ${orgobj.orgName }</a></li>

				<li><a href="../logout" class="btn  btn-primary text-white"><i
						class="fas fa-sign-in-alt"></i> Logout </a></li>
			</c:if>

		</ul>
	</div>
</nav>