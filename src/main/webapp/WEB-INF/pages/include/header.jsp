<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/star.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/terrain.css" />
		<script src="${pageContext.request.contextPath}/resources/javascript/jquery/jquery-2.1.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/galaxyEditor.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/starSelection.js"></script>
	</head>
	<body>
		<header>
			<a href="${pageContext.request.contextPath}">Starfarers</a>
		</header>
		<div class="content">
			<h1>${param.title}</h1>