<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
		</div>
		<footer>
			<a href="?language=en">EN</a>
			<a href="?language=nl">NL</a>
			<c:if test="${empty param.hide}">
				<span class="user">
					<security:authorize access="!isAuthenticated()">
						<form:form action="${pageContext.request.contextPath}/login" method="post" class="login">               
							<label for="username"><spring:message code="username"/></label>
							<input type="text" id="username" name="username"/>        
							<label for="password"><spring:message code="password"/></label>
							<input type="password" id="password" name="password"/>    
							<input name="redirect" type="hidden" value="${requestScope['javax.servlet.forward.servlet_path']}"/>
							<button type="submit"><spring:message code="login"/></button>
						</form:form>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<spring:message code="starfarer"/> <strong><security:authentication property="principal.username" /></strong>
						<form:form action="${pageContext.request.contextPath}/logout" method="post" class="logout">
							<button type="submit">Log out</button>
						</form:form>
					</security:authorize>
				</span>
			</c:if>
			
			<span class="credits"><spring:message code="credits"/></span>
		</footer>
	</body>
</html>