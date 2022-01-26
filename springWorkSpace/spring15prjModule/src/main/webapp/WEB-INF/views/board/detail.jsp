<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 페이지</h1>
	
	<form action="<%=request.getContextPath() %>/board/edit" method="post">
		<h2>제목 : <input type="text" name="title" value="${data.title}" readonly></h1>
		<hr>
		<div>
			내용<br>
			<input type="text" name="content" value="${data.content}">
		</div>
		<hr>
		<span>작성자 : <input type="text" name="writer" value="${data.writer}"></span><br>
		<input type="submit" value="수정하기" formaction="<%=request.getContextPath() %>/board/edit">
		<input type="submit" value="삭제하기" formaction="<%=request.getContextPath() %>/board/delete">		
	</form>
	
</body>
</html>