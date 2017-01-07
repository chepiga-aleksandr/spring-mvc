<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store</title>
</head>
<body>
<table border="1" style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Amount</th>
        <th>Action</th>
    </tr>
    <c:forEach var="ingredient" items="${ingredients}">
        <tr>
            <td>${ingredient.name}</td>
            <td>${ingredient.amount}</td>
            <td>
                <p><a href="/admin/store/update_IngredientId=${ingredient.id}">Edit</a></p>
                <p><a href="/admin/store/deleteIngredientId=${ingredient.id}">Delete</a></p>
            </td>
        </tr>
    </c:forEach>
</table><br>
<button onclick="location.href='/admin/store/createNewIngredient'">Create new ingredient</button>
</body>
</html>