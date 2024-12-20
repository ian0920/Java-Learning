
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form method="post" action="<%=request.getContextPath()%>/add">
        <div>數字1: </div>
        <input type="text" name="num1">
        <div>數字2: </div>
        <input type="text" name="num2">
        <button type="submit">送出</button>
    </form>
</body>
</html>
