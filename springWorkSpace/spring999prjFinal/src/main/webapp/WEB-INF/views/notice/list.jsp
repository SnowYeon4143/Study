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
		<h1>공지사항</h1>
	
		<table border="1" style="margin:auto;">
			<thead>
				<tr>
					<td><input type="checkbox"></td>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성시간</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="n">
					<tr>
						<td><input type="checkbox" class="checkbox-del" value="${n.no}"></td>
						<td>${n.no}</td>
						<td>${n.title}</td>
						<td>${n.userNick}</td>
						<td>${n.enroll}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="${root}/notice/write">공지 작성</a>
		<button onclick="del();">삭제하기</button>
		
		<div style="width: 100%">
		<div style="vertical-align: middle; text-align: center">
		<!-- 페이지 start -->
		<c:if test="${page.startPage != 1}">
			<a href="${page.startPage -1}">이전</a>
		</c:if>
		<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
			<c:if test="${page.currentPage != i and i <= page.lastPage}"><a href="${i}">${i}</a> &nbsp</c:if>
			<c:if test="${page.currentPage == i and i <= page.lastPage}">${i} &nbsp</c:if>
		</c:forEach>
		<c:if test="${page.endPage < page.lastPage}">
			<a href="${page.endPage +1}">다음</a>
		</c:if>
		<!-- 페이지 end -->
		</div>
		</div>
	</div>
	
	<script type="text/javascript">
		//상단 체크박스 클릭하면, 전체 체크박스 클릭되게
		let topCheckBox = document.querySelector('thead input[type=checkbox]');
		
		let delArr = document.getElementsByClassName('checkbox-del');
		
		topCheckBox.onchange = function(e) {
			//console.log(e.target.checked);
			//console.log(this.checked);
			if(this.checked) {				
				//체크 돼면 전부 다 체크
				for(let i = 0; i<delArr.length; i++) {
					delArr[i].checked = true;
				}
				
			} else{				
				//체크 안돼면 전부 다 체크해제
				for(let i = 0; i<delArr.length; i++) {
					delArr[i].checked = false;
				}
			}
		}
		
		//삭제 버튼 클릭
		function del() {
			//삭제할 번호들 가져오기
			//가져온 번호들을 ,,, 하나의 문자열로 합치기
			let result = "";
			let delArr = document.getElementsByClassName('checkbox-del');
			
			for(let i = 0; i < delArr.length; i++) {
				let t = delArr[i];
				if(t.checked) {
					//console.log(t.parentNode.parentNode.children[1].innerText); //번거로운 방법
					console.log(t.value); //체크박스에 value를 넣어줌
					result += t.value + ',';
				}
			}
			
			//삭제 요청 보내기 (삭제할 번호 전달해주면서)
			$.ajax({
				url : "${root}/notice/delete",
				data : {"str" : result},
				type : 'post',
				success : function(data) {
					console.log(data);
				},
				error : function(e) {
					console.log(e);
				},
				complete : function() {
					//새로고침
					window.location.reload();
				}
			});
		}
	</script>
	
</body>
</html>