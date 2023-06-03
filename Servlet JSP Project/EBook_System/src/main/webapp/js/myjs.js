
/*form validation*/
(function() {
	'use strict';
	window.addEventListener('load', function() {
		// Get the forms we want to add validation styles to
		var forms = document.getElementsByClassName('needs-validation');
		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();

/*end form validation*/

/*cart add*/
function addCart(pid, pname, price) {
	let cart = localStorage.getItem("cart");

	if (cart == null) {
		let products = [];
		let product = { productId: pid, productName: pname, productQuan: 1, productPrice: price };
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product added 1st time");
		showToast("Product Added to cart");


	} else {
		let pcart = JSON.parse(cart);

		let oldProduct = pcart.find((item) => item.productId == pid);
		if (oldProduct) {
			//increase product quantity
			oldProduct.productQuan = oldProduct.productQuan + 1;

			pcart.map((item) => {
				if (item.productId == oldProduct.productId) {
					item.productQuan = oldProduct.productQuan;
				}
			})

			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product quantity increases");
			showToast(oldProduct.productName+" Quantity is Increase"+oldProduct.productQuan);

		} else {
			let product = { productId: pid, productName: pname, productQuan: 1, productPrice: price };
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product added");
			showToast("Product added to Cart");
		}
	}


}



//update cart

function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);

	if (cart == null || cart.length == 0) {
		console.log("card-empty");
		$(".cart-items").html("(0)");
		$(".mcard-body").html("<h4>Cart Doesn't have any item</h4>");
		$("#checkout-btn").addClass('disabled');
		//$("#checkout-btn").attr('disabled',false);
	}
	else {
		//there is some in cart to show
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);

	let table = `
	<table class='table'>
	<thead class='thead-light'>
	<tr>
	<th>Name</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Total Price</th>
	<th>Action</th>
	</tr>
	</thead>
	
	
	
	`;
		let totalPrice = 0;
		cart.map((item) => {

			table += `
		<tr>
		<td>${item.productName}</td>
		<td>${item.productPrice}</td>	
		<td>
		${item.productQuan}
		</td>
		<td>${item.productQuan * item.productPrice}</td>
		<td><button onclick='deleteItemFromcart(${item.productId})' class="btn btn-danger btn-sm">Remove</button></td>
		</tr>
			
		`
			totalPrice += item.productPrice * item.productQuan;
		})


		table = table + `
	<tr>
	<td colspan='5' class="text-right font-weight-bold text-primary mt-3" >Total Price: ${totalPrice}</td>
	</tr>
	</table>`

		$(".mcard-body").html(table);
		$("#checkout-btn").removeClass('disabled');
		//$("#checkout-btn").attr('disabled',false);
	}

}

//delete item
function deleteItemFromcart(pid) {
	let cart = JSON.parse(localStorage.getItem('cart'));

	let newCart = cart.filter((item) => item.productId != pid)

	localStorage.setItem('cart', JSON.stringify(newCart));
	
	
	
	updateCart();
	
	showToast("Item is remove from Cart");

}



//show toast
function showToast(content)
{
    $('#toast').addClass("display");
    $('#toast').html(content);
    setTimeout(()=>{
        $("#toast").removeClass("display");
    },2000)
}


$(document).ready(function() {
	updateCart()
})
