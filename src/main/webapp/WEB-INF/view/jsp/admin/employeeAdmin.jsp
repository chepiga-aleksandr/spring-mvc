<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/updateEmployeeId=${employee.id}" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="employeeName" value="${employee.name}"></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input autocomplete="off" type="text" name="employeeSurname" value="${employee.surname}"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input autocomplete="off" type="text" name="employeePosition" value="${employee.position}"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input autocomplete="off" type="number" name="employeeSalary" value="${employee.salary}"></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input autocomplete="off" type="text" name="employeeLogin" value="${employee.login}"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input autocomplete="off" type="text" name="employeePassword" value="${employee.password}"></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><input autocomplete="off" type="text" name="employeeRole" value="${employee.role}"></td>
        </tr>

    </table>

        <button>Submit</button>

</form>

</body>
</html>