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
			dob : {
				required : true,
			},
			mobNo : {
				required : true,
				space : true,
				numericOnly : true,
				minlength : 10,
				maxlength : 12

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
			confirmpassword : {
				required : true,
				space : true,
				equalTo : '#psw'

			},
			role : {
				required : true
			},

			address : {
				required : true,
				all : true

			},
			city : {
				required : true,
			},
			state : {
				required : true,
			},
			pincode : {
				required : true,
				numericOnly : true,
				minlength : 5,
				maxlength : 6
			},
			img : {
				required : true,
			},
			experience : {
				required : true
			},
			specialization : {
				required : true
			}

		},
		messages : {
			firstName : {
				required : 'full name must be required',
				lettersonly : 'invalid name'

			},
			lastName : {
				required : "last name must be required",
				lettersonly : "invalid name"
			},
			dob : {
				required : "date of birth must be required"
			},
			mobNo : {
				required : 'mob no must be required',
				space : 'space not allowed',
				numericOnly : 'invalid mob no',
				minlength : 'min 10 digit',
				maxlength : 'max 12 digit'
			},

			experience : {
				required : "experience must be required"
			},
			specialization : {
				required : "specialization must be required"
			},
			email : {
				required : 'email name must be required',
				space : 'space not allowed',
				email : 'Invalid email'
			},

			password : {
				required : 'password must be required',
				space : 'space not allowed'

			},
			confirmpassword : {
				required : 'confirm password must be required',
				space : 'space not allowed',
				equalTo : 'password mismatch'

			},
			role : {
				required : "Role must be required"
			},
			address : {
				required : 'address must be required',
				all : 'invalid'

			},
			city : {
				required : "city must be required"
			},
			state : {
				required : "state must be required"
			},
			pincode : {
				required : "pincode must be required",
				numericOnly : 'invalid pincode'
			},
			img : {
				required : "image must be required",
				minlength : 'min 5 digit',
				maxlength : 'max 6 digit'
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
