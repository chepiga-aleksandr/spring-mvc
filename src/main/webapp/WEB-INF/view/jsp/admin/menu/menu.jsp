<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/updateMenuId=${menu.id}" method="post">
    <table border="1">
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="menuName" value="${menu.name}"></td>
        </tr>

        <tr>
            <td>List of dishes<br>

                <p><a href="/admin/addDishToMenu/${menu.name}">Add dish</a></p></td>

            <td><c:forEach items="${menu.listOfDishes}" var="listOfDishes">
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
