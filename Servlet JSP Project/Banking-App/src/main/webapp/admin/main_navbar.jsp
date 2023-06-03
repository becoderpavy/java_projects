<nav
	class="navbar navbar-expand-sm navbar-dark bg-primary flex-sm-nowrap flex-wrap">
	<div class="container-fluid">
		<button class="navbar-toggler flex-grow-sm-1 flex-grow-0 me-2"
			type="button" data-bs-toggle="collapse" data-bs-target="#navbar5">
			<span class="navbar-toggler-icon"></span>
		</button>
		<span class="navbar-brand flex-grow-1">Banking System</span>
		<div
			class="navbar-collapse collapse flex-grow-1 justify-content-center"
			id="navbar5">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item active"><a class="nav-link" href="#"><i
						class="fas fa-file-invoice"></i> Account</a></li>
				<li class="nav-item"><a class="nav-link active" href="#"><i
						class="fas fa-address-card"></i> Transaction</a></li>
			</ul>
		</div>
		<div class="flex-grow-1">
			<!--spacer-->
		</div>

		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="#"><i
					class="fas fa-user-circle"></i> Admin</a></li>
			<li class="nav-item">
				<button class="btn btn-primary nav-link active" data-toggle="modal"
					data-target="#logoutMenu">
					<i class="fas fa-sign-out-alt"></i> Logout
				</button>
			</li>

		</ul>

		<!-- Button trigger modal -->

		<!-- Modal -->
		<div class="modal fade" id="logoutMenu" tabindex="-1" role="dialog"
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
						<a href="../logout" type="button" class="btn btn-primary">Logout</a>
					</div>
					</div>
					<div class="modal-footer bg-primary"></div>
				</div>
			</div>
		</div>

	</div>
</nav>