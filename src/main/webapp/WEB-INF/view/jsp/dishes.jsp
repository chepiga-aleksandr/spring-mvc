<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Photo</th>
    </tr>

    <c:forEach var="dish" items="${dishes}">

        <tr>
            <td><a href="/dish?dishName=${dish.name}">${dish.name}</a></td>
            <td>${dish.weight}</td>
            <td>${dish.price}</td>
            <td>${dish.photo}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
