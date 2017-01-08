<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newOrders</title>
</head>
<body>

<form action="/admin/orders/createOrders" method="post">
    <table border="1">
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
            <td><input type="number" name="numberOfTable" value=""></td>
        </tr>

        <tr>
            <td>Date</td>
            <td><input type="date" name="dateOfOrders" value=""></td>
        </tr>
        <tr>
            <td>List of dishes<br>
            <td><c:forEach items="${dishes}" var="listOfDishes">

                <input type="checkbox" name="dish" value="${listOfDishes.name}">${listOfDishes.name}<br>

            </c:forEach></td>
        </tr>
    </table>

    <button>Submit</button>

</form>

</body>
</html>
