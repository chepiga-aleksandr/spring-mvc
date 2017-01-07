<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/store/createNewIngredient" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="ingredientName" value=""></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input autocomplete="off" type="number" name="ingredientAmount" value=""></td>
        </tr>

    </table>

    <button>Submit</button>

</form>

</body>
</html>