<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<defs>
	<pattern id="star" patternUnits="userSpaceOnUse" width="50" height="50" patternTransform="translate(25,-12.5)">
		<image xlink:href="${pageContext.request.contextPath}/resources/images/star.png" x="0" y="0" width="50" height="50" />
	</pattern>
	
	<c:forEach items="${terrains}" var="terrain" varStatus="position">
		<pattern id="${terrain.noSpace}" patternUnits="userSpaceOnUse" width="100" height="60" patternTransform="translate(50,30)">
			<image xlink:href="${pageContext.request.contextPath}/resources/images/${terrain.noSpace}.png" x="0" y="0" width="100" height="60" />
	   	</pattern>
	</c:forEach>
</defs>