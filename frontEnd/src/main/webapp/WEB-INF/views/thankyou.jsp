<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="alert alert-danger">

<c:if test="${error}">
${message}
</c:if>
<%
if (request.getParameter("message") != null)
{
	out.println(request.getParameter("message"));
}
%>


</div>