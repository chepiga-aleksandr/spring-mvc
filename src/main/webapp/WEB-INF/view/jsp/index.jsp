<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th><h1>${restaurant.name}</h1><br>
        ${restaurant.address}   ${restaurant.eMail}   ${restaurant.phoneNumber}<br>
        <a href="restaurant">Restaurant scheme</a><br>
        <a href="employees">Our Employees</a></th>
    </tr>
</table>
<br>

<table border="1" style="align-content: center">
    <tr>
        <th>Name Menu</th>
        <th>List of dishes</th>
    </tr>
    <c:forEach var="menu" items="${allMenu}">
        <tr>
            <td>${menu.name}</td>
            <td>
                <c:forEach items="${menu.listOfDishes}" var="dish">
                    <ul>
                        <li><a href="/dish?dishName=${dish.name}">${dish.name}</a> , weight - ${dish.weight} (грамм),
                            price - ${dish.price} (грн.)
                        </li>
                    </ul>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<form action="/dish?dishName=${dish.name}" method="GET">
    <p>Введите название искомого блюда: <input type="text" name="dishName"></p>
    <input type="submit" value="Искать"/>
</form><br><br>