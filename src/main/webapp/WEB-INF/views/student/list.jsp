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
	<h1>Student List</h1>
	
				<table>
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Avg</th>
        </tr>    
             <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.num}</td>
                <td>${student.name}</td>
                <td>${student.avg}</td>
            </tr>
        </c:forEach>
            
				</table>
				<a href="${pageContext.request.contextPath}/student/add">학생 추가</a>
</body>
</html>