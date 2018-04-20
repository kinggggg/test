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
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
</head>
<body>
<form action="http://sso.server.com:10000/login" method="POST" enctype="application/x-www-form-urlencoded">
    用户名: <input type="text" name="username">
    <br />
    密码: <input type="password" name="password" />
    <input type="submit" value="提交" />
</form>
</body>
<script type="text/javascript">

    $(document).ready(function(){
        $.ajax({
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            dataType:'jsonp',
            jsonp: "jsonpCallback",
            url: "http://sso.server.com:10000/cookie?backendApiUrl=http://cas.client1.com:9090/api/list&redirectLocation=http://cas.frontend1.com:8383/api/list",
            success: function(data){
                window.location.href = data.key;
                console.log(data);
            }
        });
    });
</script>
</html>
