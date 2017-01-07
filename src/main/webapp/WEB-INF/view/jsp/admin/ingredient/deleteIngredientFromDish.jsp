<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Delete ingredient from dish ${dishName}</p>
<p>Select ingredient to delete:</p>
<form action="/admin/dish/deleteIngredientFromDish/${dishName}" method="post">
    <c:forEach items="${ingredientsToDelete}" var="ingr">
        <p><input type="checkbox" name="ingredient" value="${ingr.name}">${ingr.name}</p>
    </c:forEach>
    <p><input type="submit" value="Delete ingredient from dish"></p>
</form>
</body>
</html>