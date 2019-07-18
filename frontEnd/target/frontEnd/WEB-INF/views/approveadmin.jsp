<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">
	<div>
	<c:if test="${haserror}">
		<div class="alert alert-danger">
				<strong>${message}</strong>
			</div>
	</c:if>
	</div>
	<div class="row">
	<c:if test="${empty(prodlist)}">
			<div class="jumbotron">
				<h1>Approve List</h1>
				<p>No Items</p>
				

			</div>
		</c:if>
		<c:if test="${haserror}">
			<div class="alert alert-danger">
				<strong>${message}</strong>
			</div>
		</c:if>
		<c:if test="${!empty(prodlist)}">
		
	<table id="mytable" class="table table-bordered">
				<thead>
					<tr>
						<th>Order Id</th>
						<th>Customer Name</th>
						<th>Product Name</th>
						<th>Product Category</th>
						<th>Product Price</th>
						<th>Product Quantity</th>
											
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
	<c:forEach items="${prodlist}" var="pl">
	<tr>
	<td>${pl.orderId}</td>
	<td>${pl.customer.customername}</td>
	<td>${pl.product.productName}</td>
	<td>${pl.product.mycategory.categoryname}</td>
	<td>${pl.product.productPrice}</td>
	<td>${pl.qty}</td>
	<td> <a href="deleivred?id=${pl.orderId}">Change to Delivered </a> </td>
	</tr>
	
	</c:forEach>
	</tbody>
			</table>
			</c:if>
	</div>
</div>
