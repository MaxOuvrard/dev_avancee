<%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 25/03/2025
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="loginServlet" method="post">
        <label for="username">Login : </label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password : </label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="OK">
    </form>
</body>
</html>
