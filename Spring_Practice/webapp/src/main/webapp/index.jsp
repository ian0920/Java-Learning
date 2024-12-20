<%--
  Created by IntelliJ IDEA.
  User: ian55
  Date: 10/29/2024
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event Coupon Demo</title>

</head>
<body>

<h1>活動優惠券後台系統</h1>

<br><br>

<form action="${pageContext.request.contextPath}/EventCoupon" method="get">
    <p><label>使用活動優惠券Id查詢</label></p>
    <input type="text" name="id"><br>

    <p><input type="submit" value="送出"></p>
    <input type="hidden" name="action" value="getFormId">
</form>

</body>
</html>
