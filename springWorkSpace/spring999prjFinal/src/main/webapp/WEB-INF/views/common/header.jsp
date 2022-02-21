<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="${root}/resources/css/common/header.css">

	<div id="div-header">
		<table border="1">
			<tr>
				<td>빈칸</td>
				<td colspan="2"><a href="${root}"><img width="100%" height="50px" src="${pageContext.request.contextPath}/resources/imgs/umm.png"></a></td>
				<c:if test="${empty loginUser}">
				<td>빈칸</td>
				</c:if>
				<c:if test="${not empty loginUser}">
				<td><a href="${root}/member/mypage"><img src="${root}/resources/upload/profile/${loginUser.changeName}"></a></td>
				</c:if>
			</tr>
			<tr>
				<td><a href="${root}/notice/list">공지사항</a></td>
				<td>메뉴2</td>
				<td>메뉴3</td>
				<c:if test="${empty loginUser}">
					<td>
					<a href="${root}/member/login">로그인</a>
					&nbsp/&nbsp
					<a href="${root}/member/join">회원가입</a>
					</td>
				</c:if>
				<c:if test="${not empty loginUser}">
					<td>
					${loginUser.userNick}
					<br>
					<a href="${root}/member/logout">로그아웃</a>
					</td>
				</c:if>
			</tr>
		</table>	
	</div>