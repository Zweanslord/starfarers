<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Star" />
</jsp:include>

<c:set var="planetRadius" value="20" />
<c:set var="planetDiameter" value="${planetRadius * 2}" />
<c:set var="starRadius" value="70" />
<c:set var="planetDistance" value="30" />

<c:set var="resourceSize" value="${planetRadius / 2}" />
<c:set var="resourceOffset" value="${resourceSize}" />
<c:set var="resourceTextOffset" value="12" />

<svg class="starSystem" viewBox="-${starRadius} 0 ${starRadius * 4} ${starRadius + (planetDiameter + planetDistance) * (star.planets.size() + 1)}">
	<circle class="star" r="${starRadius}"/>
	<c:forEach items="${star.planets}" var="planet" varStatus="position">
		<g transform="translate(0, ${starRadius + (planetDiameter + planetDistance) * (position.index + 1)})">
			<circle class="${planet.type}" r="${planetRadius}" />
			<text x="${planetRadius + 10}" y="-${planetRadius / 2}">${planet.type}</text>
			
			<g class="ore" transform="translate(${planetRadius + 10}, ${resourceOffset})">
				<text>${planet.ore}</text>
				<polygon x="100" points="${resourceTextOffset},${resourceSize / 2} ${resourceTextOffset + resourceSize},${resourceSize / 2} ${resourceTextOffset + resourceSize / 2},${- resourceSize / 2}" />
			</g>
			
			<g class="gas" transform="translate(${planetRadius + 10 + (resourceSize + resourceTextOffset + 8) * 1}, ${resourceOffset})">
				<text>${planet.gas}</text>
				<circle r="${resourceSize / 2}" cx="${resourceSize / 2 + resourceTextOffset}"/>
			</g>
			
			<g class="fertility" transform="translate(${planetRadius + 10 + (resourceSize + resourceTextOffset + 8) * 2}, ${resourceOffset})">
				<text>${planet.fertility}</text>
				<rect width="${resourceSize}" height="${resourceSize}" x="${resourceTextOffset}" y="-${resourceSize / 2}" />
			</g>
		</g>
	</c:forEach>
</svg>

<form:form modelAttribute="star" method="post">
	<form:errors path="planets" cssclass="error" />
	<c:forEach items="${star.planets}" varStatus="status">
		<fieldset>
			<%-- <form:hidden path="planets[${status.index}].id" /> --%>
			<form:label path="planets[${status.index}].type">Type:</form:label>
			<form:select path="planets[${status.index}].type" items="${planetTypes}" itemValue="value" itemLabel="value" />
			<form:errors path="planets[${status.index}].type" cssclass="error" />
			
			<form:label path="planets[${status.index}].ore">Ore:</form:label>
			<form:input type="number" path="planets[${status.index}].ore" />
			<form:errors path="planets[${status.index}].ore" cssclass="error" />
			
			<form:label path="planets[${status.index}].gas">Gas:</form:label>
			<form:input type="number" path="planets[${status.index}].gas" />
			<form:errors path="planets[${status.index}].gas" cssclass="error" />
			
			<form:label path="planets[${status.index}].fertility">Fertility:</form:label>
			<form:input type="number" path="planets[${status.index}].fertility" />
			<form:errors path="planets[${status.index}].fertility" cssclass="error" />
		</fieldset>
	</c:forEach>
	<button type="submit">Opslaan</button>
</form:form>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />