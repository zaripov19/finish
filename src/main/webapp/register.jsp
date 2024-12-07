<%--
  Created by IntelliJ IDEA.
  User: zarip
  Date: 12/6/2024
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form action="/auth/register" method="post">
    <input name="firstname" type="text" placeholder="FirstName">
    <br>
    <input name="lastname" type="text" placeholder="LastName">
    <br>
    <input name="email" type="text" placeholder="Email">
    <br>
    <input name="password" type="password" placeholder="Password">
    <br>
    <input name="passwordRepeat" type="password" placeholder="Password Repeat">
    <br>
    <button>Sign Up</button>
</form>
</body>
</html>
