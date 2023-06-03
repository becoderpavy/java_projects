<%@page import="com.entity.ShopDtls"%>
<%@page import="com.DAO.ShopDAOImpl"%>
<%@page import="com.entity.UserDtls"%>
<%@page import="com.entity.PetDtls"%>
<%@page import="com.DAO.PetDAOImpl"%>

<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Animals</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>
	<%
	UserDtls u = (UserDtls) session.getAttribute("userobj");
	%>
	<c:if test="${not empty addCart }">

		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

		<c:remove var="addCart" scope="session" />
	</c:if>


	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">
			<%
			String ca = request.getParameter("ca");
			String sql = "";

			if ("all".equals(ca)) {
				sql = "select * from pet where status='Active' order by id desc";
			} else {
				sql = "select * from pet where category='" + ca + "' and  status='Active' order by id desc";
			}

			ShopDAOImpl d = new ShopDAOImpl(DBConnect.getConn());

			PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
			List<PetDtls> list = dao.getAllPets(sql);
			for (PetDtls p : list) {
				ShopDtls s = d.getShopById(p.getShopid());
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2 paint-card ">
					<div class="card-body text-center">
						<img alt="" src="pet_img/<%=p.getImage()%>"
							style="width: 150px; height: 150px" class="img-thumblin">
						<p><%=p.getPetName()%></p>
						<p>Categories: Animals</p>
						<div class="row">
							<%-- <%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-5"><i
								class="fas fa-cart-plus"></i> Add Cart</a>
							<%
							}

							else {

							if (p.getStock() <= 0) {
							%>
							<a href="#" class="btn btn-warning text-white btn-sm ml-2"><i
								class="fas fa-cart-plus"></i> Out Of Stock</a>
							<%
							} else {
							%>
							<a
								href="cart?pid=<%=p.getId()%>&&uid=<%=u.getId()%>&&sid=<%=s.getId()%>"
								class="btn btn-danger btn-sm ml-2"><i
								class="fas fa-cart-plus"></i> Add Cart</a>
							<%
							}

							}
							%> --%>

							<a href="view_pets.jsp?pid=<%=p.getId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> <i
								class="fas fa-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>