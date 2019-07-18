<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>First Smile</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="min-height: 500px;">
		<c:if test="${indexPage}">
			<%@ include file="slider.jsp"%>
		</c:if>
		<c:if test="${aboutusPage}">
			<%@ include file="aboutus.jsp"%>
		</c:if>
		<c:if test="${loginPage}">
			<%@ include file="login.jsp"%>
		</c:if>
		<c:if test="${contactusPage}">
			<%@ include file="contactus.jsp"%>
		</c:if>
		<c:if test="${registerPage}">
			<%@ include file="register.jsp"%>
		</c:if>
		<c:if test="${registrationPage}">
			<%@ include file="registration_supplier.jsp"%>
		</c:if>
		<c:if test="${thankyouPage}">
			<%@ include file="thankyou.jsp"%>
		</c:if>
		<c:if test="${addCategoryPage}">
			<%@ include file="categoryview.jsp"%>
		</c:if>
		<c:if test="${viewSellerPage}">
			<%@ include file="viewseller.jsp"%>
		</c:if>
		<c:if test="${productviewPage}">
			<%@ include file="product.jsp"%>
		</c:if>
		<c:if test="${viewAllProductPage}">
			<%@ include file="viewAllProduct.jsp"%>
		</c:if>
		<c:if test="${viewOneProductPage}">
			<%@ include file="viewoneProduct.jsp"%>
		</c:if>
		
		<c:if test="${sellerprofilePage}">
			<%@ include file="registration_supplier.jsp"%>
		</c:if>
		<c:if test="${changepasswordPage}">
			<%@ include file="changepassword.jsp"%>
		</c:if>
		<c:if test="${forgetPasswordPage}">
			<%@ include file="forgetpassword.jsp"%>
		</c:if>
		<c:if test="${addToCartPage}">
			<%@ include file="cart.jsp"%>
		</c:if>
		<c:if test="${shippingAddressPage}">
			<%@ include file="shippingaddress.jsp"%>
		</c:if>
		<c:if test="${cartOrderPage}">
			<%@ include file="vieworder.jsp"%>
		</c:if>
		<c:if test="${wishlistPage}">
			<%@ include file="wishlist.jsp"%>
		</c:if>
		<c:if test="${viewReceiptPage}">
			<%@ include file="nreceipt.jsp"%>
		</c:if>
		<c:if test="${approvesellerPage}">
			<%@ include file="approve.jsp"%>
		</c:if>
		<c:if test="${adminapprovePage}">
			<%@ include file="approveadmin.jsp"%>
		</c:if>
		
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>