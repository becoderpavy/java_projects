
<nav class="navbar navbar-expand-lg navbar-dark bg-success navbar-custom">
	<a class="navbar-brand" href="index.jsp"><i class="fas fa-burn"></i>
		Blood Bank</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fa fa-home" aria-hidden="true"></i> Home <span
					class="sr-only">(current)</span></a></li>

		</ul>



		<!-- <a href="" class="btn btn-light my-2 my-sm-0 mr-2" data-toggle="modal"
			data-target="#exampleModal" type="submit"><i
			class="fa fa-user-circle-o" aria-hidden="true"></i> Demo</a> 
			
			<a
			data-toggle="modal" data-target="#exampleModalCenter"
			class="btn btn-light my-2 my-sm-0" type="submit"><i
			class="fa fa-user-plus" aria-hidden="true"></i> Logout</a> -->


		<!-- Logout Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"></h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<h5 class="text-center text-success">Do You want logout</h5>
						<a href="LogoutServlet" class="btn btn-primary text-white">Logout</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end logout modal  -->




		<a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-2"
			type="submit"><i class="fas fa-user-md"></i>
			Admin Login</a> 
		






	</div>



</nav>