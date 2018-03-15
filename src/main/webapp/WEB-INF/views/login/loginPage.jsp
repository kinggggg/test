<%--
  Created by IntelliJ IDEA.
  User: weibo_li
  Date: 2018/3/15
  Time: 上午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面1</title>
</head>
<body>
<form action="http://sso.server.com:10000/login" method="POST" enctype="application/x-www-form-urlencoded">
    用户名: <input type="text" name="username">
    <br />
    密码: <input type="password" name="password" />
    <input type="submit" value="提交" />
</form>
</body>
</html>
