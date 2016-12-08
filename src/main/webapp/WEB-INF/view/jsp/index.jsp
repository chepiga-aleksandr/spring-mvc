<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<table border="1">
    <tr>
        <th>  ${restaurantInfo.name}<br>
              ${restaurantInfo.address}<br>
              ${restaurantInfo.eMail}<br>
              ${restaurantInfo.phoneNumber}<br>
        </th>
        <th>
            <img src="/resimg.jpg">
        </th>
    </tr>
</table><br><br>

<table border="1" style="align-items: center">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Foto</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.foto}</td>
    </tr>
    </c:forEach>
</table><br><br>

<h1>MENU</h1>

<table border="1">
    <tr>
        <td>Name Menu</td>
    </tr>
    <c:forEach var="menu" items="${allMenu}">
        <tr>
            <td>${menu.name}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
