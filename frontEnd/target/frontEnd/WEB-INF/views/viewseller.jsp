<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet'>
<style>
body {
	font-family: 'Roboto';
	font-size: 16px;
}

.aboutus-section {
	padding: 90px 0;
}

.aboutus-title {
	font-size: 30px;
	letter-spacing: 0;
	line-height: 32px;
	margin: 0 0 39px;
	padding: 0 0 11px;
	position: relative;
	color: #000;
}

.aboutus-title::after {
	background: #fdb801 none repeat scroll 0 0;
	bottom: 0;
	content: "";
	height: 2px;
	left: 0;
	position: absolute;
	width: 54px;
}

.aboutus-text {
	color: #606060;
	font-size: 13px;
	line-height: 22px;
	margin: 0 0 35px;
}

a:hover, a:active {
	color: #ffb901;
	text-decoration: none;
	outline: 0;
}

.aboutus-more {
	border: 1px solid #fdb801;
	border-radius: 25px;
	color: #fdb801;
	display: inline-block;
	font-size: 14px;
	font-weight: 700;
	letter-spacing: 0;
	padding: 7px 20px;
	text-transform: uppercase;
}

.feature .feature-box .iconset {
	background: #fff none repeat scroll 0 0;
	float: left;
	position: relative;
	width: 18%;
}

.feature .feature-box .iconset::after {
	background: #fdb801 none repeat scroll 0 0;
	content: "";
	height: 150%;
	left: 43%;
	position: absolute;
	top: 100%;
	width: 1px;
}

.feature .feature-box .feature-content h4 {
	color: #0f0f0f;
	font-size: 18px;
	letter-spacing: 0;
	line-height: 22px;
	margin: 0 0 5px;
}

.feature .feature-box .feature-content {
	float: left;
	padding-left: 28px;
	width: 78%;
}

.feature .feature-box .feature-content h4 {
	color: #0f0f0f;
	font-size: 18px;
	letter-spacing: 0;
	line-height: 22px;
	margin: 0 0 5px;
}

.feature .feature-box .feature-content p {
	color: #606060;
	font-size: 13px;
	line-height: 22px;
}

.icon {
	color: #f4b841;
	padding: 0px;
	font-size: 40px;
	border: 1px solid #fdb801;
	border-radius: 100px;
	color: #fdb801;
	font-size: 28px;
	height: 70px;
	line-height: 70px;
	text-align: center;
	width: 70px;
}
}
</style>
<div class="aboutus-section">
	<div class="container">

		<div class="row">
		<c:if test="${showmess}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>
		<c:if test="${empty(allSeller)}">
			<div class="jumbotron">
				<h1>Seller Page</h1>
				<p>No seller</p>
				

			</div>
		</c:if>
		<c:if test="${!empty(allSeller)}">
			<div class="col-md-3 col-sm-6 col-xs-12"></div>
			<div class="col-md-5 col-sm-6 col-xs-12">
				<div class="feature">
					<table id="mytable" class="table table-bordered">
						<thead>
							<td>ID</td>
							<td>Seller Name</td>
							<td>Seller City</td>
							<td>Seller Phoneno</td>
							<td>Action</td>
						</thead>
						<tbody>
							<c:forEach items="${allSeller}" var="seller">
								<c:forEach items="${allSellercreditinal}" var="sellercred">
							<c:set var="email" value="${sellercred.credentialemail}"></c:set>
									<c:if
										test="${seller.selleremail==email}">
										<tr>
											<td>${seller.sellerid}</td>
											<td>${seller.sellername}</td>
											<td>${seller.sellercity}</td>
											<td>${seller.sellerphoneno}</td>
										    <td>
										   
										    <a href="ativateSeller?email=${seller.selleremail}">	<c:if test="${!sellercred.credentialstatus}"><img
													src="resources/images/approve.PNG" width="80" height="50"></c:if></a>
											<a href="deactivateSeller?id=${seller.sellerid}&email=${seller.selleremail}"><img src="resources/images/reject.PNG" width="80"
													height="50"></a></td>
										</tr>
									</c:if>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</c:if>
	</div>
</div>