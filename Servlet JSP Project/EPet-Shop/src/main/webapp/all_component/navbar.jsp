<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.PetDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#"><i class="fas fa-home"></i> Epet Shop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>


			<li class="nav-item active dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Category </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="nav-link" href="animals.jsp?ca=all">
						All</a>
					<%
					PetDAOImpl daox = new PetDAOImpl(DBConnect.getConn());
					List<Category> listx = daox.getAllCategory();
					for (Category c : listx) {
					%>
					<a class="nav-link" href="animals.jsp?ca=<%=c.getCategoryName()%>">
						<%=c.getCategoryName()%></a>
					<%
					}
					%>
					<div class="dropdown-divider"></div>

				</div></li>








			<li class="nav-item active"><a class="nav-link"
				href="setting.jsp"><i class="fas fa-cog"></i> Setting</a></li>
		</ul>



		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link"
				href="checkout.jsp"><i class="fas fa-cart-plus fa-2x"></i></a></li>



			<form class="form-inline my-2 my-lg-0" action="search.jsp">

				<!-- <input class="form-control form-control-sm mr-sm-2" type="search"
					name="ch" placeholder="Search" aria-label="Search">
				<button class="btn btn-sm btn-primary my-2 my-sm-0 mr-5"
					type="submit">Search</button> -->

				<c:if test="${empty userobj}">
					<a href="login.jsp" class="btn btn-success mr-1"><i
						class="fas fa-sign-in-alt"></i> Login</a>
					<a href="register.jsp" class="btn btn-primary text-white"><i
						class="fas fa-user-plus"></i> Register</a>

				</c:if>

				<c:if test="${not empty userobj}">
					<li><a href="#" class="btn  btn-success ml-1 mr-1"><i
							class="fas fa-user-circle"></i> ${userobj.name }</a></li>

					<li><a href="logout" class="btn  btn-primary text-white"><i
							class="fas fa-sign-in-alt"></i> </a></li>
				</c:if>
			</form>
		</ul>
	</div>
</nav>