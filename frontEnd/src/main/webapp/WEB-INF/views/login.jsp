<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.zero-raduis {
	border-radius: 0px !important;
}

a {
	color: #ff7b25;
	display: inline-block;
	text-decoration: none;
	font-weight: 400;
}

.myfont {
	text-align: center;
	font-size: 16px;
	font-weight: 500;
	text-transform: uppercase;
	display: inline-block;
	color: #ff7b25;
}

/* STRUCTURE */
.wrapper {
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	width: 100%;
	min-height: 100%;
	padding: 20px;
}

#formContent {
	-webkit-border-radius: 10px 10px 10px 10px;
	border-radius: 10px 10px 10px 10px;
	background: #fff;
	padding: 30px;
	width: 90%;
	max-width: 450px;
	position: relative;
	padding: 0px;
	-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.3);
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.3);
	text-align: center;
}

#formFooter {
	padding: 2px;
	text-align: right;
	width: 90%;
}

/* TABS */
myfont.inactive {
	color: #cccccc;
}

myfont.active {
	color: #ff7b25;
	border-bottom: 2px solid #beea7c;
}

/* FORM TYPOGRAPHY*/
input[type=button], input[type=submit], input[type=reset] {
	background-color: #beea7c;
	border: none;
	color: #000000;
	width: 85%;
	padding: 10px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	text-transform: uppercase;
	font-size: 16px;
	cursor: pointer;
	-webkit-border-radius: 5px 5px 5px 5px;
	border-radius: 5px 5px 5px 5px;
	margin: 5px 20px 40px 20px;
	-webkit-transition: all 0.3s ease-in-out;
	-moz-transition: all 0.3s ease-in-out;
	-ms-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover
	{
	background-color: #9fce5b;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active
	{
	-moz-transform: scale(0.95);
	-webkit-transform: scale(0.95);
	-o-transform: scale(0.95);
	-ms-transform: scale(0.95);
	transform: scale(0.95);
}

.mytest {
	background-color: #f6f6f6;
	border: none;
	color: #ff7b25;
	padding: 10px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 5px;
	width: 85%;
	border: 2px solid #f6f6f6;
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-ms-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
	-webkit-border-radius: 5px 5px 5px 5px;
	border-radius: 5px 5px 5px 5px;
}

.mytest:focus {
	background-color: #fff;
	border-bottom: 2px solid #beea7c;
}

/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
	-webkit-animation-name: fadeInDown;
	animation-name: fadeInDown;
	-webkit-animation-duration: 1s;
	animation-duration: 1s;
	-webkit-animation-fill-mode: both;
	animation-fill-mode: both;
}

@
-webkit-keyframes fadeInDown { 0% {
	opacity: 0;
	-webkit-transform: translate3d(0, -100%, 0);
	transform: translate3d(0, -100%, 0);
}

100%
{
opacity


:

 

1;
-webkit-transform


:

 

none


;
transform


:

 

none


;
}
}
@
keyframes fadeInDown { 0% {
	opacity: 0;
	-webkit-transform: translate3d(0, -100%, 0);
	transform: translate3d(0, -100%, 0);
}

100%
{
opacity


:

 

1;
-webkit-transform


:

 

none


;
transform


:

 

none


;
}
}

/* Simple CSS3 Fade-in Animation */
@
-webkit-keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}
@
-moz-keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}
@
keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}
.fadeIn {
	opacity: 0;
	-webkit-animation: fadeIn ease-in 1;
	-moz-animation: fadeIn ease-in 1;
	animation: fadeIn ease-in 1;
	-webkit-animation-fill-mode: forwards;
	-moz-animation-fill-mode: forwards;
	animation-fill-mode: forwards;
	-webkit-animation-duration: 1s;
	-moz-animation-duration: 1s;
	animation-duration: 1s;
}

.fadeIn.first {
	-webkit-animation-delay: 0.4s;
	-moz-animation-delay: 0.4s;
	animation-delay: 0.4s;
}

.fadeIn.second {
	-webkit-animation-delay: 0.6s;
	-moz-animation-delay: 0.6s;
	animation-delay: 0.6s;
}

.fadeIn.third {
	-webkit-animation-delay: 0.8s;
	-moz-animation-delay: 0.8s;
	animation-delay: 0.8s;
}

.fadeIn.fourth {
	-webkit-animation-delay: 1s;
	-moz-animation-delay: 1s;
	animation-delay: 1s;
}

/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
	display: block;
	width: 0;
	height: 2px;
	background-color: #56baed;
	content: "";
	transition: width 0.2s;
}

.underlineHover:hover {
	color: #0d0d0d;
}

.underlineHover:hover:after {
	width: 100%;
}

/* OTHERS */
*:focus {
	outline: none;
}

#icon {
	width: 30%;
}
</style>

<div class="wrapper zero-raduis">
	<div id="formContent">
		<!-- Tabs Titles -->

		<!-- Icon -->
		<div>
			<h2 class="my-5 myfont">Sign In</h2>
		</div>
		<c:if test="${haserror}">
			<div class="alert alert-danger">
				<strong>${error}</strong>
			</div>

		</c:if>
		<!-- Login Form -->
		<form action="perform_login" method="post">
			<input type="text" id="user_name" class="zero-raduis mytest"
				name="user_name" placeholder="email"> <input type="password"
				id="user_password" class="zero-raduis mytest" name="user_password"
				placeholder="password">
			<div id="formFooter">
				<a class="underlineHover" href="forgetpassword">Forgot Password?</a>
			</div>
			<input type="submit" class="zero-raduis" value="login">
			<h2>You don't have a account ?</h2>
			<input type="button" class="zero-raduis pc" value="register" onclick="window.location.href='register'">
		</form>


	</div>
</div>