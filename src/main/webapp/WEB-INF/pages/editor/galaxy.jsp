<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy Editor" />
</jsp:include>

<ul>
	<li><a href="${pageContext.request.contextPath}/editor/galaxy">Nieuw</a></li>
	<c:forEach items="${galaxies}" var="otherGalaxy">
		<li><a href="${pageContext.request.contextPath}/editor/selectgalaxy?id=${otherGalaxy.id}">${otherGalaxy.id}</a></li>
	</c:forEach>
</ul>

<form:form modelAttribute="galaxyFeatures" method="post" action="${pageContext.request.contextPath}/editor/galaxy">
	<fieldset>
		<form:label path="radius">Radius:</form:label>
		<form:input path="radius" />
		<form:errors path="radius" cssclass="error" />
	</fieldset>
	<button type="submit" name="generate">Genereer</button>
</form:form>

<button id="saveGalaxy">Sla op</button>
<div id="galaxy-id">${galaxy.id}</div>
<div id="galaxy-radius" style="display: none;">${galaxy.radius}</div>
<div id="saveGalaxySuccess" style="display: none;">Succesvol opgeslagen.</div>
<div id="saveGalaxyFailure" style="display: none;">Opslaan gefaald.</div>

<svg class="galaxy legend paint" width="${49 * 2.5 * terrains.size()}">
	<c:forEach items="${terrains}" var="terrain" varStatus="position">
		<g transform="translate(${5 + 24.5 + position.index * 49 * 2.5},30)">
			<polygon class="${terrain.value}" points="-12.5,-25 -24.5,0 -12.5,25 12.5,25 24.5,0 12.5,-25" />
			<text y="49">${terrain.value}</text>
		</g>
	</c:forEach>
</svg>

<svg class="galaxy editor" height="${50 + galaxy.radius * 2 * 50}" width="${49 + galaxy.radius * 2 * (49+25) / 2}">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${24.5 + galaxy.radius * (49+25) / 2 + sector.coordinates.x * 37},${25 + galaxy.radius * 50 + 0.3 + sector.coordinates.y * 50 + sector.coordinates.x * 25})">
			<polygon class="${sector.terrain}" 
				data-id="${sector.id}"
				data-x="${sector.coordinates.x}" 
				data-y="${sector.coordinates.y}" 
				data-terrain="${sector.terrain}"
				points="-12.5,-25 -24.5,0 -12.5,25 12.5,25 24.5,0 12.5,-25" />
			<text>${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />