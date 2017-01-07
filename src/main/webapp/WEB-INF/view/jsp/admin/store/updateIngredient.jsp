<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateIngredient</title>
</head>
<body>

<form action="/admin/store/updateIngredientId=${ingredient.id}" method="post">

    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="ingredientName" value="${ingredient.name}"></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input autocomplete="off" type="number" name="ingredientAmount" value="${ingredient.amount}"></td>
        </tr>
    </table>
    <button>Submit</button>
</form>
</body>
</html>
