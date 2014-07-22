<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy" />
</jsp:include>

<%
Integer width = 36;
Double height = Math.sqrt(width * width - (width / 2) * (width / 2)) * 2;

pageContext.setAttribute("width", width);
pageContext.setAttribute("height", height);
%>
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />

<jsp:directive.include file="terrain/style.jsp" />

<div class="galaxyVoid">
	<div class="buttons">
		<button id="centerMap" class="mapButton">Center</button>
		<button id="fullScreen" class="mapButton">Full Screen</button>
	</div>
	<div id="galaxyHeight" style="display: none;">${height + galaxy.radius * 2 * (totalWidth + width) / 2}</div>
	<div id="galaxyWidth" style="display: none;">${(galaxy.radius * 2 + 1) * totalWidth + 1}</div>
	<svg class="galaxy interaction"
		xmlns="http://www.w3.org/2000/svg"
	    xmlns:xlink="http://www.w3.org/1999/xlink"
	    version="1.1">
	    <jsp:include page="terrain/patterns.jsp" />
	    
 		<g id="viewport" transform="translate(0,0)">
			<c:forEach items="${galaxy.sectors}" var="sector">
				<g class="sector" transform="translate(${totalWidth / 2 + galaxy.radius * (totalWidth + width) / 2 + sector.coordinates.x * (width + sideWidth)},${height / 2 + galaxy.radius * height + 0.3 + sector.coordinates.y * height + sector.coordinates.x * height / 2})">
					<polygon class="${sector.terrain}" 
						points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
					<c:if test="${sector.starSystem}">
						<circle class="star" 
								r="${starRadius}" 
								cy="${starRadius}" />
					</c:if>
					<text y="-${starRadius}">${sector.coordinates.x},${sector.coordinates.y}</text>
				</g>
			</c:forEach>
		</g>
	</svg>
</div>

<div class="legendContainer">
	<div class="legendItem">
		<svg class="galaxy legend" width="${totalWidth + 2}" height="${height + 1}">
			<g transform="translate(${totalWidth / 2 + 1},${height / 2})">
				<polygon class="space" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
			</g>
			<g transform="translate(${width}, ${height / 2})">
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