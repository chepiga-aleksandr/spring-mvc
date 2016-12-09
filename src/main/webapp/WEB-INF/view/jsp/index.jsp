<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>  ${restaurant.name}<br>
            ${restaurant.address}<br>
            ${restaurant.eMail}<br>
            ${restaurant.phoneNumber}<br>
        </th>
        <th>
            <img src="${restaurant.photo}" width="200"/>
        </th>
    </tr>
</table>
<br><br>
_____________________________________________________________________________________________________________________
<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>${allDishes.name}</td>
        <td>${allDishes.weight}</td>
        <td>${allDishes.price}</td>
    </tr>
</table>
_____________________________________________________________________________________________________________________
<table border="1" style="align-items: center">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Photo</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td><img src="${employee.photo}" width="100"></td>
        </tr>
    </c:forEach>
</table>
<br><br>

</body>
</html>
