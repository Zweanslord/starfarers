<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="admin.user" />
</jsp:include>


<c:if test="${not empty created}">
	<p><spring:message code="create.user.success" arguments="${created}"/></p>
</c:if>
<c:if test="${not empty password}">
	<p><spring:message code="reset.password.user.success" arguments="${password}" /></p>
</c:if>
<c:if test="${not empty edited}">
	<p><spring:message code="edit.user.success" arguments="${edited}"/></p>
</c:if>
<c:if test="${not empty removed}">
	<p><spring:message code="remove.user.success" arguments="${removed}"/></p>
</c:if>


<table>
	<thead>
		<tr>
			<th><spring:message code="username" /></th>
			<th colspan="5"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>
					<c:choose>
						<c:when test="${user.enabled}">
							<spring:message code="enabled" />
						</c:when>
						<c:otherwise>
							<spring:message code="disabled" />
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:forEach items="${user.userRoles}" var="userRole">
						<spring:message code="user.role.${userRole.role.lowerCase}" />
					</c:forEach>
				</td>
				<td><a href="user/password?name=${user.username}"><spring:message code="reset.password.user" /></a></td>
				<td><a href="user/edit?name=${user.username}"><spring:message code="edit" /></a></td>
				<td><a href="user/remove?name=${user.username}"><spring:message code="remove" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p><a href="user/create"><spring:message code="create.user" /></a></p>

<jsp:include page="/WEB-INF/pages/include/footer.jsp" />