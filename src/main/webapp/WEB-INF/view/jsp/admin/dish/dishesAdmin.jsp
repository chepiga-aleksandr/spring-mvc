<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="align-items: center">
    <tr class="title">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Photo</th>
        <th>ListOfIngredient</th>
        <th>Action</th>
    </tr>
    <c:forEach var="dish" items="${dishes}">
        <tr>
            <td>${dish.name}</td>
            <td>${dish.weight}</td>
            <td>${dish.price}</td>
            <td><img src="${dish.photo}" width="100"></td>
            <td><c:forEach items="${dish.listOfIngredient}" var="listOfIngredient">
                <ul>
                    <li>${listOfIngredient.name}</li>
                </ul>

            </c:forEach></td>

            <td>
                <p><a href="/admin/dish/update_DishId=${dish.id}">Edit</a></p>
                <p><a href="/admin/dish/deleteDishId=${dish.id}">Delete</a></p>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<button onclick="location.href='/admin/dish/newDish'">Create new dish</button>

</body>
</html>
