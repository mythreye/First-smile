<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.bg-orange {
	background: #d8622b;
	color: #fff !important;
}

body {
	background: #fff;
}

img {
	width: 100%;
	max-height: 560px;
}

a {
	color: #696969;
}
</style>
<div class="container">

<c:if test="${empty(ordercart)}">
			<div class="jumbotron">
				<h1>Order List</h1>
				<p>No Items</p>
				

			</div>
		</c:if>
		<c:if test="${!empty(ordercart)}">
	<c:forEach items="${ordercart}" var="order">


		<div class="col-md-12">
			<div class="row mb-3">
				<div class="col-md-12">
					<div class="thumbnail">
						<div class="thumbnail-body">
							<div class="row">
								<div class="col-md-3">
									<img
										src="resources/productimage/${order.product.productId}.jpg"
										style="width: 172px; height: 172px;">
								</div>
								<div class="col-md-7">
									<h3>${order.orderId}</h3>
									<h4>${order.product.productName}</h4>
									<small>${order.date}</small>
								</div>
								<div class="col-md-2" style="margin-top: 3%">
									  <a href="viewReceipt?oid=${order.orderId}" class="btn btn-outline bg-orange"
										>View Receipt
									</a>
									
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>

	</c:if>



</div>