<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom navbar-custom">
	<a class="navbar-brand" href="#">QuerySolve</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fas fa-home"></i> Home <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#query"><i class="fas fa-question-circle"></i> Post
					Query <span class="sr-only">(current)</span> </a></li>


			<!-- Modal -->
			<div class="modal fade" id="query" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header bgcolor">
							<h5 class="modal-title text-white" id="exampleModalLabel">Post
								Queries</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" style="background-color: #f0f1f2;">
							<div class="card">
								<div class="card-body">
									<form action="addQuries" method="post"
										enctype="multipart/form-data">

										<c:if test="${not empty userobj }">
											<input type="hidden" name="username"
												value="${userobj.fullName}">
										</c:if>

										<div class="form-group">
											<textarea rows="1" cols="" placeholder="What is your Query ?"
												class="form-control" name="query" required="required"></textarea>
										</div>

										<div class="form-group">
											<textarea rows="3" cols="" placeholder="Enter Description (Optional)"
												class="form-control" name="desc"></textarea>
										</div>

										<div class="form-group">
											<label for="exampleFormControlFile1">image</label> <input
												type="file" class="form-control-file" name="img"
												id="exampleFormControlFile1">
										</div>

										<div class="form-group">
											<label for="inputState">Categories</label> <select
												id="inputState" class="form-control" name="categories">
												<option value="Select">--select--</option>
												<option value="Academic">Academic</option>
												<option value="Cultural">Cultural</option>
												<option value="Internship">Internship</option>
												<option value="Project">Project</option>
												<option value="Hostel">Hostel</option>
												<option value="Admission">Admission</option>
												<option value="Placement">Placement</option>
												<option value="NPTEL">NPTEL</option>
												<option value="Motivation">Motivation</option>
												<option value="Study">Study</option>
												<option value="Health">Health</option>	
												<option value="Game">Game</option>
												<option value="Others">Others</option>
											</select>
										</div>

										<button class="btn btn-primary btn-sm">Submit</button>
									</form>
								</div>
							</div>
						</div>
						<div class="modal-footer bgcolor">
							<button type="button" class="btn btn-light" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>


		</ul>
		<form class="form-inline my-2 my-lg-0">
			<!-- <input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search"> -->

			<c:if test="${empty userobj }">
				<a href="login.jsp" class="btn btn-light my-2 my-sm-0" type="submit">
					<i class="fas fa-sign-in-alt"></i> Login
				</a>

				<a href="register.jsp" class="btn btn-light my-2 my-sm-0 ml-2"
					type="submit"> <i class="fas fa-user-plus"></i> Register
				</a>

			</c:if>

			<c:if test="${not empty userobj }">
				<a href="login.jsp" class="btn btn-light my-2 my-sm-0" type="submit"
					data-toggle="modal" data-target="#exampleModal"> <i
					class="fas fa-user"></i> ${userobj.fullName}
				</a>

				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title text-center" id="exampleModalLabel">Profile</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body" style="background-color: #f0f1f2;">
								<div class="card">
									<div class="card-body">
										<table class="table">
											<div class="text-center p-2 text-success">
												<i class="fas fa-user fa-3x"></i>
											</div>
											<tbody>
												<tr>
													<td>Name</td>
													<td>${userobj.fullName}</td>
												</tr>
												<tr>
													<td>Email</td>
													<td>${userobj.email}</td>

												</tr>
												<tr>
													<td>Gender</td>
													<td>${userobj.gender}</td>
												</tr>

												<tr>
													<td>Collage Id</td>
													<td>${userobj.collageId}</td>
												</tr>

												<tr>
													<td>User Category</td>
													<td>${userobj.category}</td>
												</tr>

											</tbody>
										</table>

									</div>
								</div>
							</div>
							<div class="modal-footer">
							<a href="edit.jsp?id=${userobj.id}" class="btn btn-primary">Edit</a>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>

				<a data-toggle="modal" data-target="#logoutMen"
					class="btn btn-light my-2 my-sm-0 ml-2" type="submit"><i
					class="fas fa-sign-in-alt"></i> logout </a>

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

			</c:if>
		</form>
	</div>
</nav>