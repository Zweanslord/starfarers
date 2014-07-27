<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="master" />
</jsp:include>

<p><spring:message code="master.intro" /></p>

<ul>
	<li><a href="editor/galaxy"><spring:message code="title.editor.galaxy" /></a></li>
	<li><a href="star"><spring:message code="title.star" /></a></li>
	<li><a href="editor/starSelector"><spring:message code="title.editor.starSelector" /></a></li>
	<li><a href="admin/players"><spring:message code="title.admin.players" /></a></li>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />