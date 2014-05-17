<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy" />
</jsp:include>

<c:set var="height" value="60" />
<c:set var="width" value="${height / 2}" />
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />

<svg class="galaxy legend" width="${5 + height * 1/5 + totalWidth * 2.5 * terrains.size()}">
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

<svg class="galaxy" height="${height + galaxy.radius * 2 * height}" width="${height + galaxy.radius * 2 * (totalWidth + width) / 2}">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${totalWidth / 2 + galaxy.radius * (totalWidth + width) / 2 + sector.coordinates.x * (width + sideWidth)},${height / 2 + galaxy.radius * height + 0.3 + sector.coordinates.y * height + sector.coordinates.x * height / 2})">
			<polygon class="${sector.terrain}" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
			<c:if test="${sector.starSystem}">
				<circle r="${starRadius}" cy="${starRadius}"/>
			</c:if>
			<text y="-${starRadius}">${sector.coordinates.x},${sector.coordinates.y}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />