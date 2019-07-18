<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.row1 {
	margin-right: 5px;
	padding-top: 10px;
}

.row2 {
	padding-bottom: 20px;
}

.flipkart-navbar-input1 {
	margin-top: 3%;
	width: 80%;
	padding: 11px 16px;
	border-radius: 2px 0 0 2px;
	border: .5 none;
	border-color: #ff7b25;
	outline: 0 none;
	font-size: 15px;
	padding: 11px 16px;
}

.flipkart-navbar-button {
	background-color: #ff7b25;
	border: 1px solid #ff7b25;
	border-radius: 0 2px 2px 0;
	color: #565656;
	padding: 12px 0;
	height: 48px;
	cursor: pointer;
	margin-top: 3%;
	width: 5%
}

.upper-links {
	display: inline-block;
	padding: 0 11px;
	line-height: 23px;
	font-family: 'Roboto', sans-serif;
	letter-spacing: 0;
	color: #ff7b25;
	border: none;
	outline: none;
	font-size: 22px;
}


.lower-links {
	display: inline-block;
	padding: 0 11px;
	line-height: 23px;
	font-family: 'Roboto', sans-serif;
	letter-spacing: 0;
	color: #ff7b25;
	border: none;
	outline: none;
	font-size: 12px;
}

.links {
	color: #ff7b25;
	text-decoration: none;
}
.links:hover {
	color: #ff7b25;
	text-decoration: none;
}
.profile-links {
	font-size: 12px;
	font-family: 'Roboto', sans-serif;
	border-bottom: 1px solid #e9e9e9;
	box-sizing: border-box;
	display: block;
	padding: 0 11px;
	line-height: 23px;
}

.profile-li {
	padding-top: 2px;
}

.largenav {
	display: none;
}

.smallnav {
	display: block;
}

.smallsearch {
	margin-left: 15px;
	margin-top: 15px;
}

.menu {
	cursor: pointer;
}

@media screen and (min-width: 768px) {
	.largenav {
		display: block;
	}
	.smallnav {
		display: none;
	}
	.smallsearch {
		margin: 0px;
	}
}

/*Sidenav*/
.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #fff;
	overflow-x: hidden;
	transition: 0.5s;
	box-shadow: 0 4px 8px -3px #555454;
	padding-top: 0px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
	color: #fff;
}

@media screen and (max-height: 450px) {
	.sidenav a {
		font-size: 18px;
	}
}

.sidenav-heading {
	font-size: 26px;
	color: #fff;
}
</style>
<script>
	function openNav() {
		document.getElementById("mySidenav").style.width = "70%";
		// document.getElementById("flipkart-navbar").style.width = "50%";
		document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
		document.body.style.backgroundColor = "rgba(0,0,0,0)";
	}
</script>
<c:choose>
	<c:when
		test="${sessionScope.userlogin==true && sessionScope.sellerlogin==false}">
		<div id="flipkart-navbar">
			<div class="row row1">
				<ul class="largenav pull-right">
					<li class="upper-links"><a class="links" href="home">Home</a></li>
					<li class="upper-links"><a class="links" href="aboutus">About
							Us</a></li>
					<li class="upper-links"><a class="links" href="ViewAllProduct">View
							All Product</a></li>
					<li class="upper-links"><a class="links" href="contactus">Contact
							Us</a></li>


					<li class="upper-links"><a class="links" href="viewAllCart"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>

					<li class="upper-links">Welcome!!

						<div class="dropdown">
							<a class="upper-links" data-toggle="dropdown">${sessionScope.username}
								<span class="caret"></span>
							</a>

							<ul class="dropdown-menu">
								<li class="lower-links"><a class="links"
									href="viewAllOrders">View Orders</a></li>
								<li class="lower-links"><a class="links" href="wishlist">WishList</a></li>
								 <li class="divider"></li>
								<li class="lower-links"><a class="links" href="userprofile">User
										Profile</a></li>
										
								<li class="lower-links"><a class="links"
									href="changepassword">Change Password</a></li>
								<li class="lower-links"><a class="links" href="logout">Logout</a></li>
							</ul>
						</div>



					</li>
				</ul>
			</div>
			<div class="row row2">
				<div class="col-sm-2">
					<h2 style="margin: 0px;">
						<span class="smallnav menu" onclick="openNav()"><img
							src="resources/images/logo.PNG" class="img-responsive"></span>
					</h2>
					<h1 style="margin: 0px;">
						<span class="largenav"><img
							src="resources/images/Capture.PNG" class="img-responsive"></span>
					</h1>
				</div>
				<div class="col-sm-2"></div>
				<div class="flipkart-navbar-search smallsearch col-sm-8">
					<div class="row">
						<input class="flipkart-navbar-input1 col-xs-11" type="text"
							placeholder="Search for Products, Brands and more" name="">
						<button class="flipkart-navbar-button col-xs-1">
							<svg width="15px" height="15px">
                            <path
									d="M11.618 9.897l4.224 4.212c.092.09.1.23.02.312l-1.464 1.46c-.08.08-.222.072-.314-.02L9.868 11.66M6.486 10.9c-2.42 0-4.38-1.955-4.38-4.367 0-2.413 1.96-4.37 4.38-4.37s4.38 1.957 4.38 4.37c0 2.412-1.96 4.368-4.38 4.368m0-10.834C2.904.066 0 2.96 0 6.533 0 10.105 2.904 13 6.486 13s6.487-2.895 6.487-6.467c0-3.572-2.905-6.467-6.487-6.467 "></path>
                        </svg>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="mySidenav" class="sidenav">
			<div class="container"
				style=" padding-top: 10px;">
				<span class="sidenav-heading">Home</span> <a href="home"
					class="closebtn" onclick="closeNav()">×</a>
			</div>
			<a href="aboutus">About Us</a> 
			<a href="ViewAllProduct">View All Product</a>
			<a href="contactus">Contact Us</a> 			
			<a href="login">Login</a> 
			<a href="register">Register</a>
		</div>
	</c:when>
	<c:when
		test="${sessionScope.userlogin==false && sessionScope.sellerlogin==true}">
		<div id="flipkart-navbar">
			<div class="row row1">
				<ul class="largenav pull-right">
					<li class="upper-links"><a class="links" href="home">Home</a></li>
					<li class="upper-links"><a class="links" href="aboutus">About
							Us</a></li>
					<li class="upper-links"><a class="links" href="product">Product</a></li>
					<li class="upper-links"><a class="links" href="contactus">Contact
							Us</a></li>
							
							
					
					<li class="upper-links">Welcome!!
					
					<div class="dropdown">
							<a class="upper-links" data-toggle="dropdown">${sessionScope.username}
								<span class="caret"></span>
							</a>

							<ul class="dropdown-menu">
							<li class="lower-links"><a class="links" href="approveseller">Approve Order</a></li>
								<li class="lower-links"><a class="links" href="sellerprofile">Seller
										Profile</a></li>
									 <li class="divider"></li>	
								<li class="lower-links"><a class="links"
									href="changepassword">Change Password</a></li>
								<li class="lower-links"><a class="links" href="logout">Logout</a></li>
									
							</ul>
						</div>
	
					</li>
					
				</ul>
			</div>
			
			<div class="row row2">
				<div class="col-sm-2">
					<h2 style="margin: 0px;">
						<span class="smallnav menu" onclick="openNav()"><img
							src="resources/images/logo.PNG" class="img-responsive"></span>
					</h2>
					<h1 style="margin: 0px;">
						<span class="largenav"><img
							src="resources/images/Capture.PNG" class="img-responsive"></span>
					</h1>
				</div>
				<div class="col-sm-2"></div>
				<div class="flipkart-navbar-search smallsearch col-sm-8"></div>
			</div>
		</div>
		<div id="mySidenav" class="sidenav">
			<div class="container"
				style="background-color: #2874f0; padding-top: 10px;">
				<span class="sidenav-heading">Home</span> <a href="home"
					class="closebtn" onclick="closeNav()">×</a>
			</div>
			<a href="aboutus">About Us</a> <a href="contactus">Contact Us</a> <a
				href="login">Login</a> <a href="register">Register</a>
		</div>
	</c:when>
	<c:when
		test="${sessionScope.userlogin==false && sessionScope.sellerlogin==false}">
		<div id="flipkart-navbar">
			<div class="row row1">
				<ul class="largenav pull-right">
					<li class="upper-links"><a class="links" href="home">Home</a></li>
					<li class="upper-links"><a class="links" href="aboutus">About
							Us</a></li>
					<li class="upper-links"><a class="links" href="addCategory">Category</a></li>
					<li class="upper-links"><a class="links" href="viewSeller">Seller</a></li>
					<li class="upper-links"><a class="links" href="contactus">Contact</a></li>

					<li class="upper-links">Welcome!!
						<div class="dropdown">
							<a class="upper-links" data-toggle="dropdown">${sessionScope.username}
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
							<li class="lower-links"><a class="links" href="approveadmin">Delivery Orders</a></li>
								<li class="lower-links"><a class="links"
									href="changepassword">Change Password</a></li>
								<li class="lower-links"><a class="links" href="logout">Logout</a></li>
							</ul>


						</div>
					</li>
				</ul>
			</div>
			<div class="row row2">
				<div class="col-sm-2">
					<h2 style="margin: 0px;">
						<span class="smallnav menu" onclick="openNav()"><img
							src="resources/images/logo.PNG" class="img-responsive"></span>
					</h2>
					<h1 style="margin: 0px;">
						<span class="largenav"><img
							src="resources/images/Capture.PNG" class="img-responsive"></span>
					</h1>
				</div>
				<div class="col-sm-2"></div>
				<div class="flipkart-navbar-search smallsearch col-sm-8"></div>
			</div>
		</div>
		<div id="mySidenav" class="sidenav">
			<div class="container"
				style="background-color: #2874f0; padding-top: 10px;">
				<span class="sidenav-heading">Home</span> <a href="home"
					class="closebtn" onclick="closeNav()">×</a>
			</div>
			<a href="aboutus">About Us</a> <a href="contactus">Contact Us</a> <a
				href="login">Login</a> <a href="register">Register</a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="flipkart-navbar">
			<div class="row row1">
				<ul class="largenav pull-right">
					<li class="upper-links"><a class="links" href="home">Home</a></li>
					<li class="upper-links"><a class="links" href="aboutus">About
							Us</a></li>
					<li class="upper-links"><a class="links" href="ViewAllProduct">View
							All Product</a></li>
					<li class="upper-links"><a class="links" href="contactus">Contact
							Us</a></li>
					<li class="upper-links"><a class="links" href="login">Login</a></li>
					<li class="upper-links"><a class="links" href="register">Register</a></li>
				</ul>
			</div>
			<div class="row row2">
				<div class="col-sm-2">
					<h2 style="margin: 0px;">
						<span class="smallnav menu" onclick="openNav()"><img
							src="resources/images/logo.PNG" class="img-responsive"></span>
					</h2>
					<h1 style="margin: 0px;">
						<span class="largenav"><img
							src="resources/images/Capture.PNG" class="img-responsive"></span>
					</h1>
				</div>
				<div class="col-sm-2"></div>
				<div class="flipkart-navbar-search smallsearch col-sm-8">
					<div class="row">
						<input class="flipkart-navbar-input1 col-xs-11" type="text"
							placeholder="Search for Products, Brands and more" name="">
						<button class="flipkart-navbar-button col-xs-1">
							<svg width="15px" height="15px">
                            <path
									d="M11.618 9.897l4.224 4.212c.092.09.1.23.02.312l-1.464 1.46c-.08.08-.222.072-.314-.02L9.868 11.66M6.486 10.9c-2.42 0-4.38-1.955-4.38-4.367 0-2.413 1.96-4.37 4.38-4.37s4.38 1.957 4.38 4.37c0 2.412-1.96 4.368-4.38 4.368m0-10.834C2.904.066 0 2.96 0 6.533 0 10.105 2.904 13 6.486 13s6.487-2.895 6.487-6.467c0-3.572-2.905-6.467-6.487-6.467 "></path>
                        </svg>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="mySidenav" class="sidenav">
			<div class="container"
				style="background-color: #2874f0; padding-top: 10px;">
				<span class="sidenav-heading">Home</span> <a href="home"
					class="closebtn" onclick="closeNav()">×</a>
			</div>
			<a href="aboutus">About Us</a> <a href="contactus">Contact Us</a> <a
				href="login">Login</a> <a href="register">Register</a>
		</div>
	</c:otherwise>
</c:choose>
