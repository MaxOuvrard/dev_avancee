<%@ page import="com.example.dev_avancee3.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: maxen
  Date: 25/03/2025
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goodbye</title>
</head>
<body>
<%
    String goodbye = "";
    if (request.getSession(false) != null) {
    UserBean user = (UserBean) request.getSession().getAttribute("user");
    if (user != null) {
        goodbye = "GoodBye " + user.getNom();
    } else {
        goodbye = "GoodBye";
    }
}
%>
<h1><%= goodbye %></h1>
<p> Merci de votre visite</p>
</body>
</html>
