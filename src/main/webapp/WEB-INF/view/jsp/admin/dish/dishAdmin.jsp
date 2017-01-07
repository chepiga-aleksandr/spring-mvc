<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/admin/dish/updateDishId=${dish.id}" method="post">
<table border="1">
    <tr>
        <td>Name</td>
        <td><input autocomplete="off" type="text" name="dishName" value="${dish.name}"></td>
    </tr>
    <tr>
        <td>Weight</td>
        <td><input autocomplete="off" type="number" name="dishWeight" value="${dish.weight}"></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input autocomplete="off" type="number" name="dishPrice" value="${dish.price}"></td>
    </tr>
    <tr>
        <td>Photo</td>
        <td><img src="${dish.photo}" width="200"></td>
    </tr>
    <tr>
        <td>List of ingredients<br>

        <p><a href="/admin/dish/addIngredientToDish/${dish.name}">Add ingredients</a></p>

        <p><a href="/admin/dish/deleteIngredientFromDish/${dish.name}">Delete ingredients</a></p></td>

        <td><c:forEach items="${dish.listOfIngredient}" var="listOfIngredient">
            <ul>
                <li>${listOfIngredient.name}</li>
            </ul>
        </c:forEach></td>
    </tr>
</table>

<button>Submit</button>

</form>

</body>
</html>
