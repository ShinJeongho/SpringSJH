<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>날씨 정보 검색 페이지</h1>
	
	<!-- 스코프 범위.request의 key값.setmethod 이름(set은 떼고 앞글자를 소문자로 바꾼다) -->
	<h3>${requestScope.dto.city }</h3>
	<h3>${requestScope.dto.temperature }</h3>
	<h3>${requestScope.dto.status }</h3>
	<h3>${requestScope.dto.humidity }</h3>
	
	<form id = "frm" action = "./delete" method="post">
		<input type = "hidden" name = "num" value = "${requestScope.dto.num}" >
	</form>
	
	<button id = "btn">삭제하기</button>
	<button id = "up">수정하기</button>
	
	<script>
		
	 const btn = document.getElementById("btn");
	 const frm = document.getElementById("frm");
	 const up = document.getElementById("up");
	 
	 up.addEventListener("click", function() {
		 	frm.method = "get";
		 	frm.action = "./update";
			frm.submit();
	 })

	 btn.addEventListener("click", function() {
		frm.submit();
	 })

	</script>
</body>
</html>