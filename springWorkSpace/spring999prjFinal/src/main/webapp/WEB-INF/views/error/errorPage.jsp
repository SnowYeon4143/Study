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

	<h1>에러페이지 ~~~</h1>
	<h2 id="msg">${msg}</h2>
	
	<script type="text/javascript">
		alert(document.getElementById('msg').innerText); //메세지 띄우기
		window.location.href="${root}"; //홈 화면으로 보내기
	</script>
</body>
</html>