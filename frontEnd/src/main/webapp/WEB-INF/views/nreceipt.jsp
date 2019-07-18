<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr3" value="${pageContext.request.contextPath}/user"/>
<div class="modal-header text-center">
	<h4 class="modal-title w-100 font-weight-bold">View Order -
		${orderDetail.orderId}</h4>
	
</div>
<div class="modal-body">
	<div class="container" style="width: 80%">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-body p-0">
						<div class="row p-5">
							
							<div class="col-md-6 left">
								<p class="font-weight-bold mb-1">Invoice
									#${orderDetail.orderId}</p>
								<p class="text-muted">${orderDetail.date}</p>
							</div>
						</div>

						<hr class="my-5">

						<div class="row pb-5 p-5">
							<div class="col-md-6">
								<p class="font-weight-bold">Client Information</p>
								<p class="mb-1">${orderDetail.customer.customername}</p>
								<p>${orderDetail.address.addreeline1},${orderDetail.address.addressline2}</p>
								<p class="mb-1">${orderDetail.address.city}
									,${orderDetail.address.state}</p>
								<p class="mb-1">${orderDetail.address.pincode}</p>
							</div>

							<div class="col-md-6 text-right">
								<p class="font-weight-bold mb-4">Seller Details</p>
								<p class="mb-1">
									<span class="text-muted">${orderDetail.product.myseller.sellername}</span>
								</p>
								<p class="mb-1">
									<span class="text-muted">${orderDetail.product.myseller.sellercity}</span>
								</p>


							</div>
						</div>

						<div class="row p-5">
							<div class="col-md-12">
								<table class="table">
									<thead>
										<tr>

											<th class="border-0 text-uppercase small font-weight-bold">Product</th>
											<th class="border-0 text-uppercase small font-weight-bold">Description</th>
											<th class="border-0 text-uppercase small font-weight-bold">Price</th>
											<th class="border-0 text-uppercase small font-weight-bold">Quantity</th>
											<th class="border-0 text-uppercase small font-weight-bold">Total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											
											<td>${orderDetail.product.productName}</td>
											<td>${orderDetail.product.productDescription}</td>
											<td>${orderDetail.product.productPrice }</td>
											<td>${orderDetail.qty}</td>
											<td>${orderDetail.price}</td>
										</tr>


									</tbody>
								</table>
							</div>
						</div>

						<div class="d-flex flex-row-reverse bg-dark text-white p-4">
							<div class="py-3 px-5 text-right">
								<div class="mb-2">Total</div>
								<div class="h2 font-weight-light">${orderDetail.price}</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>

		
	</div>
</div>
<div class="modal-footer left">
        <a href="${cr3}/viewAllOrders" class="btn btn-success" data-dismiss="modal" >Continue to View Orders</a>
      </div>