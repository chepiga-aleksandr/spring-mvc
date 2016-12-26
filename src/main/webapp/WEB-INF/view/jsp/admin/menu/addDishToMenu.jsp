<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Add dish to menu ${menuName}</p>
<p>Select dish to add:</p>
<form action="/admin/addDishToMenu/${menuName}" method="post">
    <c:forEach items="${dishToAdd}" var="dish">
        <p><input type="checkbox" name="dish" value="${dish.name}">${dish.name}</p>
    </c:forEach>
    <p><input type="submit" value="Add dish to menu"></p>
</form>

</body>
</html>