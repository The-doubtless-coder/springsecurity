<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/26/2023
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is the welcome page</title>
</head>
<body>
<div style="min-height: 100vh; display: flex; justify-content: center; align-items: center">
    <h2 style="text-align: center">You've logged in successfully</h2>
    <a style="display: block; text-decoration: none; color: chocolate" href="/org.example/v1/admin">Move to the admin
        page</a>
    <a style="display: block; text-decoration: none; color: chocolate" href="/org.example/v1/employee">Move to the
        employee page</a>
    <a style="display: block; text-decoration: none; color: chocolate" href="/org.example/v1/student">Move to the
        student page</a>
    <a style="display: block; text-decoration: none; color: chocolate" href="/logout">Leave the application</a>
</div>
</body>
</html>
