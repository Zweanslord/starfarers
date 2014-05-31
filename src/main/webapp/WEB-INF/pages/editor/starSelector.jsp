<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Star Selector" />
</jsp:include>

<ul class="tabs">
	<c:forEach items="${galaxies}" var="otherGalaxy">
		<li <c:if test="${galaxy.id == otherGalaxy.id}">class="selected"</c:if>>
			<a href="${pageContext.request.contextPath}/editor/starSelector/${otherGalaxy.id}">${otherGalaxy.id}</a>
		</li>
	</c:forEach>
</ul>

<div id="galaxy-id" style="display: none;">${galaxy.id}</div>
<div id="galaxy-radius" style="display: none;">${galaxy.radius}</div>

<c:set var="height" value="60" />
<c:set var="width" value="${height / 2}" />
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />
<div id="star-radius" style="display: none;">${starRadius}</div>

<svg class="galaxy"
	 viewBox="0 0 ${height + galaxy.radius * 2 * (totalWidth + width) / 2} ${height + galaxy.radius * 2 * height}"
	 xmlns="http://www.w3.org/2000/svg"
     xmlns:xlink="http://www.w3.org/1999/xlink">
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
				<a xlink:href="${pageContext.request.contextPath}/editor/star/${galaxy.id}/${sector.coordinates.x}/${sector.coordinates.y}">
					<circle class="star" r="${starRadius}" cy="${starRadius}"/>
				</a>
			</c:if>
			<text y="-${starRadius}">${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />