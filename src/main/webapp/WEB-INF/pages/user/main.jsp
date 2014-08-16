<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="user.main" />
</jsp:include>

<c:if test="${not empty password}">
	<p><spring:message code="password.user.success" /></p>
</c:if>

<ul>
	<li><a href="user/password"><spring:message code="title.user.password" /></a></li>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />