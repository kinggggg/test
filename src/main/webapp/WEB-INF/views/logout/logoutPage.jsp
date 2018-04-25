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
    <title>登出操作</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
</head>
<body>
    <a href="http://cas.client1.com:9090/logout/logout1">这个是直接退出，走的是默认退出方式</a>
    <hr/>
    <a href="http://cas.client1.com:9090/logout/logout2">退出登录后，跳转到退成成功的页面，不走默认页面</a>
    <br>
    <a href="http://cas.client1.com:9090/logout/logout3">一个登出，全部登出</a>
</body>
</html>
