<%-- 
    Document   : register
    Created on : Feb 10, 2020, 12:44:07 PM
    Author     : Phillip Obiora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username: <input type="text" name="username">
            <input type="submit" value="Register name">
            <!-- Hidden field to determine what is being sent in -->
            <input type="hidden" name="action" value="register">
        </form>
        ${message}
    </body>
</html>
