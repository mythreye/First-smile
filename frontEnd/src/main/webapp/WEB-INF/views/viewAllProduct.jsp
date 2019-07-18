<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="cr3" value="${pageContext.request.contextPath}" />
<c:set var="cr1" value="${pageContext.request.contextPath}/user/" />
<c:set var="contextroot" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimage" />
<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#mytable').DataTable({
			"pagingType" : "simple_numbers",
			"lengthMenu" : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
			"ordering" : true,
			"searching" : false
		});
	})
	$(document).ready(function() {
		$("#editor").editor({
			uiLibrary : 'bootstrap'
		});
	});
</script>
<style>
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: white;
}

.category_block li:hover a {
	color: black;
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

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: line-through;
	font-size: 140%;
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

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}

footer {
	background: #343a40;
	padding: 40px;
}

footer a {
	color: #f8f9fa !important
}
</style>

<div class="container">

<c:if test="${msg}">
			<div class="alert alert-success">
				<strong>Product added to Wishlist.</strong>
			</div>
		</c:if>
	<div class="row">
		<div class="col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					 Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${Categories}" var="c">
					
						<li class="list-group-item"><a href="${cr3}/cateproduct?cid=${c.categoryid}">${c.categoryname}</a></li>
					</c:forEach>
						<li  class="list-group-item"><a href="${contextroot}/ViewAllProduct">All</a></li>

				</ul>
			</div>
		</div>
		<div class="col-sm-9">
			<div class="row">
			<c:if test="${empty(allProduct)}">
			<div class="jumbotron">
				<h1>Product</h1>
				<p>No Products here</p>
				

			</div>
		</c:if>
		<c:if test="${!empty(allProduct)}">
				<c:forEach items="${allProduct}" var="p">
					<div class="col-sm-4" style="margin-top: 3%; min-height: 400px;">
						<div class="card text-center">
							<img height="200" align="middle"
								src="${CR}/${p.productId}.jpg"
								alt="Card image cap">
							<div class="card-body">
								<h4 class="text-center">
									<a href="" title="View Product">${p.productName }</a>
								</h4>
								<h4 class="text-center">&#8377; ${p.productPrice}</h4>
								<div class="row" style="padding-bottom:0">
									<div class="col-sm-5">
									<c:if test="${!empty(wishlist)}">
									
										<c:forEach items="${wishlist}" var="w">
										
										<c:if test="${w.productid.productId==p.productId}">
										<a title="" href="${cr3}/removewishlist?id=${p.productId}" class="btn btn-outline-success"
											data-toggle="tooltip" data-original-title="Save to Wishlist">
											<i class="fa fa-heart bold"></i>
										</a>
										</c:if>
										<c:if test="${w.productid.productId!=p.productId}">
										<a title="" href="${cr1}/addwishlist?id=${p.productId}" class="btn btn-outline-success"
											data-toggle="tooltip" data-original-title="Save to Wishlist">
											<i class="fa fa-heart"></i>
										</a>
										</c:if>
										</c:forEach>
										</c:if>
										<c:if test="${empty(wishlist)}">
										<a title="" href="${cr1}/addwishlist?id=${p.productId}" class="btn btn-outline-success"
											data-toggle="tooltip" data-original-title="Save to Wishlist">
											<i class="fa fa-heart"></i>
										</a>
										</c:if>
										
									</div>
									<div class="col-sm-5">
										<c:if test="${p.prouctQuantity !=0}">
										<a href="${cr3}/viewProduct?id=${p.productId}"
											class="btn btn-success btn-block">View Detail</a>
										</c:if>
										<c:if test="${p.prouctQuantity ==0}">
										<a 
											class="btn btn-success">Out Of Stock</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</div>
