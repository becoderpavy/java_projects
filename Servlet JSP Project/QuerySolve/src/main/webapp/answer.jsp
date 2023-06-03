<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answer Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger" role="alert">${failedMsg }</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>

	<div class="container-fluid">
		<div class="row">
			<%@include file="all_component/categories.jsp"%>

			<div class="col-md-9 p-">
				<div class="card">
					<div class="card-body">

						<h5>${query.question }</h5>

						<c:if test="${not empty query.img }">
							<div class="text-center">
								<img alt="" src="img/${query.img }"
									style="width: 200px; height: 200px;">
							</div>
						</c:if>

						<p>${query.description}</p>

						<div class="row p-2">
							<p class="text-danger border p-1 border-warning">Categories:
								${query.categories}</p>
							<p class="text-danger ml-3 border p-1 border-warning">Post
								By: ${query.username }</p>
							<p class="text-danger ml-3 border p-1 border-warning">Date:
								${query.postDate }</p>
						</div>


						<div class="card">
							<div class="card-header chead">
								<c:if test="${not empty userobj }">
									<h5>
										<i class="fas fa-user-circle"></i> ${userobj.fullName }
									</h5>
								</c:if>

								<c:if test="${empty userobj }">
									<h5>
										<i class="fas fa-user-circle"></i> <a href="login.jsp">Login</a>
									</h5>
								</c:if>

							</div>
							<div class="card-body">
								<form action="add_answer" method="post">
									<input type="hidden" value="${query.id}" name="quesId">

									<input type="hidden" value="${userobj.fullName}"
										name="username">

									<div class="form-group">
										<textarea rows="4" cols="" placeholder="Write your answer"
											class="form-control" name="ques" required="required"></textarea>
									</div>
									<button class="btn btn-primary btn-sm">Submit</button>
								</form>
							</div>


						</div>


						<hr>

						<c:forEach var="a" items="${requestScope.ans}">
							<div>
								<h5 class="text-primary">
									<i class="fas fa-user-circle"></i> ${a.userName }
								</h5>
								<p class="text-success">Answered ${a.post_date}</p>
								<p>${a.answer}</p>
							</div>
							<hr>
						</c:forEach>

					</div>
				</div>



			</div>

		</div>
	</div>
	<div style="margin-top: 200px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>