<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

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
    <br>
    _____________________________________________________________________________________________________________________
    <table border="1" style="align-content: center">
        <tr>
            <th>Name Menu</th>
        </tr>
        <c:forEach var="menu" items="${allMenu}">
            <tr>
                <td>${menu.name}</td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <%--<table border = "1" style="align-items: center">--%>
    <%--<tr>--%>
    <%--<th>Name</th>--%>
    <%--<th>Price</th>--%>
    <%--</tr>--%>
    <%--<c:forEach var = "dish" items="${dishes}">--%>
    <%--<tr>--%>
    <%--<td>${dish.name}</td>--%>
    <%--<td>${dish.price}</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>
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
