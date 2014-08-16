<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="admin.user.remove" />
</jsp:include>

<c:if test="${not empty success && !success}">
	<div class="error"><spring:message code="remove.user.failure" /></div>
</c:if>

<spring:message code="user" /> <strong>${user.username}</strong>
<p><spring:message code="remove.user.confirmation" /></p>

<form:form method="post">
	<button type="submit"><spring:message code="remove.user" /></button>
	<a href="../user"><spring:message code="cancel" /></a>
</form:form>

<jsp:include page="/WEB-INF/pages/include/footer.jsp" />