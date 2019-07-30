<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 30.07.2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="LoginForm" method="post" action="controller">
    <input type="hidden" name="command" value="login">
    Login: <br/>
    <input type="text" name="login" value="">
    <br/>Password:<br/>
    <input type="password" name="password" value=""> <br/>
    ${errorLoginPassMessage} <br/>
    ${wrongAction} <br/>
    ${nullPage} <br/>
    <input type="submit" value="Login">
</form>
<hr/>
</body>
</html>
