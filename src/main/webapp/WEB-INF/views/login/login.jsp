<%--
  Created by IntelliJ IDEA.
  User: weibo_li
  Date: 2018/2/24
  Time: 下午4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="https://cas.server.com:8443/cas/login" id="fm1" method="POST">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input id="username" name="username" type="text"></td>
        </tr>
        <tr>
            <td>密 码:</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr>
            <td>
                <input type="hidden" name="execution" value="xxxxxx53">
                <input type="hidden" name="_eventId" value="submit">
                <input type="submit" value="登录">
            </td>
            <td><input type="reset"></td>
        </tr>
    </table>
</form>

</body>
</html>
