<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table border="1">
        <tr>
            <th>First Name</th>
            <td>${employee.name}</td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td>${employee.surname}</td>
        </tr>
        <tr>
            <th>Position</th>
            <td>${employee.position}</td>
        </tr>
        <tr>
            <th>Salary</th>
            <td>${employee.salary}</td>
        </tr>
        <tr>
            <th>Photo</th>
            <td><img src="${employee.photo}" width="300"></td>
        </tr>
    </table>

    <div class="employeeButtons">
        <br>
        <button onclick="location.href='/admin/updateEmployeeId=${employee.id}';">Update Info</button>
        <button onclick="location.href='/admin/deleteEmployeeId=${employee.id}';">Delete employee</button>
    </div>

</body>
</html>