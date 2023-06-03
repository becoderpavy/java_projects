<%@page import="com.entites.Film"%>
<%@page import="java.util.List"%>

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
				<%
				String ch = request.getParameter("ch");
				FilmDAO dao = new FilmDAO(DBConnect.getConnection());
				List<Film> list = dao.getFilmBySearch(ch);
				%>
				<p class="fs-4">
					Search Results for
					<%=ch%></p>
				<div class="card paint-card">
					<div class="card-body">

						<table class="table">
							<thead>

								<tr>
									<th scope="col">Title</th>
									<th scope="col">Relase Year</th>
									<th scope="col">Rating</th>
									<th scope="col">length</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (Film f : list) {
								%>
								<tr>
									<th scope="row"><a
										href="movie_details.jsp?id=<%=f.getFilmId()%>"
										class="text-decoration-none"><%=f.getTitle()%></a></th>
									<td><%=f.getRelaseYear()%></td>
									<td><%=f.getRating()%></td>
									<td><%=f.getLength()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>