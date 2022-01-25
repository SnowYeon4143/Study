<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈 화면 ~~~ </h1>
	
	<% 
		if(session.getAttribute("loginMember") != null) {
	%>
		아이디 : ${loginMember.id}<br>
		닉네임 : ${loginMember.nick}<br>
		나이 : ${loginMember.age}<br>
		<a href="member/logout"><button>로그아웃</button></a>
	<% 
		}else {
	%>
		로그인 해주세요 ~~~ <br>
		<a href="member/login">로그인 페이지로 가기</a>
	<% 
		}
	%>
	
	<!-- 게시글 등록 -->
	<br><br>
	<a href="board/insert">게시글 등록</a>
	
</body>
</html>