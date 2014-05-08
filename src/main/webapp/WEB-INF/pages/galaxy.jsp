<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy" />
</jsp:include>

<svg class="galaxy legend" width="${49 * 2.5 * terrains.size()}">
	<c:forEach items="${terrains}" var="terrain" varStatus="position">
		<g transform="translate(${5 + 24.5 + position.index * 49 * 2.5},30)">
			<polygon class="${terrain.value}" points="-12.5,-25 -24.5,0 -12.5,25 12.5,25 24.5,0 12.5,-25" />
			<text y="49">${terrain.value}</text>
		</g>
	</c:forEach>
</svg>

<svg class="galaxy" height="${50 + galaxy.radius * 2 * 50}" width="${49 + galaxy.radius * 2 * (49+25) / 2}">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${24.5 + galaxy.radius * (49+25) / 2 + sector.coordinates.x * 37},${25 + galaxy.radius * 50 + 0.3 + sector.coordinates.y * 50 + sector.coordinates.x * 25})">
			<polygon class="${sector.terrain}" points="-12.5,-25 -24.5,0 -12.5,25 12.5,25 24.5,0 12.5,-25" />
			<text>${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />