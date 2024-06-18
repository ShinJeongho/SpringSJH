<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>날씨 정보 입력 페이지</h1>
	
	<form action="/weather/add" method="post">
		<div>
			<label for = "city">도시명</label>
			<input type="text" id = "city" name = "city">
		</div>
		<div>
			<label for = "temperature">온도</label>
			<input type="text" id = "temperature" name = "temperature">
		</div>
		<div>
			<label for = "status">날씨</label>
			<input type="text" id = "status" name = "status">
		</div>
		<div>
			<label for = "humidity">습도</label>
			<input type="text" id = "humidity" name = "humidity">
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	
	</form>
</body>
</html>