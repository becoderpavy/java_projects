<%@page import="com.entites.Resume"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.ResumeDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../all_component/allcss.jsp"%>
<style type="text/css">
.borderless td, .borderless th {
	border: none;
}

.card-shodow {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
	transition: box-shadow 0.3s ease-in-out;
}
</style>
</head>
<body>
	<%@include file="../all_component/admin_navbar.jsp"%>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	ResumeDAO dao = new ResumeDAO(DBConnect.getConn());
	Resume r = dao.getResumeById(id);
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-shodow">
					<div class="card-body">

						<h4 class="text-center">View Resume</h4>
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="addResume" enctype="multipart/form-data"
							method="post">
							<table class="table borderless">
								<tr>
									<td class="font-weight-bold text-primary" colspan="2">Personal
										Information</td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">First Name</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getFirstName()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Middle Name</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getMiddleName()%></td>
								</tr>
								<tr class="p-3">
									<td class="font-weight-bold">Last Name</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getLastName()%></td>
								</tr>
								<tr class="p-3">
									<td class="font-weight-bold">Address</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getAddress()%></td>
								</tr>
								<tr class="p-3">
									<td class="font-weight-bold">DOB</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getDob()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Gender</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getGender()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Marital Status</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getMaritalStatus()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Phone Number</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getPhoneNumber()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Email</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getEmail()%></td>
								</tr>
								<tr>
									<td class="font-weight-bold text-primary" colspan="2">Educational
										Qualification Information</td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Qualification</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getQualification()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Institute</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getInstitute()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Year of Graduation</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getYearOfGraduation()%></td>
								</tr>
								<tr>
									<td class="font-weight-bold text-primary" colspan="2">Work
										Experience Information</td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Previous Employer</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getPreviousEmployer()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Previous Designation</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getPreviousDesignation()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Current Employer</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getCurrentEmployer()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Current Designation</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getCurrentDesignation()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Total Experience</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getTotalExperience()%></td>
								</tr>
								<tr class="p-3">
									<td class="font-weight-bold">Skill</td>
									<td class="font-weight-bold">:</td>
									<td><%=r.getSkill()%></td>
								</tr>

								<tr class="p-3">
									<td class="font-weight-bold">Download Resume</td>
									<td class="font-weight-bold">:</td>
									<td><a
										href="../downloadFile?fileName=<%=r.getResumeFileName()%>"
										class="btn btn-sm btn-primary">Download</a></td>
								</tr>


							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>