<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addDishToOrder</title>
</head>
<body>

<p>Add dish to order </p>
<p>Select dish to add:</p>

<form action="/admin/dish/addDishToOrder=${id}" method="post">

    <c:forEach items="${allDish}" var="dish">
        <p><input type="checkbox" name="dishToAdd" value="${dish.name}">${dish.name}</p>
    </c:forEach>
    <p><input type="submit" value="Add dish to order"></p>
</form>

</body>
</html>
