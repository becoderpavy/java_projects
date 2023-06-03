<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top">
	<a class="navbar-brand" href="#">Online Collage System</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<!-- Example single danger button -->
			<c:if test="${not empty adobj }">


				<div class="btn-group">
					<button type="button"
						class="btn btn-light text-dark dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-user-circle"></i> Admin
					</button>

				</div>
				<a href="../alogout" class="btn btn-light my-2 my-sm-0 ml-2" type="submit"><i
					class="fas fa-sign-out-alt"></i>Logout </a>
			</c:if>

		</form>
	</div>
</nav>