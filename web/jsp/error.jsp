<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 30.07.2019
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    Request from ${pageContext.errorData.requestURI} is failed <br>
    Servlet name or type: ${pageContext.errorData.servletName} <br>
    Status code: ${pageContext.errorData.statusCode} <br>
    Exception: ${pageContext.errorData.throwable}
</body>
</html>
