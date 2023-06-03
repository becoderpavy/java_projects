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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h5 id="msg"></h5>
						<form id="myform">
							<div class="mb-3 input-field">
								<label>Country</label> <select id="country">
									<option>-- country--</option>
								</select>
							</div>

							<div class="mb-3 input-field">
								<label>State</label> <select id="state">
									<option>-- State--</option>
								</select>
							</div>

							<div class="mb-3 input-field">
								<label>City</label> <select id="city">
									<option>-- city--</option>
								</select>
							</div>
							<input type="time" name="fn" id="fn">
								<input type="time" name="ln" id="ln">
							 <button id="submit" class="btn btn-primary">ok</button> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.ajax({
										url : "GetCountryStateservlet",
										method : "GET",
										data : {
											operation : 'country'
										},
										success : function(data, textStatus,
												jqXHR) {

											let obj = $.parseJSON(data);

											$.each(obj, function(key, value) {
												$('#country').append(
														'<option value="'+ value.id+'">'
																+ value.name
																+ '</option>')
											})
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											$('#country')
													.append(
															'<option>country not availble</option>')
										},
										cache : false
									});

							 $('#country').change(function(){
								
								$('#state').find('option').remove();
								 
								$('#state').append('<option>select state</option>');
								$('#city').find('option').remove();
								$('#city').append('<option>select city</option>');
								
								let cid=$('#country').val();
								let data={
										operation:"state",
										id:cid
								};
								
								 $.ajax({
									url: "GetCountryStateservlet",
									method: "GET",
									data:data,
									success:function(data,textStatus,jqXHR){
										
										let obj=$.parseJSON(data);
										$.each(obj,function(key,value){
											$('#state').append('<option value="'+value.id+'" >'+value.name+'</option>');
										})
									},
								error:function(jqXHR,textStatus,errorThrown){
									$('#state').append('<option>state not availble</option>')
								},
								cache:false
								
							}); 	
							}); 

				$('#state').change(function(){
					$('#city').find('option').remove();
					$('#city').append('<option>select city</option>');
					
					let sid=$('#state').val();
					let data={
						operation:"city",
						id:sid
					};
					
					$.ajax({
						url: "GetCountryStateservlet",
						method: "GET",
						data:data,
						success:function(data,textStatus,jqXHR){
							/* console.log(data);
							console.log(textStatus);
							console.log(jqXHR); */
							let obj=$.parseJSON(data);
							$.each(obj,function(key,value){
								$('#city').append('<option value="'+value.id+'">'+value.name+'</option>')
							})
						},
						error:function(jqXHR,textStatus,errorThrown){
							$('#state').append('<option>state not availble</option>')
						},
						cache:false
					})
					
					
				})
							 
			/* $('#myform').click(function(){
				alert("success");
			})	 */	
			
			$('#myform').on('submit',function(event){
				event.preventDefault();
				
				let coid=$('#country').val();
				let sid=$('#state').val();
				let cid=$('#city').val();
				let fn=$('#fn').val();
				let ln=$('#ln').val();
				
				
				let data={
						coid:coid,
						sid:sid,
						cid:cid,
						fn:fn,
						ln:ln
				}
				
				$.ajax({
					url:'save',
					data:data,
					type:'POST',
					success:function(data,textStatus,jqXHR){
						console.log(data);
						//window.location.href='register.jsp?data='+data;
						$("#msg").text(data);
						
					},
					error:function(jqXHR,textStatus,errorThrown){
						console.log(errorThrown)
					}
				})
				
			})
			})
	</script>
</body>
</html>