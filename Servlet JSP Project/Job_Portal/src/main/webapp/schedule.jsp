<%@page import="com.entity.Candidates"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.CandidateDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-5">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Schedule Interview Date</h4>

						<%
						int id = Integer.parseInt(request.getParameter("cid"));
						CandidateDAO dao = new CandidateDAO(DBConnect.getConn());
						Candidates c = dao.getCandidatesById(id);
						%>

						<form action="schedule.jsp" method="post">

							<div class="form-group">
								<label>Candidates Name</label> <input type="text"
									readonly="readonly" required="required" class="form-control"
									name="name" value="<%=c.getName()%>">
							</div>
							<div class="form-group">
								<label>Interview Date</label> <input required="required"
									type="date" class="form-control" name="date">
							</div>

							<input type="hidden" name="cid" value="<%=id%>">

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	
	String date = request.getParameter("date");
	
	if( date!=null)
	{
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		boolean f=dao.scheduleInterview(cid, date);
		if(f)
		{
			session.setAttribute("succMsg", "Interview Date Schedule Sucessfully");
			response.sendRedirect("candidates.jsp");
		}else{
			session.setAttribute("errorMsg", "something wrong on server");
			response.sendRedirect("candidates.jsp");
		}
		
	}
	
	%>
</body>
</html>