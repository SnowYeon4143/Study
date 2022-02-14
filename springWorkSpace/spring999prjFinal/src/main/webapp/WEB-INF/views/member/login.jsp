<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1>로그인 페이지</h1>
	
	<form action="" method="post">
		아이디 : <input type="text" name="id"> <br>
		비밀번호 : <input type="password" name="pwd"> <br>
		<input type="submit" value="로그인">
	</form>
	<a href="join">회원가입</a>
	
</body>
</html>