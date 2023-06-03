$(function() {
	var $shopreg = $("#shopreg");
	$shopreg.validate({
		rules: {

			on: {
				required: true,
				lettersonly: true
			},
			sn: {
				required: true,
			}
			,
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

			}, ad: {
				required: true

			},
			ci: {
				required: true,
				lettersonly: true


			},
			sta: {
				required: true,
				lettersonly: true

			},
			psd: {
				required: true,
				space: true

			},
			cpwd: {
				required: true,
				space: true,
				equalTo: '#pwd'

			},
			img: {
				required: true
			}

		},
		messages: {
			on: {
				required: "full name must be required",
				lettersonly: "invalid name"
			},
			sn: {
				required: "Shop name must be required",
			}
			,
			em: {
				required: "email must be required",
				space: "space not allowed",
				email: "invalid email"
			},
			phno: {
				required: "phone number must be required",
				space: true,
				numericOnly: "invalid phone number",
				minlength: "min 10 digit",
				maxlength: "max 12 digit"

			}, ad: {
				required: "address must be required"

			},
			ci: {
				required: "city must be required",
				lettersonly: "invalid city",
				space: "space not allowed"

			},
			sta: {
				required: "state must be required",
				lettersonly: "invalid state",
				space: "space not allowed"

			},
			psd: {
				required: "password must be required",
				space: "space not allowed"

			},
			cpwd: {
				required: "confirm password must be required",
				space: "space not allowed",
				equalTo: "password mismatch"

			},
			img: {
				required: "image must be required"
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












