<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="admin.user.edit" />
</jsp:include>

<c:if test="${not empty success && !success}">
	<div class="error"><spring:message code="edit.user.failure" /></div>
</c:if>

<form:form modelAttribute="user" method="post">
	<fieldset>
		<form:hidden path="id" />
	
		<form:label path="username">
			<spring:message code="username" />
		</form:label>
		<form:input path="username" />
		<form:errors path="username" cssClass="error" />
		
		<br/>
		
		<form:label path="userRoles">
			<spring:message code="roles" />
		</form:label>
		<form:select path="roles" size="3">
			<c:forEach items="${roles}" var="role">
				<form:option value="${role}"><spring:message code="user.role.${role.getLowerCase()}" /></form:option>
			</c:forEach>
		</form:select>
		<form:errors path="userRoles" cssClass="error" />
		
		<br/>
		
		<form:label path="enabled">
			<spring:message code="enabled" />
		</form:label>
		<form:checkbox path="enabled" />
		<form:errors path="enabled" cssClass="error" />	
	</fieldset>
	<button type="submit"><spring:message code="save" /></button>
	<a href="../user"><spring:message code="cancel" /></a>
</form:form>

<jsp:include page="/WEB-INF/pages/include/footer.jsp" />