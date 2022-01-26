<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="id"><br><br>	
		비밀번호 : <input type="text" name="pwd"><br><br>
		닉네임 : <input type="text" name="nick"><br><br>
		프로필 사진 : <input type="file" name="profileList" multiple accept=".jpg, .png"><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>