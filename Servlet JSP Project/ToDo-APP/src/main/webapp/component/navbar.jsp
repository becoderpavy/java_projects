<%@page import="com.entity.UserDetails"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">TODO-APP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">


		<%
		UserDetails user = (UserDetails) session.getAttribute("userD");

		if (user != null) {
		%>

		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="add_todo.jsp">Add
					ToDo</a></li>

		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link "
				href="#"><%=user.getName()%> <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item ml-2"><a class="nav-link active"
				href="LogoutServlet">Logout</a></li>

		</ul>

		<%
		} else {
		%>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a
				class="nav-link btn btn-light text-dark" href="login.jsp">Login
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item ml-2"><a
				class="nav-link btn btn-light text-dark" href="register.jsp">Register</a>
			</li>

		</ul>
		<%
		}
		%>





	</div>
</nav>