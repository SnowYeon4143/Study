<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookie check page</h1>
	
	<!-- 쿠키를 체크 -->
	<br>
	쿠키 > k01 있나요 ? ::: ${ not empty cookie.k01 }
	<br>
	쿠키 > k01 ::: ${ cookie.k01 }
	<br>
	쿠키 > k01 > name ::: ${ cookie.k01.name }
	<br>
	쿠키 > k01 > value ::: ${ cookie.k01.value }
	<br>
	
</body>
</html>