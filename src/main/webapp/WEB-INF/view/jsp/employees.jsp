<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="align-items: center">
    <tr>
        <th>First Name</th>
         <th>Photo</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td><img src="${employee.photo}" width="300"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
