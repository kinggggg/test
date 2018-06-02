<%--
  Created by IntelliJ IDEA.
  User: weibo_li
  Date: 2018/3/15
  Time: 上午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" session="true"%>
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
    <%--验证ST的node端接口地址--%>
    <input type="hidden" name="stVerificationFrontendUrl" value="http://cas.frontend1.com:8383/login/ssoLogin"/>
    <%--验证ST的后端接口地址--%>
    <input type="hidden" name="stVerificationBackendUrl" value="http://cas.client1.com:9090/login/ssoLogin"/>
    <input type="hidden" name="loginPageUrl" value="http://cas.frontend1.com:8383/login/loginPage"/>
    <input type="submit" value="提交" />
</form>
</body>
<script type="text/javascript">

    //sso server根据此url生成相应的ST
    var backendApiUrl = "http://cas.client1.com:9090/login/ssoLogin" ;
    //sso server根据backendApiUrl生成ST后，需要重定向到node端一个地址，此地址用于接受生成的ST，并通过redirectLocation调用backendApiUrl（带上生成的ST）。这一步的操作有两个目的
    //两个目的：第一个目的：验证ST；第二个目的：建立局部回话
    var redirectLocation = "http://cas.frontend1.com:8383/login/ssoLogin" ;

    $(document).ready(function(){
        $.ajax({
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            dataType:'jsonp',
            jsonp: "jsonpCallback",
            url: "http://sso.server.com:10000/cookie?backendApiUrl="+ backendApiUrl +"&redirectLocation=" + redirectLocation,
            success: function(data){
                window.location.href = data.key;
                console.log(data);
            }
        });
    });
</script>
</html>
