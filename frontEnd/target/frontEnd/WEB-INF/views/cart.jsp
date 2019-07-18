<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="row">
		<c:if test="${empty(cartList)}">
			<div class="jumbotron">
				<h1>Cart Page</h1>
				<p>No Items</p>
				<a href="ViewAllProduct" class="btn btn-default"> <span
					class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
				</a>

			</div>
		</c:if>
		<c:if test="${!empty(cartList)}">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartList}" var="c">
							<tr>
								<form action="edititem?itemid=${c.itemid}" method="post">
									<td class="col-sm-8 col-md-6">
										<div class="media">
											<a class="thumbnail pull-left" href="#"> <img
												class="media-object"
												src="resources/productimage/${c.product.productId}.jpg"
												style="width: 72px; height: 72px;">
											</a>
											<div class="media-body" style="padding-left: 2%;">
												<h4 class="media-heading">
													<a href="#">${c.product.productName}</a>
												</h4>
												<h5 class="media-heading">
													by <a href="#">${c.product.myseller.sellername}</a>
												</h5>
												<h5 class="media-heading">
													by <a href="#">${c.product.mycategory.categoryname}</a>
												</h5>
												<c:if test="${c.product.prouctQuantity>0}">

													<span>Status: </span>
													<span class="text-success"><strong>In Stock</strong></span>
												</c:if>
												
												<c:if test="${c.product.prouctQuantity==0}">
													<span>Status: </span>
													<span class="text-success"><strong>Out
															Stock</strong></span>
												</c:if>
												
												<c:if test="${error && proid==c.product.productId}">

													<h4 class="text-warning">
														<strong>Qty cannot be greater than 5</strong>
													</h4>
												</c:if>
												<c:if test="${msg && proid==c.product.productId}">

													<h4 class="text-warning">
														<strong>Recuire quantiity is out of stock</strong>
													</h4>
												</c:if>

											</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1" style="text-align: center"><input
										type="number" class="form-control" id="upqty" name="upqty"
										value="${c.quantity}" min="1" ></td>
									<td class="col-sm-1 col-md-1 text-center"><strong>${c.product.productPrice}</strong></td>
									<td class="col-sm-1 col-md-1 text-center"><strong>${c.totalprice}</strong></td>
									<td class="col-sm-1 col-md-1"><a
										href="removeitem?itemid=${c.itemid}" class="btn btn-danger">
											<span class="glyphicon glyphicon-remove"></span>
									</a>
									<button type="submit" class="btn button">
											<span class="glyphicon glyphicon-refresh"></span>
										</button></td>
								</form>
							</tr>
						</c:forEach>

						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h3>Total</h3></td>
							<td class="text-right"><h3>
									<strong>${total}</strong>
								</h3></td>
						</tr>
						<tr>
							<td>  <a href="ViewAllProduct" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Continue Shopping
							</a>
							</td>
							<td> </td>
							<td> </td>
							<td></td>
							<td>
								<a href="shippingAddress" class="btn btn-success">
									 <span class="glyphicon glyphicon-play"></span>
									 Checkout
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</c:if>

	</div>
</div>