<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="login" />
</jsp:include>

<form:form action="${pageContext.request.contextPath}/login" method="post">               
	<fieldset>
		<legend>Login</legend>
		<label for="username"><spring:message code="username"/></label>
		<input type="text" id="username" name="username"/>        
		<label for="password"><spring:message code="password"/></label>
		<input type="password" id="password" name="password"/>    
		<button type="submit"><spring:message code="login"/></button>
		<c:if test="${param.error != null}">
			<div class="error">    
				<spring:message code="invalid.login"/>
			</div>
		</c:if>
	</fieldset>
</form:form>

<p><spring:message code="login.intro"/></p>

<jsp:include page="/WEB-INF/pages/include/footer.jsp">
	<jsp:param name="hide" value="trues" />
</jsp:include>