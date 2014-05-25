<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy Editor" />
</jsp:include>

<ul class="tabs">
	<li <c:if test="${galaxy.id == null}">class="selected"</c:if>>
		<a href="${pageContext.request.contextPath}/editor/galaxy">Nieuw</a>
	</li>
	<c:forEach items="${galaxies}" var="otherGalaxy">
		<li <c:if test="${galaxy.id == otherGalaxy.id}">class="selected"</c:if>>
			<a href="${pageContext.request.contextPath}/editor/selectgalaxy?id=${otherGalaxy.id}">${otherGalaxy.id}</a>
		</li>
	</c:forEach>
</ul>

<c:if test="${galaxy.id == null}">
	<form:form id="galaxyFeatures" modelAttribute="galaxyFeatures" method="post" action="${pageContext.request.contextPath}/editor/galaxy">
		<fieldset>
			<form:label path="radius">Radius:</form:label>
			<form:input path="radius" />
			<form:errors path="radius" cssclass="error" />
		</fieldset>
		<button type="submit" name="generate">Genereer</button>
	</form:form>
</c:if>

<button id="saveGalaxy">Sla op</button>

<c:if test="${galaxy.id != null}">
	<form:form method="post" action="${pageContext.request.contextPath}/editor/galaxy/delete?id=${galaxy.id}">
		<button type="submit">Verwijder</button>
	</form:form>
</c:if>

<div id="galaxy-id" style="display: none;">${galaxy.id}</div>
<div id="galaxy-radius" style="display: none;">${galaxy.radius}</div>

<div id="saveGalaxySuccess" style="display: none;">Succesvol opgeslagen.</div>
<div id="saveGalaxyFailure" style="display: none;">Opslaan gefaald.</div>

<c:set var="height" value="60" />
<c:set var="width" value="${height / 2}" />
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />
<div id="star-radius" style="display: none;">${starRadius}</div>

<div class="paintBar">
	<svg class="galaxy legend paint" viewBox="0 0 ${5 + height * 1/5 + totalWidth * 2.5 * terrains.size()} ${height + height / 2 + 10}">
		<g transform="translate(${5 + height / 2}, ${5 + height / 2})">
			<circle class="star" r="${starRadius}" />
			<text y="${height / 2 + 20}">star</text>
		</g>
		<c:forEach items="${terrains}" var="terrain" varStatus="position">
			<g transform="translate(${5 + height * 1.5 + totalWidth / 2 + position.index * totalWidth * 2.5},${5 + height / 2})">
				<polygon class="${terrain.value}" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
				<text y="${height / 2 + 20}">${terrain.value}</text>
			</g>
		</c:forEach>
	</svg>
</div>
<button class="paintBarOpener"></button>

<svg class="galaxy editor"
	viewBox="0 0 ${height + galaxy.radius * 2 * (totalWidth + width) / 2} ${height + galaxy.radius * 2 * height}">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${totalWidth / 2 + galaxy.radius * (totalWidth + width) / 2 + sector.coordinates.x * (width + sideWidth)},${height / 2 + galaxy.radius * height + 0.3 + sector.coordinates.y * height + sector.coordinates.x * height / 2})">
			<polygon class="${sector.terrain}" 
				data-id="${sector.id}"
				data-x="${sector.coordinates.x}" 
				data-y="${sector.coordinates.y}" 
				data-terrain="${sector.terrain}"
				data-starSystem="${sector.starSystem}"
				points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
			<c:if test="${sector.starSystem}">
				<circle class="star" r="${starRadius}" cy="${starRadius}"/>
			</c:if>
			<text y="-${starRadius}">${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />