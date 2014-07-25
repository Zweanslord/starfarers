<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="star" />
</jsp:include>

<c:set var="planetRadius" value="20" />
<c:set var="planetDiameter" value="${planetRadius * 2}" />
<c:set var="starRadius" value="70" />
<c:set var="planetDistance" value="30" />

<c:set var="resourceSize" value="${planetRadius / 2}" />
<c:set var="resourceOffset" value="${resourceSize}" />
<c:set var="resourceTextOffset" value="12" />

<%
Integer width = 36;
Double height = Math.sqrt(width * width - (width / 2) * (width / 2)) * 2;

pageContext.setAttribute("width", width);
pageContext.setAttribute("height", height);
%>
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />

<c:if test="${empty star}">
	No star found.
</c:if>

<svg class="starSystem"
	 viewBox="-${starRadius} 0 ${starRadius * 4} ${starRadius + (planetDiameter + planetDistance) * (star.planets.size() + 1)}"
	 xmlns="http://www.w3.org/2000/svg"
     xmlns:xlink="http://www.w3.org/1999/xlink">
	<c:if test="${not empty star}">
		<circle class="star" r="${starRadius}"/>
	</c:if>
	<g class="sector" transform="translate(${starRadius * 2}, ${height})">
		<a xlink:href="${pageContext.request.contextPath}/galaxy/${star.sector.galaxy.id}">
			<polygon class="${star.sector.terrain}" 
					 points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
			<text>${star.sector.coordinates.x}, ${star.sector.coordinates.y}</text>
		</a>
	</g>
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

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />