<%--
  Created by IntelliJ IDEA.
  User: weibo_li
  Date: 2018/3/15
  Time: 上午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>books页面</title>
</head>
<body>
    books页面, book列表
<br>
    <c:forEach items="${books}" var="book">
        <c:out value="${book.name}"/>, <c:out value="${book.price}"/>, <br>
    </c:forEach>
</body>
</html>
