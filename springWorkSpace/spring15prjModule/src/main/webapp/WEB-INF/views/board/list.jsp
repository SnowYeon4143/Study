<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록 페이지</h1>
	
	<table border = "1">
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="b">
				<tr>
					<td><a href="detail/${b.title}">${b.title}</a></td>
					<td>${b.content}</td>
					<td>${b.writer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>