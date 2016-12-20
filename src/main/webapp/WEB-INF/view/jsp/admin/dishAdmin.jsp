<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/updateDishId=${dish.id}" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="dishName" value="${dish.name}"></td>
        </tr>
        <tr>
            <td>Weight</td>
            <td><input autocomplete="off" type="text" name="dishWeight" value="${dish.weight}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input autocomplete="off" type="text" name="dishPrice" value="${dish.price}"></td>
        </tr>

    </table>
    <button>Submit</button>
</form>

</body>
</html>
