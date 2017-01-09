<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateOrders</title>
</head>
<body>

<form action="/admin/orders/updateOrdersId=${orders.id}" method="post">
    <table border="1">
        <tr>
            <td>Number</td>
            <td><input autocomplete="off" type="text" name="NumberOfOrders" value="${orders.id}"></td>
        </tr>
        <tr>
            <td>Employee</td>
            <td>
            <select name="employeeId">
                <c:forEach items="${employees}" var="employee">
                    <option value="${employee.id}">${employee.name} ${employee.surname}</option>
                </c:forEach>
            </select>
            </td>
          </tr>
        <tr>
            <td>Number of table</td>
            <td><input autocomplete="off" type="number" name="numberOfTable" value="${orders.numberOfTable}"></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input  type="date" name="dateOfOrders" value="${orders.orderDate}"></td>
        </tr>
        <tr>
            <td>List of dishes<br>

                <p><a href="/admin/dish/addDishToOrder=${orders.id}">Add dish</a></p>

                <p><a href="/admin/dish/deleteDishFromOrders=${orders.id}">Delete dish</a></p></td>

            <td><c:forEach items="${orders.listOfDishInOrder}" var="listOfDishes">
                <ul>
                    <li>${listOfDishes.name}</li>
                </ul>
            </c:forEach></td>
        </tr>
    </table>

    <button>Submit</button>

</form>

</body>
</html>
