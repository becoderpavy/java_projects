<!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
	data-target="#exampleModal">Launch demo modal</button> -->

<!-- Modal -->
<%@page import="com.entity.cart"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.CartDAOImpl"%>
<%@page import="com.entity.userDtls"%>
<div class="modal fade" id="cart" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">


				<table class="table">
					<thead>
						<tr>
							<th scope="col">Book Name</th>
							<th scope="col">Author</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					
					
					<%-- 
						<%
						userDtls user1 = (userDtls) session.getAttribute("LoginUser");
						int uid2 = user1.getId();
						CartDAOImpl dao3 = new CartDAOImpl(ConnectionProvider.getConnection());
						List<cart> crt = dao3.getCartDetails(uid2);

						for (cart c : crt) {
						%>
						<tr>
							<th scope="row"><%=c.getBookName() %></th>
							<td><%=c.getAuthor() %></td>
							<td><%=c.getPrice() %></td>
							<td><a class="btn btn-danger btn-sm text-white">Remove</a></td>
						</tr>
						<% }%> --%>
						

					</tbody>
				</table>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<a href="checkout.jsp" type="button" class="btn btn-primary">Check Out</a>
			</div>
		</div>
	</div>
</div>


