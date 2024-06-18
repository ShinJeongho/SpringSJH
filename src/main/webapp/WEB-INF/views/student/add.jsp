<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h1>Add Student</h1>
    <form action="${pageContext.request.contextPath}/student/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="num">Number:</label>
        <input type="text" id="num" name="num"><br>
        <label for="avg">Average:</label>
        <input type="text" id="avg" name="avg"><br>
        <input type="submit" value="Add Student">
    </form>
</body>
</html>