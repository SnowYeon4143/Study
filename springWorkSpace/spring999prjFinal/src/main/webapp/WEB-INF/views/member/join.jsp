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

	<h1>회원가입 페이지</h1>
	
	<form action="" method="post">
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="password" name="userPwd"><br>
		닉네임 : <input type="text" name="userNick"><br>
		나이 : <input type="number" min="0" name="userAge"><br>
		성별 : 
		<select name="userGender">
			<option value="m">남자</option>
			<option value="f">여자</option>
		</select><br>
		사진 : <input type="file" name="userProfile"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>