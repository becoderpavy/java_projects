<%@page import="com.entites.Actor"%>
<%@page import="com.entites.FilmActor"%>
<%@page import="java.util.List"%>
<%@page import="com.entites.Film"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.FilmDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
.paint-card {
	box-shadow: 0 0 7px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<div class="container-fluid p-5" style="background-color: #f0f1f2;">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<form action="search_result.jsp" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="ch"
							placeholder="Enter movie name">
						<button
							class="btn btn-primary ms-2 text-white col-md-3 badge rounded-pill">
							<i class="fa-solid fa-magnifying-glass"></i> Search
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="container p-4">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<p class="fs-4">Movie Description</p>
				<div class="card paint-card">
					<div class="card-body">

						<div class="row">
							<div class="col-md-4 p-3 bg-warning ">
								<img alt="" src="img/cinema.jpg" width="240px"
									style="margin-top: 50px">
							</div>

							<div class="col-md-8 ">
								<table class="table table-borderless">
									<%
									int id = Integer.parseInt(request.getParameter("id"));
									FilmDAO dao = new FilmDAO(DBConnect.getConnection());
									Film f = dao.getFilmById(id);
									%>
									<tbody>
										<tr>
											<th scope="row">Title</th>
											<th>:</th>
											<td><%=f.getTitle()%></td>
										</tr>
										<tr>
											<th scope="row">Release Year</th>
											<th>:</th>
											<td><%=f.getRelaseYear()%></td>
										</tr>
										<tr>
											<th scope="row">Length</th>
											<th>:</th>
											<td><%=f.getLength()%></td>
										</tr>
										<tr>
											<th scope="row">Rating</th>
											<th>:</th>
											<td><%=f.getRating()%></td>
										</tr>
										<tr>
											<th scope="row">Category</th>
											<th>:</th>
											<td>
												<%
												int cid = dao.getCategory(f.getFilmId());
												String categoryName = dao.getCategoryName(cid);
												out.print(categoryName);
												%>

											</td>
										</tr>
										<tr>
											<th scope="row">Description</th>
											<th>:</th>
											<td><%=f.getDescription()%></td>
										</tr>
										<tr>
											<th scope="row">Actors</th>
											<th>:</th>
											<td>
												<%
												List<FilmActor> list = dao.getActorId(f.getFilmId());
												for (FilmActor acid : list) {

													Actor ac = dao.getActorName(acid.getActorId());
													out.print(ac.getFirstName() + " " + ac.getLastName() + " , ");
												}
												%>
											</td>
										</tr>
									</tbody>
								</table>

							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>