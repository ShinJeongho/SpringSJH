<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "d1">
		<h1>날씨 정보 리스트</h1>	
	</div>
	
	<table class = "tbl">
		<thead>
			<tr>
				<th>번호</th>
				<th>도시명</th>
				<th>온도</th>
				<th>날씨</th>
				<th>습도</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.dtos}" var="dtos">
				<tr>
					<td>${pageScope.dtos.num }</td>
					<td><a href="./detail?num=${pageScope.dtos.num }">${pageScope.dtos.city }</a></td>
					<td>${pageScope.dtos.temperature }</td>
					<td>${pageScope.dtos.status }</td>
					<td>${pageScope.dtos.humidity }</td>			
				</tr>	
			</c:forEach>
		</tbody>

	</table>
	
	
	<div>
		<a href = "/weather/add">날씨 등록</a>	
	</div>
</body>
</html>