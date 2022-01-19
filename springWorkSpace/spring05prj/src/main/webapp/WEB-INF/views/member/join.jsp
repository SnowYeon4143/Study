<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>join</h1>
	<form action="join" method="post">
		<!-- id, pwd, nick -->
		id : <input type="text" name="id">
		<br>
		pwd : <input type="text" name="pwd">
		<br>
		nick : <input type="text" name="nick">
		<br>
		age : <input type="number" name="age">
		<input type="submit" value="가입">
	</form>
</body>
</html>