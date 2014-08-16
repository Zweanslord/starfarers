<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="users" />
</jsp:include>

<h2><spring:message code="players" /></h2>

<ul>
	<c:forEach items="${userList.players}" var="player">
		<li>
			<c:out value="${player.username}" />
		</li>
	</c:forEach>
</ul>

<h2><spring:message code="game.masters" /></h2>

<ul>
	<c:forEach items="${userList.gms}" var="gm">
		<li>
			<c:out value="${gm.username}" />
		</li>
	</c:forEach>
</ul>

<h2><spring:message code="administrators" /></h2>

<ul>
	<c:forEach items="${userList.admins}" var="admin">
		<li>
			<c:out value="${admin.username}" />
		</li>
	</c:forEach>
</ul>

<h2><spring:message code="inactive.users" /></h2>

<ul>
	<c:forEach items="${userList.inactives}" var="inactive">
		<li>
			<c:out value="${inactive.username}" />
		</li>
	</c:forEach>
</ul>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />