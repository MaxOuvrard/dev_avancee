<%@ page import="com.example.dev_avancee.UserBean" %><%--
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
<a href="logoutServlet">LogOut</a>
 <h1>Welcome, <%= user.getNom() %></h1>
<form action="updateAttributesServlet" method="post">
    <label></label>
</form>
</body>
</html>
