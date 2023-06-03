<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="css/style.css" rel="stylesheet" type="text/css" />



<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="index.jsp">Emp System</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i class="fas fa-home"></i> Dashboard
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item border"><a class="nav-link" href="status.jsp"><i class="far fa-minus-square"></i> Status</a></li>
			<li class="nav-item border"><a class="nav-link" href="contact.jsp"><i class="fas fa-phone-alt"></i> Contact</a></li>
			<li class="nav-item border"><a class="nav-link"
				href="change_password.jsp"><i class="fas fa-unlock-alt"></i> Change Password</a></li>
			<li class="nav-item border"><a class="nav-link" href="helpline.jsp"><i class="fas fa-headset"></i> Helpline</a></li>
		</ul>
		<c:if test="${not empty userobj }">
			<form class="form-inline my-2 my-lg-0">
				<a class="nav-link text-white"
					style="outline-color: white; outline: none;" href="#"><%=(new java.util.Date()).toString()%></a>
				<a data-toggle="modal" data-target="#profile-modal"
					class="btn btn-light my-2 my-sm-0"><i
					class="fas fa-user-circle"></i> ${userobj.firstName}</a> <a
					href="logout" class="btn btn-light ml-1"><i
					class="fas fa-sign-out-alt"></i> Logout</a>
			</form>
		</c:if>
	</div>
</nav>

