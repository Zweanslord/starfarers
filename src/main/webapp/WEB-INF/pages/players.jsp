<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="players" />
</jsp:include>

<h2><spring:message code="active.players" /></h2>

<ul>
	<c:forEach items="${playerList.playerViews}" var="player">
		<li>
			<c:out value="${player.name}" />
		</li>
	</c:forEach>
</ul>

<h2><spring:message code="inactive.players" /></h2>

<ul>
	<c:forEach items="${inactivePlayerList.playerViews}" var="inactivePlayer">
		<li>
			<c:out value="${inactivePlayer.name}" />
		</li>
	</c:forEach>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />