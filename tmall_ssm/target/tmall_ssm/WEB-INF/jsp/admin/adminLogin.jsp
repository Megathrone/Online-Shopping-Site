<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Iruka
  Date: 2018/3/25
  Time: 下午2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin login page</title>
</head>
<body>
<form action="admin_login" method="post">
    <input type="text" name="name"><br>
    <input type="password" name="password" id="">
    <input type="submit">
</form>
<c:if test="${!empty msg}">
    <h3>${msg}</h3>
</c:if>
<h1></h1>
</body>
</html>
