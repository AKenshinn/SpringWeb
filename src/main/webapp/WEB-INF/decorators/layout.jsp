<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html>
<head>
	<title><decorator:title /></title>
	<!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/jQuery.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/assets/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/bootstrap/css/bootstrap.min.css" />
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/font-awesome/css/font-awesome.min.css" />
	<decorator:head />
</head>
<body>
	<div class="container">
		<decorator:body />
	</div>
</body>
</html>
