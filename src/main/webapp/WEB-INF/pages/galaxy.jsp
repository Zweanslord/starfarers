<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Galaxy" />
</jsp:include>

<svg id="galaxy" height="1100" width="1500">
	<c:forEach items="${galaxy.sectors}" var="sector">
		<g transform="translate(${500 + 12 + sector.coordinates.x * 37},${500 + 0.3 + sector.coordinates.y * 50 + sector.coordinates.x * 25})">
			<polygon class="${sector.terrain}" points="0,0 -12,25 0,50 25,50 37,25 25,0" />
			<text y="2em" fill="white"><tspan class="q">${sector.coordinates.x}</tspan><tspan>,</tspan><tspan class="r">${sector.coordinates.y}</tspan></text>
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