<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html
xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<script type="text/javascript" src="${root}/resources/js/home.js"></script>
	
	<div id="div-main">
		<h1>홈 페이지</h1>	
		<a href="${root}/resources/imgs/매출현황.xlsx" download="">테스트 다운로드</a>
	</div>
</body>
</html>