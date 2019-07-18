<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script src='resources/js/jquery.zoom.js'></script>
<script>
	
	function increament_price()
	{
		//document.getElementById('price').innerHTML="";
		var price = document.getElementsByName('product_price')[0].value;
		var qty = document.getElementsByName('quantity')[0].value ;
		
		if(qty>=5)
			{
			//alert("You cant add more than 5 products.");
			document.getElementById('error').style.display = 'block';
			document.getElementById('error').innerHTML  = "Qty cannot be greater than 5" ;
			}
		else
			{
			document.getElementById('error').style.display = 'none';
			document.getElementsByName('quantity')[0].value  = parseInt(qty)+1;
			var totalprice = parseFloat(price) * (parseInt(qty)+1)
			document.getElementById('total').innerHTML  = totalprice ;
			}
		
	}
	function decreament_price()
	{
		var price = document.getElementsByName('product_price')[0].value;
		var qty = document.getElementsByName('quantity')[0].value ;
		
		if(qty<=1)
			{
			document.getElementById('error').style.display = 'block';
			document.getElementById('error').innerHTML  = "Qty must be 1" ;
			}
		else
			{
			document.getElementById('error').style.display = 'none';
			document.getElementsByName('quantity')[0].value  = parseInt
			document.getElementsByName('quantity')[0].value  = parseInt(qty)-1;
			var totalprice = parseFloat(price) * (parseInt(qty)-1)
			document.getElementById('total').innerHTML  = totalprice ;
			}
		
	}
</script>
<style>
.zoom {
	display: inline-block;
	position: relative;
}

.zoom:after {
	content: '';
	display: block;
	width: 33px;
	height: 33px;
	position: absolute;
	top: 0;
	right: 0;
	background: url(icon.png);
}

.zoom img {
	display: block;
}

.zoom img::selection {
	background-color: transparent;
}

.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}
.rupee {
    background-position:left;
    width: 10px;
    height: 14px;
    background-image: url('http://i.stack.imgur.com/vJZ9m.png');
    display:block;
    background-repeat: no-repeat;
}
</style>
<c:set value="${myProduct}" var="p"></c:set>
<div class="container" style="padding-left: 5%;margin-left: 20%" >
	<div class="row">
		<!-- Image -->
		<div class="col-sm-3">
			<div>
				<div class="thumbnail zoom" id="ex1">
					<img class="img-fluid" id="imgSmile"
						src="resources/productimage/${p.productId}.jpg" />
				</div>
			</div>
		</div>

		<div class="col-sm-5 add_to_cart_block">
			<div class="thumbnail">
			<div class="row">		
			<strong><div class="alert alert-danger" id="error" style="display:none"></div></strong>
			</div>
				<div class="row" id="price">
					<div  class="price" >&#8377; <span id="total"> ${p.productPrice}</span></div>
					<input type="hidden" name="product_price" id="product_price" value="${p.productPrice}"> 
				</div>
				<div class="row">
					<div class="col-sm-3">
						<label>Quantity :</label>
					</div>
					<div class="col-sm-1">
						<a class="btn-minus btn btn-danger btn-number" onclick='decreament_price()'> <i
							class="fa fa-minus"></i></a>
					</div>
					<div class="col-sm-4">
						<input type="text" class="form-control text-center" id="quantity"
							name="quantity" min="1"  value="1" >
					</div>
					<div class="col-sm-1" style="margin-left: -6%">
						<a class="btn-plus btn btn-success btn-number" onclick='increament_price()'> <i
							class="fa fa-plus"></i>
						</a>
					</div>
				</div>
			</div>
			<a href="addCart?pid=${p.productId}"
				class="btn btn-success btn-lg btn-block text-uppercase"> <i
				class="fa fa-shopping-cart"></i> Add To Cart
			</a>
			<div class="product_rassurance">
				<ul class="list-inline">
					<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
						delivery</li>
					<li class="list-inline-item"><i
						class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
					<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />+33
						1 22 54 65 60</li>
				</ul>
			</div>


		</div>
	</div>

	<div class="row">
		<!-- Description -->
		<div class="col-sm-8">
			<div class="thumbnail border-light mb-3">
				<div class="thumbnail-header bg-primary text-white text-uppercase">
					<i class="fa fa-align-justify"></i> Description
				</div>
				<div class="thumbnail-body">
					<p class="thumbnail-text">${p.productDescription}</p>

				</div>
			</div>
		</div>
	</div>
</div>