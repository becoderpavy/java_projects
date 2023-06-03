$(function() {
	var $UserregisterForm = $("#userRegister");
	$UserregisterForm.validate({
		rules : {

			firstName : {
				required : true,
				lettersonly : true
				
			},
			lastName : {
				required : true,
				lettersonly : true
			},
			course : {
				required : true,
			},
			gender : {
				required : true,
			},
			contactNo : {
				required : true,
				space : true,
				numericOnly : true,
				minlength : 10,
				maxlength : 12

			},
			address : {
				required : true,
				all : true

			},
			email : {
				required : true,
				space : true,
				email : true
			},
			password : {
				required : true,
				minlength : 8,
				maxlength:12,
				space : true,

			},
			confirmpassword : {
				required : true,
				space : true,
				equalTo : '#psw'

			}
		},
		messages : {
			firstName : {
				required : "firstname required",
				lettersonly : "invalid name",
				
			},
			lastName : {
				lettersonly : "invalid name"
			},
			course : {
				required : "course required",
			},
			gender : {
				required : "gender required",
			},
			contactNo : {
				required : "contact no required",
				space : "space not allowed",
				numericOnly : "number only",
				minlength : "min 10 digit",
				maxlength : "max 12 digit"

			},
			address : {
				required : "address required",
				all : "invalid",

			},
			email : {
				required : "email required",
				space : "space not allowed",
				email : "invalid email"
			},
			password : {
				required : "password required",
				space : "space not allowed",
				minlength : "min 8 character",
				maxlength : "max 12 character",

			},
			confirmpassword : {
				required : "confirm password required",
				space : "space not allowed",
				equalTo : 'Password mismatch'

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
