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


			<c:if test="${not empty tobj }">
				<div class="btn-group">
					<button type="button"
						class="btn btn-light text-dark dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${tobj.name }
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" data-toggle="modal"
							data-target="#exampleModal">View Profile</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="edit_teacher.jsp" >Edit Profile</a>
					</div>
				</div>
				<a href="../tlogout" class="btn btn-light my-2 my-sm-0 ml-2" type="submit">
					<i class="fas fa-sign-out-alt"></i>Logout
				</a>

			</c:if>

		</form>
	</div>
</nav>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Profile Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<i class="fas fa-user-circle fa-3x"></i>
				<table class="table mt-2">
					<tbody>
						<tr>
							<th>Name</th>
							<th>${tobj.name}</th>
						</tr>
						<tr>
							<th>Gender</th>
							<th>${tobj.gender}</th>
						</tr>
						<tr>
							<th>DOB</th>
							<th>${tobj.dob}</th>
						</tr>
						<tr>
							<th>Qualification</th>
							<th>${tobj.qualification}</th>
						</tr>
						<tr>
							<th>Email</th>
							<th>${tobj.email}</th>
						</tr>
					</tbody>
				</table>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

