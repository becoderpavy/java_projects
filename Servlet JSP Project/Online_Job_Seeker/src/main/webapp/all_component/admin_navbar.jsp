<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div class="container-fluid p-2 bg-light">
	<div class="row">
		<div class="col-md-6">
			<h2 class=" text-success text-center">
				<i class="fas fa-search"></i> Find Jobs
			</h2>
		</div>
		<div class="col-md-6 text-center">
			<c:if test="${not empty adminObj }">
				<a href="#" class="btn btn-outline-success">Admin</a>
				<a href="../adminLogout" class="btn btn-success ml-2"><i
					class="fas fa-sign-out-alt"></i> Logout</a>
			</c:if>
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<a class="navbar-brand" href="#">Job Seeker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item active"><a class="nav-link"
				href="add_jobs.jsp"><i class="fas fa-server"></i> Add Jobs</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="view_jobs.jsp">View Jobs</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="search.jsp">Resume</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="candidate.jsp">Candidates</a></li>
		</ul>

	</div>
</nav>




