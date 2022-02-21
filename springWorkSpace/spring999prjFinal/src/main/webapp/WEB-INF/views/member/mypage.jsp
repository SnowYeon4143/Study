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

	<div id="div-main">
		<h1>마이페이지</h1>
		<form action="" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userNo" value="${loginUser.userNo}"><br>
			아이디 : <input type="text" name="userId" readonly="readonly" value="${loginUser.userId}"><br>
			비밀번호 : <input type="password" name="userPwd"><br>
			닉네임 : <input type="text" name="userNick" value="${loginUser.userNick}"><br>
			나이 : <input type="number" min="0" name="userAge" value="${loginUser.userAge}"><br>
			성별 : 
			<select name="userGender">
				<c:if test="${loginUser.userGender eq 'm'}">
				<option value="m" selected="selected">남자</option>				
				<option value="f">여자</option>
				</c:if>
				<c:if test="${loginUser.userGender ne 'm'}">
				<option value="m">남자</option>				
				<option value="f" selected="selected">여자</option>
				</c:if>
				
			</select><br>
			사진 : <input type="file" name="f" multiple="multiple" accept=".jpg, .png" onchange="preview();"><br>
			<div id="div-preview">
				
			</div>
			<input type="submit" value="정보수정">
		</form>
	
</body>
</html>