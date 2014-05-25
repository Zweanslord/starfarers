<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="Star" />
</jsp:include>

<c:set var="planetRadius" value="20" />
<c:set var="planetDiameter" value="${planetRadius * 2}" />
<c:set var="starRadius" value="70" />

<svg class="starSystem" viewBox="-${starRadius} 0 ${starRadius * 3} ${starRadius + (planetDiameter + 20) * (star.planets.size() + 1)}">
	<circle class="star" r="${starRadius}"/>
	<c:forEach items="${star.planets}" var="planet" varStatus="position">
		<g transform="translate(0, ${starRadius + (planetDiameter + 20) * (position.index + 1)})">
			<circle class="${planet.type}" r="${planetRadius}" />
			<text x="${planetRadius + 10}">${planet.type}</text>
		</g>
	</c:forEach>
</svg>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />