<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<h1>--%>
    <%--${restaurantService.name}--%>
    <%--${restaurantService.address}--%>
    <%--${restaurantService.eMail}--%>
    <%--${restaurantService.phoneNumber}--%>
<%--</h1>--%>

<h1>
    <c:forEach var="employee" items="${employees}" >
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>

</h1>

<h1>Hello GoIT. It is now: ${currentTime}</h1>

<a href="/employees">Show all employees</a>

</body>
</html>
