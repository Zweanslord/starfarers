<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy" />
</jsp:include>

<c:set var="height" value="60" />
<c:set var="width" value="${height / 2}" />
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />

<div class="galaxyVoid">
	<div class="galaxyHeight" style="display: none;">${height + galaxy.radius * 2 * (totalWidth + width) / 2}</div>
	<div class="galaxyWidth" style="display: none;">${height + galaxy.radius * 2 * height + 1}</div>
	<svg class="galaxy"
		viewBox="0 0 ${height + galaxy.radius * 2 * (totalWidth + width) / 2} ${height + galaxy.radius * 2 * height + 1}"
		xmlns="http://www.w3.org/2000/svg"
	    xmlns:xlink="http://www.w3.org/1999/xlink"
	    version="1.1"
	    preserveAspectRatio="xMidYMid meet">
		<c:forEach items="${galaxy.sectors}" var="sector">
			<g transform="translate(${totalWidth / 2 + galaxy.radius * (totalWidth + width) / 2 + sector.coordinates.x * (width + sideWidth)},${height / 2 + galaxy.radius * height + 0.3 + sector.coordinates.y * height + sector.coordinates.x * height / 2})">
				<polygon class="${sector.terrain}" 
					points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
				<c:if test="${sector.starSystem}">
					<a xlink:href="${pageContext.request.contextPath}/star/${galaxy.id}/${sector.coordinates.x}/${sector.coordinates.y}">
						<circle class="star" 
							r="${starRadius}" 
							cy="${starRadius}" />
					</a>
				</c:if>
				<text y="-${starRadius}">${sector.coordinates.x},${sector.coordinates.y}</text>
			</g>
		</c:forEach>
	</svg>
</div>

<div class="legendContainer">
	<div class="legendItem">
		<svg class="galaxy legend" width="${totalWidth + 2}" height="${height + 1}">
			<g transform="translate(${totalWidth / 2 + 1},${height / 2})">
				<polygon class="space" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
			</g>
			<g transform="translate(${height / 2 + 1}, ${height / 2})">
				<circle class="star" r="${starRadius}" />
			</g>
		</svg>
		<div class="description">star</div>
	</div>
	
	<c:forEach items="${terrains}" var="terrain" varStatus="position">
		<div class="legendItem">
			<svg class="galaxy legend" width="${totalWidth + 1}" height="${height + 1}">
				<g transform="translate(${totalWidth / 2},${height / 2})">
					<polygon class="${terrain.value}" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
				</g>
			</svg>
			<div class="description">${terrain.value}</div>
		</div>
	</c:forEach>
</div>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />