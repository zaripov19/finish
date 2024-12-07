<%--
  Created by IntelliJ IDEA.
  User: zarip
  Date: 12/6/2024
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/auth/login" method="post">
    <input type="text" placeholder="Email" name="email">
    <br/>
    <input type="password" placeholder="Password" name="password">
    <br>
    <button>Kirish</button>
    <a href="/register.jsp">Register</a>
</form>

</body>
</html>
