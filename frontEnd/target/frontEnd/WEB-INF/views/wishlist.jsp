<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
	<div class="row">
		<c:if test="${empty(wishList)}">
			<div class="jumbotron">
				<h1>WishList</h1>
				<p>No Items</p>
				<a href="ViewAllProduct" class="btn btn-default"> <span
					class="glyphicon glyphicon-heart"></span>Add more Items to Wishlist 
				</a>

			</div>
		</c:if>
		<c:if test="${!empty(wishList)}">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Seller</th>
							<th class="text-center">Price</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${wishList}" var="c">
							<tr>
								<form action="edititem?itemid=${c.wishlistid}" method="post">
									<td class="col-sm-8 col-md-6">
										<div class="media">
											<a class="thumbnail pull-left" href="#"> <img
												class="media-object"
												src="resources/productimage/${c.productid.productId}.jpg"
												style="width: 72px; height: 72px;">
											</a>
											<div class="media-body" style="padding-left: 2%;">
												<h4 class="media-heading">
													<a href="#">${c.productid.productName}</a>
												</h4>
												
												<h5 class="media-heading">
													by <a href="#">${c.productid.mycategory.categoryname}</a>
												</h5>
												
												

											</div>
										</div>
									</td>
									<td><h5 class="media-heading">
													${c.productid.myseller.sellername}
												</h5>
									</td>
									
									<td class="col-sm-1 col-md-1 text-center"><strong>${c.productid.productPrice}</strong></td>
									
								</form>
							</tr>
						</c:forEach>

						
					</tbody>
				</table>
			</div>

		</c:if>

	</div>
</div>