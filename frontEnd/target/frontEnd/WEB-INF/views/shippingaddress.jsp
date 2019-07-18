<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.row.heading h2 {
	color: black;
	font-size: 52.52px;
	line-height: 95px;
	font-weight: 400;
	text-align: center;
	margin: 0 0 40px;
	padding-bottom: 20px;
	text-transform: uppercase;
}

ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

.heading.heading-icon {
	display: block;
}

.padding-lg {
	display: block;
	padding-top: 60px;
	padding-bottom: 60px;
}

.practice-area.padding-lg {
	padding-bottom: 55px;
	padding-top: 55px;
}

.practice-area .inner {
	border: 1px solid #999999;
	text-align: center;
	margin-bottom: 28px;
	padding: 40px 25px;
}

.our-webcoderskull .cnt-block:hover {
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
	border: 0;
}

.practice-area .inner h3 {
	color: #3c3c3c;
	font-size: 24px;
	font-weight: 500;
	font-family: 'Poppins', sans-serif;
	padding: 10px 0;
}

.practice-area .inner p {
	font-size: 14px;
	line-height: 22px;
	font-weight: 400;
}

.practice-area .inner img {
	display: inline-block;
}

.our-webcoderskull .cnt-block {
	float: left;
	width: 100%;
	background: #fff;
	padding: 30px 20px;
	text-align: center;
	border: 2px solid #d5d5d5;
	margin: 0 0 28px;
}

.our-webcoderskull .cnt-block figure {
	width: 148px;
	height: 148px;
	border-radius: 100%;
	display: inline-block;
	margin-bottom: 15px;
}

.our-webcoderskull .cnt-block img {
	width: 148px;
	height: 148px;
	border-radius: 100%;
}

.our-webcoderskull .cnt-block h3 {
	color: #2a2a2a;
	font-size: 20px;
	font-weight: 500;
	padding: 6px 0;
	text-transform: uppercase;
}

.our-webcoderskull .cnt-block h3 a {
	text-decoration: none;
	color: #2a2a2a;
}

.our-webcoderskull .cnt-block h3 a:hover {
	color: #337ab7;
}

.our-webcoderskull .cnt-block p {
	color: #2a2a2a;
	font-size: 13px;
	line-height: 20px;
	font-weight: 400;
}

.our-webcoderskull .cnt-block .follow-us {
	margin: 20px 0 0;
}

.our-webcoderskull .cnt-block .follow-us li {
	display: inline-block;
	width: auto;
	margin: 0 5px;
}

.our-webcoderskull .cnt-block .follow-us li .fa {
	font-size: 24px;
	color: #767676;
}

.our-webcoderskull .cnt-block .follow-us li .fa:hover {
	color: #025a8e;
}
</style>
<div class="container">
	<div class="row">
		<c:if test="${empty(myaddress)}">
			<div class="jumbotron">
				<h1>Shipping Address Details</h1>
				<p>No Address</p>
				<a href="" class="btn btn-default btn-rounded mb-4"
					data-toggle="modal" data-target="#modalLoginForm">Add New
					Address</a>
			</div>
		</c:if>
	</div>
	<c:if test="${!empty(myaddress)}">

		<section class="our-webcoderskull padding-lg">
			<div class="container">
				<div class="row heading heading-icon">
					<h2 align="center">Shipping Address Details</h2>
				</div>
				<ul class="row">
					<c:forEach items="${myaddress}" var="a">
						<li class="col-12 col-md-6 col-lg-3">

							<div class="cnt-block equal-hight">

								<a href="editaddress?addid=${a.addressid}"
									class="btn btn-default btn-rounded mb-4 pull-left">Edit</a> <a
									href="deleteaddress?addid=${a.addressid}"
									class="btn btn-default btn-rounded mb-4 pull-right">Delete</a>
								<figure>
									<img
										src="https://tse3.mm.bing.net/th?id=OIP.J17tgMg9ctkLujXssrSs-AHaFY&pid=15.1&P=0&w=215&h=157"
										class="img-responsive" alt="">
								</figure>

								<h3>
									<a href="http://www.webcoderskull.com/">${a.name}</a>
								</h3>
								<p>${a.addreeline1},${a.addressline2}</p>
								<p>${a.city},${a.state}-${a.pincode}</p>
								<a href="checkout?addid=${a.addressid}"
									class="btn btn-default btn-rounded mb-4">Delivery Here</a>
							</div>

						</li>
					</c:forEach>
				</ul>
			</div>
		</section>
		<c:if test="${edit}">
			<div class="jumbotron">
				<c:set var="url" value="updateaddress"></c:set>
				<c:if test="${haserror}">
					<div class="alert alert-danger">
						<strong>${error}</strong>
					</div>
				</c:if>

				<form:form role="form" modelAttribute="addShippingAddress"
					action="${url}" method="post">

					<div class="modal-content">
						<div class="modal-header text-center">
							<h4 class="modal-title w-100 font-weight-bold">New Address</h4>
						</div>
						<div class="modal-body mx-3">
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Customer
										Name:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="hidden" class="form-control"
												path="addressid" />
											<form:input type="text" class="form-control" path="name" />
											<form:errors path="name" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Address
										Line 1:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control"
												path="addreeline1" />
											<form:errors path="addreeline1" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Address
										Line 2:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control"
												path="addressline2" />
											<form:errors path="addressline2" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">City:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control" path="city" />
											<form:errors path="city" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">State:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control" path="state" />
											<form:errors path="state" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<div class="md-form mb-5">
								<div class="form-group">
									<label for="name" class="cols-sm-2 control-label">Pincode:</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-user fa" aria-hidden="true"></i></span>
											<form:input type="text" class="form-control" path="pincode" />
											<form:input type="hidden" class="form-control"
												path="mycustomer.customerid"
												value="${sessionScope.usercartid}" />

											<form:errors path="pincode" cssStyle="color:Red"></form:errors>
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="modal-footer d-flex justify-content-center">
							<button class="btn btn-deep-orange">Submit</button>
						</div>
					</div>
				</form:form>
			</div>

		</c:if>
		<c:if test="${!edit}">
			<div class="jumbotron">
				<a href="" class="btn btn-default btn-rounded mb-4"
					data-toggle="modal" data-target="#modalLoginForm">Add New
					Address</a>
			</div>
		</c:if>

	</c:if>
</div>

<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<c:if test="${haserror}">
		<div class="alert alert-danger">
			<strong>${error}</strong>
		</div>
	</c:if>

	<div class="modal-dialog" role="document">
		<form:form role="form" modelAttribute="addShippingAddress"
			action="addaddress" method="post">

			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">New Address</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body mx-3">
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Customer
								Name:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="name" />
									<form:errors path="name" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Address
								Line 1:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="addreeline1" />
									<form:errors path="addreeline1" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Address
								Line 2:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control"
										path="addressline2" />
									<form:errors path="addressline2" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">City:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="city" />
									<form:errors path="city" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">State:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="state" />
									<form:errors path="state" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="md-form mb-5">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Pincode:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span>
									<form:input type="text" class="form-control" path="pincode" />
									<form:input type="hidden" class="form-control"
										path="mycustomer.customerid"
										value="${sessionScope.usercartid}" />

									<form:errors path="pincode" cssStyle="color:Red"></form:errors>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer d-flex justify-content-center">
					<button class="btn btn-deep-orange">Submit</button>
				</div>
			</div>
		</form:form>
	</div>

</div>

