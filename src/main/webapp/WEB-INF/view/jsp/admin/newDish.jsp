<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/newDish" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="dishName" value=""></td>
        </tr>
        <tr>
            <td>Weight</td>
            <td><input autocomplete="off" type="number" name="dishWeight" value=""></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input autocomplete="off" type="number" name="dishPrice" value=""></td>
        </tr>
        <tr>
            <td>Photo</td>
            <td><img src="" width="200"></td>
        </tr>
        <tr>
            <td>List of ingredients</td>
            <td><c:forEach items="${ingredients}" var="ingredient">

                <input type="checkbox" name="ingr" value="${ingredient.name}"> ${ingredient.name}

            </c:forEach></td>
        </tr>

    </table>

    <button>Submit</button>

</form>


</body>
</html>
