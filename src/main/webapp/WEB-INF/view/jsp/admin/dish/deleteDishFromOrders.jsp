<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteDishFromOrders</title>
</head>
<body>

<p>Delete dish from orders </p>
<p>Select dish to delete:</p>

<form action="/admin/dish/deleteDishFromOrders=${id}" method="post">

    <c:forEach items="${listDishes}" var="dish">
        <p><input type="checkbox" name="dish" value="${dish.name}">${dish.name}</p>
    </c:forEach>
    <p><input type="submit" value="Delete dish from order"></p>
</form>

</body>
</html>
