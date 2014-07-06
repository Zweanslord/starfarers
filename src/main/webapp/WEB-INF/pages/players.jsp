<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Players" />
</jsp:include>

<h2>Active Players</h2>

<ul>
	<c:forEach items="${playerList.playerViews}" var="player">
		<li>
			<c:out value="${player.name}" />
		</li>
	</c:forEach>
</ul>

<h2>Inactive Players</h2>

<ul>
	<c:forEach items="${inactivePlayerList.playerViews}" var="inactivePlayer">
		<li>
			<c:out value="${inactivePlayer.name}" />
		</li>
	</c:forEach>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />