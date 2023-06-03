$(function() {
	var $UserregisterForm = $("#register");
	$UserregisterForm.validate({
		rules: {

			fn: {
				required: true,
				lettersonly: true
			},
			ln: {
				required: true,
				lettersonly: true
			},
			em: {
				required: true,
				space: true,
				email: true
			},
			ph: {
				required: true,
				space: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12
			},
			adh: {
				required: true,
				space: true,
				numericOnly: true,
				minlength: 15,
				maxlength: 16

			},
			add: {
				required: true,
			},
			city: {
				required: true,
			},
			st: {
				required: true,
			},
			zip: {
				required: true,
			},
			check: {
				required: true,
			}
		},
		messages: {
			fn: {
				required: 'full name must be required',
				lettersonly: 'invalid name'
			},
			ln: {
				required: 'last name required',
				lettersonly: 'invalid name'
			},
			em: {
				required: 'email name must be required',
				space: 'space not allowed',
				email: 'Invalid email'
			},
			ph: {
				required: 'mob no e required',
				space: 'space not allowed',
				numericOnly: 'invalid mob no',
				minlength: 'min 10 digit',
				maxlength: 'max 12 digit'
			},
			adh: {
				required: 'Adhar num required',
				space: 'space not allowed',
				numericOnly: 'invalid Adhar',
				minlength: 'min 15 digit',
				maxlength: 'max 16 digit'
			},
			add: {
				required: 'address must be required',
			},
			city: {
				required: 'city must be required',
			},
			st: {
				required: 'state required',
			},
			zip: {
				required: 'pincode required',
			},
			check: {
				required: 'check be required',
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












