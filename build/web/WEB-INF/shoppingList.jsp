<%-- 
    Document   : shoppingList
    Created on : Feb 10, 2020, 12:45:05 PM
    Author     : Phillip Obiora
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${sessionScope.user} <a href="ShoppingList?action=logout">Logout</a>
        
        <div>
            <h2>List</h2>
            <form action="ShoppingList" method="POST">
                Add Items: <input type="text" name="item">
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add">
            </form>
            
            <form action="ShoppingList" method="POST">
                <input type="hidden" name="action" value="delete">
                <c:forEach var="list" items="${sessionScope.itemList}">
                    <tr>
                        <td><input type="radio" name="item" value="${list}">${list}</td><br>
                    </tr>
                </c:forEach>
                <input type="submit" value="Delete">    
            </form>
            
        </div>
    </body>
</html>
