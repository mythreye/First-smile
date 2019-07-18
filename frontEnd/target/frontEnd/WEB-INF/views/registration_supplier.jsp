<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
/*
/* Created by Filipe Pina
 * Specific styles of signin, register, component
 */
/*
 * General styles
 */
#playground-container {
	height: 500px;
	overflow: hidden !important;
	-webkit-overflow-scrolling: touch;
}

body, html {
	height: 100%;
	background-repeat: no-repeat;
	font-family: 'Oxygen', sans-serif;
	background-size: cover;
}

.main {
	margin: 50px 15px;
}

h1.title {
	font-size: 50px;
	font-family: 'Passion One', cursive;
	font-weight: 400;
}

hr {
	width: 10%;
	color: #fff;
}

.form-group {
	margin-bottom: 15px;
}

label {
	margin-bottom: 15px;
}

input, input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.form-control {
	height: auto !important;
	padding: 8px 12px !important;
}

.input-group {
	-webkit-box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.21) !important;
	-moz-box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.21) !important;
	box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.21) !important;
}

#button {
	border: 1px solid #ccc;
	margin-top: 28px;
	padding: 6px 12px;
	color: #666;
	text-shadow: 0 1px #fff;
	cursor: pointer;
	-moz-border-radius: 3px 3px;
	-webkit-border-radius: 3px 3px;
	border-radius: 3px 3px;
	-moz-box-shadow: 0 1px #fff inset, 0 1px #ddd;
	-webkit-box-shadow: 0 1px #fff inset, 0 1px #ddd;
	box-shadow: 0 1px #fff inset, 0 1px #ddd;
	background: #f5f5f5;
	background: -moz-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f5f5f5),
		color-stop(100%, #eeeeee));
	background: -webkit-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
	background: -o-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
	background: -ms-linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
	background: linear-gradient(top, #f5f5f5 0%, #eeeeee 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5',
		endColorstr='#eeeeee', GradientType=0);
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 400px;
	padding: 10px 40px;
	background: #d3d3d3;
	color: #FFF;
	text-shadow: none;
	-webkit-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	-moz-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
}

span.input-group-addon i {
	color: #009edf;
	font-size: 17px;
}

.login-button {
	margin-top: 5px;
}

.login-register {
	font-size: 11px;
	text-align: center;
}
</style>


<div class="container">
	<c:if test="${haserror}">
		<div class="alert alert-danger">
			<strong>${error}</strong>
		</div>
	</c:if>
	<c:if test="${showmess}">
		<div class="alert alert-success">
			<strong>${message}</strong>
		</div>
	</c:if>

	<c:if test="${edit}">
		<c:set var="url" value="updateSeller"></c:set>
	</c:if>
	.
	<c:if test="${!edit}">
		<c:set var="url" value="addSeller"></c:set>
	</c:if>
	<div class="main">
		<div class="main-center">
			<h5>Sign up once and watch any of our free demos.</h5>
			<form:form method="post" action="${url}"
				modelAttribute="mySellerAttr">

				<c:if test="${edit}">
					<div class="form-group">
						<label for="name">Your Id</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<form:input type="hidden" class="form-control"
									name="sellerpassword" path="sellerpassword"
									placeholder="Enter your Password"  />
								<form:input type="text" class="form-control"
									name="sellerid" path="sellerid" readonly="true" value="${sessionScope.sellerid}"/>
							</div>
						</div>
					</div>
				</c:if>


				<div class="form-group">
					<label for="name">Your Name</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span>
							<form:input type="text" class="form-control" path="sellername"
								name="sellername" id="sellername" placeholder="Enter your Name" />
							<form:errors path="sellername" cssStyle="color:Red"></form:errors>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="email">Your Email</label>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-envelope fa" aria-hidden="true"></i></span>
						<form:input type="text" class="form-control" name="selleremail"
							path="selleremail" placeholder="Enter your Email" />
						<form:errors path="selleremail" cssStyle="color:Red"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<label for="email">Your Phone</label>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-mobile fa"
							aria-hidden="true"></i></span>
						<form:input type="text" class="form-control" name="sellerphoneno"
							path="sellerphoneno" placeholder="Enter your Phone" />
						<form:errors path="sellerphoneno" cssStyle="color:Red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label for="username">Your city</label>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-map-marker fa" aria-hidden="true"></i></span>
						<form:input type="text" class="form-control" name="sellercity"
							path="sellercity" placeholder="Enter your City" />
						<form:errors path="sellercity" cssStyle="color:Red"></form:errors>
					</div>
				</div>
				<c:if test="${!edit}">
					<div class="form-group">
						<label for="password">Password</label>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<form:input type="password" class="form-control"
								name="sellerpassword" path="sellerpassword"
								placeholder="Enter your Password" />
							<form:errors path="sellerpassword" cssStyle="color:Red"></form:errors>
						</div>
					</div>
				</c:if>
				<div class="form-group ">
					<input type="submit" id="button"
						class="btn btn-success btn-lg btn-block login-button">

				</div>
			</form:form>
		</div>
	</div>



</div>