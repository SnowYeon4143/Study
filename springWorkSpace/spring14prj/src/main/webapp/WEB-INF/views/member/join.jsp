<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form action="join" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pwd"><br>
		닉네임 : <input type="text" name="nick"><br>
		주소 : <input type="text" name="addr"><br>
		나이 : <input type="number" name="age"><br>		
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>