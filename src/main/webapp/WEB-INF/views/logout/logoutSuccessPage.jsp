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
    <title>登出成功</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
</head>
<body>
    <h1>退出成功</h1>
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
            url: "http://sso.server.com:10000/logout/invalidCookie",
            success: function(data){
//                window.location.href = data.key;
//                console.log(data);
            }
        });
    });
</script>
</html>
