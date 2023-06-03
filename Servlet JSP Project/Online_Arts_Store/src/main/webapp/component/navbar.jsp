<%@page import="com.entity.User"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.CartDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i class="fas fa-palette"></i> Print Store</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"><i class="fas fa-home"></i> HOME</a></li>
				<li class="nav-item"><a class="nav-link"
					href="all_paints.jsp?cat=all">PAINTINGS</a></li>

				<c:if test="${not empty userObj }">
					<%
					User u=(User)session.getAttribute("userObj");
					CartDAO crt = new CartDAO(DBConnect.getConnection());
					int count=crt.countCart(u.getId());
					%>

					<li class="nav-item"><a class="nav-link" href="cart.jsp">CART [<%=count %>]</a></li>
					<li class="nav-item"><a class="nav-link" href="orders.jsp">ORDERS</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user-circle"></i>
							${userObj.fullName } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="edit_profile.jsp"> View Profile</a></li>
							<li><a class="dropdown-item" href="ulogout">logout</a></li>

						</ul></li>
				</c:if>
				<c:if test="${empty userObj }">
					<li class="nav-item"><a class="nav-link" href="login.jsp"><i class="fas fa-sign-in-alt"></i> LOGIN</a></li>
					<li class="nav-item"><a class="nav-link" href="alogin.jsp">ARTIST</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>