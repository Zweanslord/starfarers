<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="main" />
</jsp:include>

<p><spring:message code="intro"/></p>

<ul>
	<li><a href="galaxy"><spring:message code="title.galaxy"/></a></li>
	<li><a href="players"><spring:message code="title.players"/></a></li>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />