<%@page import="com.kh.app14.member.entity.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 목록 </h1>
	
	<form action="list" method="get">
		<select name="type">
			<option value="id">아이디</option>
			<option value="nick">닉네임</option>
			<option value="addr">주소</option>
			<option value="age">나이</option>
		</select>
		<input type="text" name="value">
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>주소</th>
				<th>나이</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<MemberDto> memberList = (List)request.getAttribute("memberList");
			for(MemberDto m : memberList){
			%>
				<tr>
					<td><% out.write(m.getId()); %></td>
					<td><%= m.getNick() %></td>
					<td><%= m.getAddr() %></td>
					<td><%= m.getAge() %></td>
					<td><%= m.getEnrollDate() %></td>
				</tr>
			<%
			}
			%>
			
		</tbody>
	</table>
	
</body>
</html>