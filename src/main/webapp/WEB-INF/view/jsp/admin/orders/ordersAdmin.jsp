<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<table border="1" style="align-items: center">
    <tr class="title">
    <tr>
        <th>NumberOfOrders</th>
        <th>Name Waiters</th>
        <th>Number of table</th>
        <th>Date</th>
        <th>ListOfDishes</th>
        <th>Action</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.employee.name}</td>
            <td>${order.numberOfTable}</td>
            <td>${order.orderDate}</td>
            <td><c:forEach items="${order.listOfDishInOrder}" var="listOfDishes">
                <ul>
                    <li>${listOfDishes.name}</li>
                </ul>
            </c:forEach></td>
            <td>
                <p><a href="/admin/orders/update_OrderId=${order.id}">Edit</a></p>
                <p><a href="/admin/orders/deleteOrderId=${order.id}">Delete</a></p>
            </td>
        </tr>
    </c:forEach>
</table>

<button onclick="location.href='/admin/orders/createOrders'">Create new order</button>

</body>
</html>
