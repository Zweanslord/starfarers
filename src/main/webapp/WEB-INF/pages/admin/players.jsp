<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Player Administration" />
</jsp:include>

<c:choose>
	<c:when test="${success}">
		<div class="error">Wijzigingen waren succesvol.</div>
	</c:when>
	<c:when test="${not empty success && !success}">
		<div class="error">Wijzigingen zijn gefaald.</div>
	</c:when>
</c:choose>

<form:form modelAttribute="playerList" method="post">
	<form:errors path="playerViews" cssclass="error" />
	<c:forEach items="${playerList.playerViews}" varStatus="status">
		<fieldset>
			<form:hidden path="playerViews[${status.index}].id" />
			<form:label path="playerViews[${status.index}].name">Naam:</form:label>
			<form:input path="playerViews[${status.index}].name" />
			<form:errors path="playerViews[${status.index}].name" cssclass="error" />
			<form:checkbox path="playerViews[${status.index}].active" label="Active" />
			<form:checkbox path="playerViews[${status.index}].delete" label="Delete" />
		</fieldset>
	</c:forEach>
	<button type="submit" name="add">Voeg nieuwe speler toe</button>
	<button type="submit">Opslaan</button>
</form:form>

<jsp:include page="/WEB-INF/pages/include/footer.jsp" />