<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>enroll page</h1>
	
	<form action="" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name="content"><br>
		파일 : <input type="file" name="f" multiple accept=".jpg, .png"><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>