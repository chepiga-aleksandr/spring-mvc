<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/menu/newMenu" method="post">
    <table border="1">
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="menuName" value=""></td>
        </tr>

        <tr>
            <td>List of dishes<br>
            <td><c:forEach items="${dishes}" var="dish">

            <input type="checkbox" name="dish" value="${dish.name}">${dish.name}

            </c:forEach></td>
        </tr>
    </table>

    <button>Submit</button>

</form>

</body>
</html>
