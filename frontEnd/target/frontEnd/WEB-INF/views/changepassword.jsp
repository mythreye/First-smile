<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    function validation()
    {
    
            var password = $("#newpassword").val();
            var confirmPassword = $("#inputPasswordNewVerify").val();
           
            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        
    }
</script>
<div class="content py-5 bg-light  ">
<div class="container">

<c:if test="${haserror}">
		<div class="alert alert-danger">
			<strong>${error}</strong>
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-6 offset-md-3">
                    <span class="anchor" id="formChangePassword"></span>
                   <!-- form card change password -->
                    <div class="card card-outline-secondary">
                        <div class="card-header">
                            <h3 class="mb-0">Change Password</h3>
                        </div>
                        <div class="card-body">
                            <form:form   action="chgepwd" method="post" modelAttribute="chngepwd">
                                <div class="form-group">
                                    <label for="inputPasswordOld">Current Password</label>
                                    <form:input type="password" class="form-control" id="oldpassword" path="oldpassword" required="Enter valid old password" />
                                </div>
                                <div class="form-group">
                                    <label for="inputPasswordNew">New Password</label>
                                    <form:input type="password" class="form-control" id="newpassword" path="newpassword" required="Enter new password" />
                                    <span class="form-text small text-muted">
                                            The password must be 6-10 characters, and must <em>not</em> contain spaces.
                                        </span>
                                </div>
                               <!--  <div class="form-group">
                                    <label for="inputPasswordNewVerify">Verify</label>
                                    <form:input type="password" class="form-control" id="inputPasswordNewVerify" path="" required="Enter Confirm password"/>
                                    <span class="form-text small text-muted">
                                            To confirm, type the new password again.
                                        </span>
                                </div> -->
                                <div class="form-group">
                                    <input type="submit"  class="btn btn-success btn-lg float-right"   value="Update">
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <!-- /form card change password -->

                </div>
	</div>
</div>
</div>