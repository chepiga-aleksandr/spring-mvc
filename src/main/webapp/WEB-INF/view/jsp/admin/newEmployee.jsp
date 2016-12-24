<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/admin/newEmployee" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input autocomplete="off" type="text" name="employeeName" value=""></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input autocomplete="off" type="text" name="employeeSurname" value=""></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input autocomplete="off" type="date" name="employeePosition" value=""></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input autocomplete="off" type="number" name="employeeSalary" value=""></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input autocomplete="off" type="text" name="employeeLogin" value=""></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input autocomplete="off" type="text" name="employeePassword" value=""></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><input autocomplete="off" type="text" name="employeeRole" value=""></td>
        </tr>

    </table>
    <div class="employeeInformationSubmitButton">
        <button>Submit</button>
    </div>
</form>

</body>
</html>
