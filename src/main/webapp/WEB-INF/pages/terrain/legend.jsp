<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/pages/include/header.jsp">
	<jsp:param name="title" value="terrain.legend" />
</jsp:include>

<jsp:directive.include file="style.jsp" />

<%
Integer width = 36;
Double height = Math.sqrt(width * width - (width / 2) * (width / 2)) * 2;

pageContext.setAttribute("width", width);
pageContext.setAttribute("height", height);
%>
<c:set var="sideWidth" value="${width / 2}" />
<c:set var="totalWidth" value="${width + 2 * sideWidth}" />
<c:set var="starRadius" value="${height / 5}" />

<svg class="patterns"
	 xmlns="http://www.w3.org/2000/svg"
     version="1.1">
    <jsp:include page="patterns.jsp" />
</svg>

<div class="terrainLegend">
	<div id="star" class="legendItem">
		<div class="terrain">
			<svg class="galaxy" width="${totalWidth + 1}" height="${height + 1}">
				<g transform="translate(${totalWidth / 2 + 1},${height / 2})">
					<polygon class="space" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
					<circle class="star" r="${starRadius}" />
				</g>
			</svg>
		</div>
		<div class="explanation">
			<h2><spring:message code="star"/></h2>
			<p><spring:message code="star.explanation"/></p>
		</div>
	</div>

	<c:forEach items="${terrains}" var="terrain" varStatus="position">
		<div id="${terrain.noSpace}" class="legendItem">
			<div class="terrain">
				<svg class="galaxy" width="${totalWidth + 1}" height="${height + 1}">
					<g transform="translate(${totalWidth / 2},${height / 2})">
						<polygon class="${terrain.value}" points="-${width / 2},-${height / 2} -${totalWidth / 2},0 -${width / 2},${height / 2} ${width / 2},${height / 2} ${totalWidth / 2},0 ${width / 2},-${height / 2}" />
					</g>
				</svg>
			</div>
			<div class="explanation">
				<h2><spring:message code="${terrain.noSpace}"/></h2>
				<p><spring:message code="${terrain.noSpace}.explanation"/></p>
			</div>
		</div>
	</c:forEach>
</div>

<jsp:directive.include file="/WEB-INF/pages/include/footer.jsp" />