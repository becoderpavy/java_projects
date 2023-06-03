$("#category").change(
		function() {
			var enteredCategory = $("#category").val();
			$.ajax({
				method : "GET",
				url : "getAllReg",
				data : {
					cat : enteredCategory
				},

				success : function(res) {
					// console.log(res);

					var html = '<option value="">--select--</option>';
					var len = res.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + res[i].registrationNumber
								+ '">' + res[i].registrationNumber
								+ '</option>';
					}
					html += '</option>';
					$('#reg').html(html);

				}
			});
		});

$(document).ready(function() {
	var dtToday = new Date();

	var month = dtToday.getMonth() + 1;
	var day = dtToday.getDate();
	var year = dtToday.getFullYear();
	if (month < 10)
		month = '0' + month.toString();
	if (day < 10)
		day = '0' + day.toString();
	var maxDate = year + '-' + month + '-' + day;
	$('#inputdate').attr('min', maxDate);
	$('#inputdate2').attr('min', maxDate);

	$("#inputdate,#inputdate2").change(function() {
		var dtFrm = $("#inputdate").val();
		var dtTo = $("#inputdate2").val();

		if (dtFrm && dtTo) {

			var nm = $("#customerName").val();
			var category = $("#category").val();
			var regNum = $("#reg").val();

			$.ajax({
				method : "GET",
				url : "getTotalRent",
				data : {
					reg : regNum,
					dtFrm : dtFrm,
					dtTo : dtTo
				},

				success : function(res) {
					console.log(res);

					$('#tamt').val(res);
				}
			});
		}

	});

});

$('#add_book').on('submit', function(e) {
	e.preventDefault();
	$('#name_error').html('');
	$('#category_error').html('');
	$('#regnum_error').html('');
	$('#dtFrom_error').html('');
	$('#dtTo_error').html('');

	var customerName = $('#customerName').val();
	var category = $('#category').val();
	var reg = $('#reg').val();
	var dtFrom = $('#inputdate').val();
	var dtTo = $('#inputdate2').val();
	var totalAmt = $('#tamt').val();
	var advance = '';

	if ($("#advance").is(':checked')) {
		console.log("check");
		advance = 'Yes';
	} else {
		console.log("not check");
		advance = 'No';
	}

	if ($('#customerName').val() == "") {
		$('#name_error').html('Required Customer Name');
	} else if ($('#category').val() == "") {
		$('#category_error').html('Category Required');
	} else if ($('#reg').val() == "") {
		$('#regnum_error').html('Registration Number Required.');
	} else if ($('#inputdate').val() == "") {
		$('#dtFrom_error').html('Book Date required.');
	} else if ($('#inputdate2').val() == "") {
		$('#dtTo_error').html('End Date Required');
	}

	else {
		console.log("Ok");

		$.ajax({
			url : "addBook",
			method : "POST",
			data : {
				cn : customerName,
				ca : category,
				re : reg,
				df : dtFrom,
				dt : dtTo,
				ta : totalAmt,
				ad : advance
			},
			success : function(res) {
				$('#msg').html(res);
				$('#customerName').val('');
				$('#category').val('') ;
				$('#reg').val('');
				$('#inputdate').val('');
				$('#inputdate2').val('');
				$('#tamt').val('');

			},
			error : function(textStatus, errorThrown) {
				$('#msg').html('Something wrong on server');
			}

		});

	}
})
