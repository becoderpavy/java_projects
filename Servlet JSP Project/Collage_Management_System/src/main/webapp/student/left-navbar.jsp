<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div class="sidebar">
	
		<span class="crossBtn text-white" onclick="toogleSidebar()">&times;</span> 
		
		<div class="container text-center text-white">
		<i class="fas fa-user-circle fa-5x"></i>
		<h6>Student</h6>
		</div>
			<div class="divider"></div>
		<a href="home.jsp" class="item"><i class="fas fa-home"></i> Home</a>  
			
		<a href="view_profile.jsp" class=""><i class="fas fa-user"></i> Profile</a> 
		
		<a href="edit_profile.jsp" class=""><i class="fas fa-pencil-alt"></i> Edit Profile</a> 
			
		<a href="view_attend.jsp?id=${sobj.id}" class="item"><i class="fas fa-user-circle"></i> Attendence</a> 
			
		<a href="result.jsp" class="item"><i class="fas fa-poll-h"></i> Result</a> 
		
		<a href="view_notice.jsp" class="item"><i class="fas fa-cogs"></i> Notice</a> 

		<div class="divider"></div>
	</div>