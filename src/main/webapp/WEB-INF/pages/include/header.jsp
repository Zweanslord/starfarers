<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title><spring:message code="title.${param.title}" /></title>
		<meta charset="utf-8" />
		<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/galaxy.png" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/button.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/star.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/terrain.css" />
		<script src="${pageContext.request.contextPath}/resources/javascript/jquery/jquery-2.1.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/jquery/jquery-svgpan.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/galaxyEditor.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/galaxyInteraction.js"></script>
	</head>
	<body>
		<header>
			<a href="${pageContext.request.contextPath}/">Starfarers</a>
		</header>
		<div class="content">
			<h1><spring:message code="title.${param.title}" /></h1>