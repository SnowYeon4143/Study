<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>menu insert page</h1>
	
	<form action="insert" method="post">
		이름 : <input type="text" name="menu">
		<br>
		가격 : <input type="number" name="price">
		<br>
		<input type="submit" value="등록">
	</form>

</body>
</html>