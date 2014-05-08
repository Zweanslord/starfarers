<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy Editor" />
</jsp:include>

<form:form modelAttribute="galaxyFeatures" method="post">
	<fieldset>
		<form:label path="radius">Radius:</form:label>
		<form:input path="radius" />
		<form:errors path="radius" cssclass="error" />
	</fieldset>
	<button type="submit" name="generate">Genereer</button>
</form:form>

<svg class="galaxy" height="${50 + galaxy.radius * 2 * 50}" width="${49 + galaxy.radius * 2 * (49+25) / 2}">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${24.5 + galaxy.radius * (49+25) / 2 + sector.coordinates.x * 37},${25 + galaxy.radius * 50 + 0.3 + sector.coordinates.y * 50 + sector.coordinates.x * 25})">
			<polygon class="${sector.terrain}" points="-12.5,-25 -24.5,0 -12.5,25 12.5,25 24.5,0 12.5,-25" />
			<text>${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<div>
	<c:forEach items="${galaxy.sectors}" var="sector">
		<div>
			x: ${sector.coordinates.x}, y: ${sector.coordinates.y}, z: ${sector.coordinates.z}, ${sector.terrain}
		</div>
	</c:forEach>
</div>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />