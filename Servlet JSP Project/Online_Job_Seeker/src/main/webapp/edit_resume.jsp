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
<%@include file="all_component/allcss.jsp"%>
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
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-shodow">
					<div class="card-body">
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						ResumeDAO dao = new ResumeDAO(DBConnect.getConn());
						Resume r = dao.getResumeById(id);
						%>
						<h4 class="text-center">Edit Resume</h4>
						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="updateResume" method="post">
							<input type="hidden" name="id" value="<%=r.getId()%>">
							<table class="table borderless">
								<tr>
									<td class="font-weight-bold" colspan="2">Personal
										Information</td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">First Name :</td>
									<td><input name="firstName" value="<%=r.getFirstName()%>"
										class="form-control form-control-sm" required type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Middle Name :</td>
									<td><input name="middleName"
										value="<%=r.getMiddleName()%>"
										class="form-control form-control-sm" type="text"></td>
								</tr>
								<tr class="p-3">
									<td class="fw-bold">Last Name :</td>
									<td><input name="lastName" value="<%=r.getLastName()%>"
										class="form-control form-control-sm" required type="text"></td>
								</tr>
								<tr class="p-3">
									<td class="fw-bold">Address :</td>
									<td><input name="address" value="<%=r.getAddress()%>"
										class="form-control form-control-sm" required type="text"></td>
								</tr>
								<tr class="p-3">
									<td class="fw-bold">DOB :</td>
									<td><input value="<%=r.getDob()%>" name="dob"
										class="form-control form-control-sm" required type="date"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Gender :</td>
									<td><div class="form-check form-check-inline ml-3">
											<input class="form-check-input" type="radio" name="gender"
												required id="inlineRadio1" value="Male"> <label
												class="form-check-label" for="inlineRadio1">Male</label>
										</div>
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio" name="gender"
												required id="inlineRadio2" value="Female"> <label
												class="form-check-label" for="inlineRadio2">Female</label>
										</div></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Marital Status :</td>
									<td><select name="maritalStatus" class="form-control"
										required>
											<option><%=r.getMaritalStatus()%></option>
											<option>Married</option>
											<option>Single</option>
											<option>Student</option>
									</select></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Phone Number :</td>
									<td><input value="<%=r.getPhoneNumber()%>"
										name="phoneNumber" class="form-control form-control-sm"
										required type="number"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Email :</td>
									<td><input value="<%=r.getEmail()%>" name="email"
										class="form-control form-control-sm" required type="email"></td>
								</tr>
								<tr>
									<td class="font-weight-bold" colspan="2">Educational
										Qualification Information</td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Qualification :</td>
									<td><input value="<%=r.getQualification()%>"
										name="qualification" class="form-control form-control-sm"
										required type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Institute :</td>
									<td><input value="<%=r.getInstitute()%>" name="institute"
										class="form-control form-control-sm" required type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Year of Graduation :</td>
									<td><input value="<%=r.getYearOfGraduation()%>"
										name="yearOfGraduation" class="form-control form-control-sm"
										type="text"></td>
								</tr>
								<tr>
									<td class="font-weight-bold" colspan="2">Work Experience
										Information</td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Previous Employer :</td>
									<td><input value="<%=r.getPreviousEmployer()%>"
										name="previousEmployer" class="form-control form-control-sm"
										type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Previous Designation:</td>
									<td><input value="<%=r.getPreviousDesignation()%>"
										name="previousDesignation"
										class="form-control form-control-sm" type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Current Employer :</td>
									<td><input value="<%=r.getCurrentEmployer()%>"
										name="currentEmployer" class="form-control form-control-sm"
										type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Current Designation :</td>
									<td><input value="<%=r.getCurrentDesignation()%>"
										name="currentDesignation" class="form-control form-control-sm"
										type="text"></td>
								</tr>

								<tr class="p-3">
									<td class="fw-bold">Total Experience :</td>
									<td><input value="<%=r.getTotalExperience()%>"
										name="totalExperience" class="form-control form-control-sm"
										type="text"></td>
								</tr>
								<tr class="p-3">
									<td class="fw-bold">Skill :</td>
									<td><input value="<%=r.getSkill()%>" name="skill"
										class="form-control form-control-sm" type="text"></td>
								</tr>

								<!-- <tr class="p-3">
									<td class="fw-bold">Upload Resume :</td>
									<td><input required name="resume"
										class="form-control form-control-sm" type="file"></td>
								</tr> -->
								<tr>
									<td colspan="2"><input type="hidden" name="userId"
										value="${userObj.id }"></td>
								</tr>
								<tr>
									<td colspan="2">
										<button class="btn btn-primary col-md-12">Update
											Resume</button>
									</td>
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