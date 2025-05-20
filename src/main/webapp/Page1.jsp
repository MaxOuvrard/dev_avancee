<%@ page import="com.example.dev_avancee4.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 25/03/2025
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 1</title>
</head>
<body>
<%
    UserBean user = (UserBean) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<a href="logoutServlet.do">LogOut</a>
<h1>Welcome, <%= user.getNom() %></h1>
<form action="updateAttributesServlet.do" method="post">
    <label for="attribut2">Attribut2</label>
    <input type="text" id="attribut2" name="attribut2" value="<%= user.getAttribut1() %>" required>
    <br/>
    <label for="attribut3">Attribut3</label>
    <input type="text" id="attribut3" name="attribut3" value="<%= user.getAttribut2()%>" required>
    <br/>
    <input type="submit" value="Modifier">
</form>
</body>
</html>
