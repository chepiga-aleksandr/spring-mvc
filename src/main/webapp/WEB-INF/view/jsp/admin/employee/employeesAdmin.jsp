<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="align-items: center">
    <tr class="title">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Position</th>
        <th>Salary</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
        <th>Photo</th>
        <th>Action</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
            <td>${employee.login}</td>
            <td>${employee.password}</td>
            <td>${employee.role}</td>
            <td><img src="${employee.photo}" width="100"></td>
            <td>
                <p><a href="/admin/employee/update_EmployeeId=${employee.id}">Edit</a></p>
                <p><a href="/admin/employee/deleteEmployeeId=${employee.id}">Delete</a></p>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<button onclick="location.href='/admin/employee/newEmployee'">Create new employee</button>

</body>
</html>
