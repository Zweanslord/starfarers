<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="user.password" />
</jsp:include>

<c:if test="${param.needNew != null}">
	<p><spring:message code="password.user.need.new" /></p>
</c:if>

<c:if test="${not empty success && !success}">
	<p class="error"><spring:message code="password.user.failure" /></p>
</c:if>

<form:form modelAttribute="newPassword" method="post">
	<fieldset>	
		<form:label path="password">
			<spring:message code="password" />
		</form:label>
		<form:input path="password" type="password" />
		<form:errors path="password" cssClass="error"/>
		
		<br/>
		
		<form:label path="passwordConfirmation">
			<spring:message code="password.confirmation" />
		</form:label>
		<form:input path="passwordConfirmation" type="password" />
		<form:errors path="passwordConfirmation" cssClass="error" />
		
		<form:errors cssClass="error" />
	</fieldset>
	<button type="submit"><spring:message code="save" /></button>
	<a href="../user"><spring:message code="cancel" /></a>
</form:form>

<jsp:include page="/WEB-INF/pages/include/footer.jsp" />