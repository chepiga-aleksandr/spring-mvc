<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Photo</th>
        <th>List of ingredients</th>
    </tr>
    <tr>
        <td>${dish.name}</td>
        <td>${dish.weight}</td>
        <td>${dish.price}</td>
        <td><img src="${dish.photo}" width="200"></td>
        <td><c:forEach items="${dish.listOfIngredient}" var="listOfIngredient">
            <ul>
                <li>${listOfIngredient.name}</li>
            </ul>
        </c:forEach></td>
    </tr>
</table>

</body>
</html>
