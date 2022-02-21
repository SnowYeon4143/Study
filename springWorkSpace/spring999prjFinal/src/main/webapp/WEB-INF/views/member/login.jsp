<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div id="div-main">
		<h1>로그인 페이지</h1>
		<form action="" method="post">
			아이디 : <input type="text" name="userId"> <br>
			비밀번호 : <input type="password" name="userPwd"> <br>
			<input type="submit" value="로그인">
		</form>
		<a href="${root}/member/join">회원가입</a>
	</div>
</body>
</html>