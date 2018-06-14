<%--
  Created by IntelliJ IDEA.
  User: sean
  Date: 6/11/2018
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Yahoo From JSP</title>
</head>
<body>
    <p><font color="red"> ${errorMessage}</font></p>
    <form action="/login" method="POST">
    Name: <input type="text" name="name"/>
    Password:<input type="password" name="password"/>
    <input type="submit"/>
</form>

</body>
</html>
