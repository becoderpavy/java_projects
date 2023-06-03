$(function() {
	var $UserregisterForm = $("#userRegister");
	$UserregisterForm.validate({
		rules : {

			name : {
				required : true,
				lettersonly : true
			},
			email : {
				required : true,
				space : true,
				email : true
			},

			password : {
				required : true,
				space : true

			},
			comfirmPassword : {
				required : true,
				space : true,
				equalTo : '#psw'

			},
			mobNo : {
				required : true,
				space : true,
				numericOnly : true,
				minlength : 10,
				maxlength : 12

			},
			primarySkill:{
				required : true,
			},
			experience:{
				required : true,
			},

			address : {
				required : true,
				all : true

			},
			companyName:{
				required : true
			}

		},
		messages : {
			name : {
				required : "name required",
				lettersonly : "latter only"
			},
			email : {
				required :"email required",
				space : "space not allowed",
				email : "invalid email"
			},

			password : {
				required : "password required",
				space : "space not allowed"

			},
			comfirmPassword : {
				required : "confirm password required",
				space : "space not allowed",
				equalTo : 'password mismatch'

			},
			mobNo : {
				required : "mob number required",
				space : "space not allowed",
				numericOnly : "mobile no only digit",
				minlength : "min 10 digit",
				maxlength : "max 12 digit"

			},
			primarySkill:{
				required : "primary skill required",
			},
			experience:{
				required : "experience required",
			},

			address : {
				required : "address required",
				all : "invalid "

			},
			companyName:{
				required : "company required required"
			}
		}
	})

	jQuery.validator.addMethod('lettersonly', function(value, element) {
		return /^[^-\s][a-zA-Z_\s-]+$/.test(value);
	});

	jQuery.validator.addMethod('space', function(value, element) {
		return /^[^-\s]+$/.test(value);
	});

	jQuery.validator.addMethod('all', function(value, element) {
		return /^[^-\s][a-zA-Z0-9_,.\s-]+$/.test(value);
	});

	jQuery.validator.addMethod('numericOnly', function(value, element) {
		return /^[0-9]+$/.test(value);
	});
})
