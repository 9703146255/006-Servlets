<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
</head>
<body>
    <h1>Products List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Buyer</th>
        </tr>
        <c:forEach var="products" items="${products}">
            <tr>
                <td>${products.id}</td>
                <td>${products.name}</td>
                <td>${products.price}</td>
                <td>${products.buyer}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
