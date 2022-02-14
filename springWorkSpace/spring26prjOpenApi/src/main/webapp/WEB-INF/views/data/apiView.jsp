<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>미세먼지 조회 페이지</h1>
	
	<input type="text" id="numOfRows" placeholder="numOfRows">
	
	<button id="targetBtnXml">미세먼지 조회하기</button>
	
	<hr>
	
	<div id="targetDiv">
		
	</div>
	
	<!-- <table id="targetTable" border="1">
		<thead>
			<tr>
				<th>districtName</th>
				<th>issueDate</th>
				<th>issueGbn</th>
				<th>issueTime</th>
				<th>moveName</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table> -->
	
	<!-- xml 방식 -->
	<script type="text/javascript">
	$("#targetBtnXml").click(function() {
		let numOfRows = $("#numOfRows").val();
		$.ajax({
			url : "api-resp",
			data : {"numOfRows" : numOfRows},
			success : function(data) {
				alert("success ~~~");
				//console.log(data);
				
				//jquery > find 함수 사용하기
				const itemArr = $(data).find('item');
				console.log(itemArr);
				
				//테이블 만들기
				let $table = $('<table border="1" id="targetTable"></table>');
				let $thead = $('<thead></thead>');
				let $theadContent = $('<tr> <th>districtName</th> <th>issueDate</th> <th>issueGbn</th> <th>issueTime</th> <th>moveName</th> </tr>');
				let $tbody = $('<tbody></tbody>');
				
				$thead.append($theadContent);
				
				let tr = "";
				
				//요소 하나씩 접근
				$(itemArr).each(function(i, item) {
					tr = '<tr>'
					   + '<td>' + $(item).find('districtName').text() + '</td>'
					   + '<td>' + $(item).find('issueDate').text() + '</td>'
					   + '<td>' + $(item).find('issueGbn').text() + '</td>'
					   + '<td>' + $(item).find('issueTime').text() + '</td>'
					   + '<td>' + $(item).find('moveName').text() + '</td>'
					   + '</tr>'
					   ;
					   $tbody.append(tr);
				})//for end
				  
				//테이블 만들어서 targetDiv 안쪽에 넣기
				//조회 버튼을 여러번 눌러도 한번만 생성되게 하기
				$('#targetDiv').html("");
				$table.append($thead, $tbody)
					  .appendTo($('#targetDiv'));
				
			},
			error : function() {
				alert("error ~~~");
			} 
		})
	})
	</script>
	
	<!-- json 방식 -->
	<script type="text/javascript">
	$("#targetBtn").click(function(){
		let numOfRows = $("#numOfRows").val();
		$.ajax({
			url : "api-resp",
			data : {"numOfRows" : numOfRows},
			success : function(data){
				alert("success ~~~ ");
				const itemArr = data.response.body.items;
				
				//테이블 만들기
				let $table = $('<table border="1" id="targetTable"></table>');
				let $thead = $('<thead></thead>');
				let $theadContent = $('<tr> <th>districtName</th> <th>issueDate</th> <th>issueGbn</th> <th>issueTime</th> <th>moveName</th> </tr>');
				let $tbody = $('<tbody></tbody>');
				
				$thead.append($theadContent);
				
				
				//반복문 돌며, 우리가 원하는 데이터 얻기
				let tr = "";
				$(itemArr).each(function(i, item) {
					tr = 			'<tr>' 
								  + '<td>' + item.districtName + '</td>'
								  + '<td>' + item.issueDate + '</td>'
								  + '<td>' + item.issueGbn + '</td>'
								  + '<td>' + item.issueTime + '</td>'
								  + '<td>' + item.moveName + '</td>'
								  +'</tr>'
								  ;
					$tbody.append(tr);
				});
				
				//반복문 안에서 얻은 데이터들을 테이블에 넣기
				//table, thead랑 tbody
				//targetdiv에 넣기
				
				//let x = $table.append($thead, $tbody);
				$table.append($thead, $tbody).appendTo($("#targetDiv"));
				//$("#tagetdiv").append(x);
				
				/*
				let tbodyContent = "";
				$(itemArr).each(function(i, item) {
					tbodyContent += '<tr>'
						 + '<td>' + item.districtName + '</td>'
						 + '<td>' + item.issueDate + '</td>'	
						 + '<td>' + item.issueGbn + '</td>'	
						 + '<td>' + item.issueTime + '</td>'	
						 + '<td>' + item.moveName + '</td>'	
						 + '</tr>'
				});
				$("#targetTable tbody").html(tbodyContent);
				*/
				
				/*
				let tbodyContent = "";
				
				for(let i in itemArr){
					let item = itemArr[i];
					tbodyContent += '<tr>'
								 + '<td>' + item.districtName + '</td>'
								 + '<td>' + item.issueDate + '</td>'	
								 + '<td>' + item.issueGbn + '</td>'	
								 + '<td>' + item.issueTime + '</td>'	
								 + '<td>' + item.moveName + '</td>'	
								 + '</tr>'
				}
				$("#targetTable tbody").html(tbodyContent); 
				*/
			} 
			,
			error : function(){
				alert("error ~~~ ");
			}
		})
	});
	</script>
</body>
</html>