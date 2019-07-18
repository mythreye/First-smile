<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cr2" value="${pageContext.request.contextPath}/seller"/>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimage" />
 <script
	src="https://cdn.rawgit.com/atatanasov/gijgo/master/dist/combined/js/gijgo.min.js"
	type="text/javascript"></script>
<link
	href="https://cdn.rawgit.com/atatanasov/gijgo/master/dist/combined/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
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
<div class="container">
	<div class="row">
		<c:if test="${haserror}">
			<div class="alert alert-danger">
				<strong>${error}</strong>
			</div>
		</c:if>
		<c:if test="${edit}">
			<c:set var="url" value="updateexistProduct"></c:set>
		</c:if>
		.
		<c:if test="${!edit}">
			<c:set var="url" value="addnewproduct"></c:set>
		</c:if>
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<c:if test="${edit}">
						<h3 class="panel-title">Edit Product</h3>
					</c:if>
					<c:if test="${!edit}">
						<h3 class="panel-title">Add Product</h3>
					</c:if>
				</div>
				<div class="panel-body">
					<form:form role="form" modelAttribute="myProduct" action="${url}"
						method="post" enctype="multipart/form-data">
						<c:if test="${edit}">
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Product
									ID</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" name="categoryid"
											id="productId" path="productId" readonly="true" />
										<form:errors path="productId" cssStyle="color:Red"></form:errors>
									</div>
								</div>
							</div>
						</c:if>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" name="productName"
										id="productName" path="productName"
										placeholder="Enter Product Name" />
									<form:errors path="productName" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:textarea id="editor" style="height:300px;width:300px;"
										path="productDescription" class="form-control" />



									<form:errors path="productDescription" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Price</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" path="productPrice" name="productPrice"
										id="productPrice" class="form-control" />
									<form:errors path="productPrice" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Quantity</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" path="prouctQuantity"
										name="prouctQuantity" id="prouctQuantity" class="form-control" />
									<form:errors path="prouctQuantity" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Image</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="file" class="form-control" name="image"
										id="image" path="image" placeholder="Product Image" />
									<form:errors path="image" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Category</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:select path="mycategory.categoryid"  cssStyle="height:30px" cssClass="form-control">
										<c:forEach items="${Categories}" var="c">
											<form:option cssClass="form-control" value="${c.categoryid}">${c.categoryname}</form:option>
										</c:forEach>
									</form:select>
									<form:errors path="mycategory" cssStyle="color:Red"></form:errors>
									
									<form:input type="hidden" path="myseller.sellerid" value="${sessionScope.sellerid}"
										class="form-control"  />
								</div>
							</div>
						</div>
						
						<div class="form-group ">
							<input type="submit" id="button"
								class="btn btn-success btn-lg btn-block login-button">

						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-md-7">
			<table id="mytable" class="table table-bordered">
				<thead>
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Category</th>
						<th>Product Price</th>
						<th>Product Quantity</th>
						<th>Image</th>					
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<!-- for each loop starts here-->
					<c:forEach items="${allProduct}" var="p">
						<tr>
							<td>${p.productId}</td>
							<td>${p.productName}</td>
							<c:forEach items="${Categories}" var="cate">

								<c:set value="${p.mycategory.categoryid}" var="categoryid">
								</c:set>
								<c:set value="${cate.categoryid}" var="category_id">
								</c:set>
								<c:if test="${categoryid == category_id}">
									<td>${cate.categoryname}</td>
								</c:if>
							</c:forEach>

							<td>${p.productPrice}</td>
							<td>${p.prouctQuantity}</td>
							<td><img src="${CR}/${p.productId}.jpg" class="img-responsive" height="50px"></td>
							<c:url value="${cr2}/updateProduct?pid=${p.productId}" var="cid"></c:url>
							<c:url value="${cr2}/deleteProduct?pid=${p.productId}" var="deleteid"></c:url>
							<td><a href="${cid}"><span
									class="glyphicon glyphicon-pencil"></span></a> <a
								href="${deleteid }"> <span class="glyphicon glyphicon-trash"></span></a></td>

						</tr>

					</c:forEach>


					<!--  for each loop ends here -->
				</tbody>
			</table>
		</div>


	</div>
</div>