<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.OrphanageDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="index.jsp"><i
		class="fas fa-hand-holding-heart"></i>The Charity</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<!-- <li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li> -->

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> NGO </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="home.jsp?ca=all">All</a>
					<%
					OrphanageDAO dao2 = new OrphanageDAO(DBConnect.getConn());
					List<Category> list2 = dao2.getAllCategory();
					for (Category c : list2) {
					%>
					<a class="dropdown-item"
						href="home.jsp?ca=<%=c.getCategoryName()%>"><%=c.getCategoryName()%></a>
					<%
					}
					%><div class="dropdown-divider"></div>
				</div></li>

			<li class="nav-item dropdown active"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Orphanage </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="orphan_home.jsp?ca=all">All</a>
					<%
					for (Category c : list2) {
					%>
					<a class="dropdown-item"
						href="orphan_home.jsp?ca=<%=c.getCategoryName()%>"><%=c.getCategoryName()%></a>
					<%
					}
					%>
					<div class="dropdown-divider"></div>

				</div></li>

			<li class="nav-item active"><a class="nav-link"
				href="donate_status.jsp">Donation</a></li>

		</ul>



		<ul class="navbar-nav ml-auto">
			<c:if test="${empty donobj}">

				<li class="nav-item active"><a class="nav-link"
					href="orphans_login.jsp">Orphanage</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="register.jsp">Register</a></li>

				<!-- <a href="login.jsp" class="btn btn-success mr-1"><i
					class="fas fa-sign-in-alt"></i> Login</a>
				<a href="register.jsp" class="btn btn-primary text-white"><i
					class="fas fa-user-plus"></i> Register</a> -->

			</c:if>

			<c:if test="${not empty donobj}">
				<li><a href="#" class="btn  btn-success ml-1 mr-1"><i
						class="fas fa-user-circle"></i> ${donobj.name }</a></li>

				<li><a href="logout" class="btn  btn-primary text-white"><i
						class="fas fa-sign-in-alt"></i> Logout </a></li>
			</c:if>

		</ul>
	</div>
</nav>