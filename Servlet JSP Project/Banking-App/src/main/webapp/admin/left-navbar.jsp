<!--    <div class="sidebar">
  <a class="active" href="#home"><i class="fas fa-home"></i> Home</a> 
  <a href="#about">About</a>
</div>

<div class="content">
  <h2>Responsive Sidebar Example</h2>
  <p>This example use media queries to transform the sidebar to a top navigation bar when the screen size is 700px or less.</p>
  <p>We have also added a media query for screens that are 400px or less, which will vertically stack and center the navigation links.</p>
  <h3>Resize the browser window to see the effect.</h3>
</div> -->

<div class="col-md-2 sidebar">

	<a class="active" href="index.jsp"><i class="fas fa-home"></i> Home</a> 
	
 	<div class="dropdown">
	<a href="#about" class="dropdown-toggle" data-toggle="dropdown"
		aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-circle"></i> Account</a>
		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="open_acc.jsp"><i class="fas fa-arrow-alt-circle-right"></i> Open New Account</a>
			<a class="dropdown-item" href="all_user.jsp"><i class="fas fa-arrow-alt-circle-right"></i> All Account</a>
			<a class="dropdown-item" href="acc_status.jsp"><i class="fas fa-arrow-alt-circle-right"></i> Account Status</a>
		</div>
	</div>

	<div class="dropdown">
	<a href="#about" class="dropdown-toggle" data-toggle="dropdown"
		aria-haspopup="true" aria-expanded="false"><i class="fas fa-address-card"></i> Transaction</a>
		<div class="dropdown-menu" aria-labelledby="menu2">
			<a class="dropdown-item" href="new_transaction.jsp"><i class="fas fa-arrow-alt-circle-right"></i> New Transaction</a>  
			<a class="dropdown-item" href="all_trans.jsp"><i class="fas fa-arrow-alt-circle-right"></i> All Transaction</a>
		</div>
	</div> 
	
	<a class="active" href="check_status.jsp"><i class="fas fa-home"></i> Cheque</a> 
</div>