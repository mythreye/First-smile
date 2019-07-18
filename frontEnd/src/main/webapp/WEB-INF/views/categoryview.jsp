<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cr1" value="${pageContext.request.contextPath}/admin"/>
<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	
<script>
	$(document).ready(function() {
		$('#mytable').DataTable({
			"pagingType" : "simple_numbers",
			"lengthMenu" : [ [ 10, 20, 50, -1 ], [ 10,20,50, "All" ] ],
			"ordering" : true,
			"searching" : false
			
		});
	})
</script>

<div class="container">
	<div class="row">
		<div class="container">
			<div class="row">
				<c:if test="${haserror}">
					<div class="alert alert-danger">
						<strong>${error}</strong>
					</div>
				</c:if>
				<c:if test="${edit}">
					<c:set var="url" value="editexistcaegory"></c:set>
				</c:if>
				.
				<c:if test="${!edit}">
					<c:set var="url" value="addnewcaegory"></c:set>
				</c:if>
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<c:if test="${edit}">
								<h3 class="panel-title">Edit Category</h3>
							</c:if>
							<c:if test="${!edit}">
								<h3 class="panel-title">Add Category</h3>
							</c:if>

						</div>

						<div class="panel-body">
							<form:form role="form" modelAttribute="myCategory"
								action="${url}" method="post">
								<c:if test="${edit}">
									<div class="form-group">
										<label for="name" class="cols-sm-2 control-label">Category
											ID</label>
										<div class="cols-sm-10">
											<div class="input-group">
												<span class="input-group-addon"><i
													class="fa fa-user fa" aria-hidden="true"></i></span>
												<form:input type="text" class="form-control"
													name="categoryid" id="categoryid" path="categoryid"
													readonly="true" />
												<form:errors path="categoryid" cssStyle="color:Red"></form:errors>
											</div>
										</div>
									</div>
								</c:if>
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Category
										Name</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control"
												name="categoryname" id="categoryname" path="categoryname"
												placeholder="Enter Category Name" />
											<form:errors path="categoryname" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Category
										Description</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:textarea path="categorydescription"
												name="categorydescription" id="categorydescription"
												cols="40" rows="10" />
											<form:errors path="categorydescription" cssStyle="color:Red"></form:errors>
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
					<table id="mytable" class="table table-striped table-bordered"  >
						<thead>
							<tr>
								<th>Category Id</th>
								<th>Category Name</th>
								<th>Category Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<!-- for each loop starts here-->
							<c:forEach items="${allCategory}" var="category">
								<tr>
									<td>${category.categoryid }</td>
									<td>${category.categoryname }</td>
									<td>${category.categorydescription }</td>
									<c:url value="${cr1}/editCategory?categoryid=${category.categoryid }"
										var="cid"></c:url>
									<c:url
										value="${cr1}/deleteCategory?categoryid=${category.categoryid }"
										var="deleteid"></c:url>
									<td><a href="${cid}"><span
											class="glyphicon glyphicon-pencil"></span></a> <a
										href="${deleteid }"> <span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
							<!--  for each loop ends here -->
						</tbody>
					</table>
				</div>


			</div>
		</div>

	</div>
</div>