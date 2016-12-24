<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Add ingredients to dish ${dishName}</p>
<p>Select ingredients to add:</p>
<form action="/admin/addIngredientToDish/${dishName}" method="post">
    <c:forEach items="${ingredientsToAdd}" var="ingr">
        <p><input type="checkbox" name="ingredient" value="${ingr.name}">${ingr.name}</p>
    </c:forEach>
    <p><input type="submit" value="Add ingredient to dish"></p>
</form>
<button onclick="location.href='/admin/addIngredientToList'">Add ingredient to list</button>
</body>
</html>
