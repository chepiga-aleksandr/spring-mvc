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
                    <td><input autocomplete="off" type="date" name="employeePosition" value="${employee.position}"></td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input autocomplete="off" type="number" name="employeeSalary" value="${employee.salary}"></td>
                </tr>

            </table>
            <div class="employeeInformationSubmitButton">
                <button>Submit</button>
            </div>
        </form>

</body>
</html>
