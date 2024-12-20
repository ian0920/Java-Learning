<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>Test Homepage</h2>

    <form method="post" action="<%=request.getContextPath()%>/login">
        <div>請輸入帳號</div>
        <input type="text" name="account"/>
        <div>請輸入密碼</div>
        <input type="password" name="password"/>
        <br>
        <input type="hidden" name="action" value="login">
        <button type="submit">登入</button>
    </form>

</body>
</html>
