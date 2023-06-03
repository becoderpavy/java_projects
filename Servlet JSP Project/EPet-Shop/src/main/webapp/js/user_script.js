$(function() {
	var $UserregisterForm = $("#userRegister");
	$UserregisterForm.validate({
		rules: {

			na: {
				required: true,
				lettersonly: true
			},
			em: {
				required: true,
				space: true,
				email: true
			},
			phno: {
				required: true,
				space: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12

			},
			pwd: {
				required: true,
				space: true

			},
			cpwd: {
				required: true,
				space: true,
				equalTo: '#psw'

			}

		},
		messages: {
			na: {
				required: 'full name must be required',
				lettersonly: 'invalid name'
			},
			em: {
				required: 'email name must be required',
				space: 'space not allowed',
				email: 'Invalid email'
			},
			phno: {
				required: 'mob no must be required',
				space: 'space not allowed',
				numericOnly: 'invalid mob no',
				minlength: 'min 10 digit',
				maxlength: 'max 12 digit'
			},

			pwd: {
				required: 'password must be required',
				space: 'space not allowed'

			},
			cpwd: {
				required: 'confirm password must be required',
				space: 'space not allowed',
				equalTo: 'password mismatch'

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












