<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="align-content: center">
    <tr>
        <th>Name Menu</th>
        <th>List of dishes</th>
    </tr>
    <c:forEach var="menu" items="${menu}">
        <tr>
            <td>${menu.name}<br><a href="/admin/updateMenuId=${menu.id}">Edit</a></td>

            /admin/updateMenuId={id}

            <td>
                <c:forEach items="${menu.listOfDishes}" var="dish">
                    <ul>
                        <li>${dish.name}, weight - ${dish.weight} (грамм), price - ${dish.price} (грн.)</li>
                    </ul>
                </c:forEach>
            </td>
        </tr>

    </c:forEach>

</table>

<button onclick="location.href='/admin/menu/newMenu'">Create new menu</button>

</body>
</html>