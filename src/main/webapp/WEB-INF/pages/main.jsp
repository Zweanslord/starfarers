<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="main" />
</jsp:include>

<p><spring:message code="intro"/></p>

<ul>
	<li><a href="galaxy"><spring:message code="title.galaxy" /></a></li>
	<li><a href="terrain/legend"><spring:message code="title.terrain.legend" /></a></li>
	<li><a href="players"><spring:message code="title.players" /></a></li>
	<li><a href="users"><spring:message code="title.users" /></a></li>
	<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
		<li><a href="master"><spring:message code="title.master" /></a></li>
	</security:authorize>
	<security:authorize access="isFullyAuthenticated()">
		<li><a href="user"><spring:message code="title.user.main" /></a></li>
	</security:authorize>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />