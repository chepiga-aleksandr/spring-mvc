package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void saveNewEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void removeEmployee(Employee employee);

    List<Employee> findEmployeeByPosition (String position);

    Employee findEmployeeById (Long id);

    void updateEmployee (Employee employee);

    String authenticationUser (String login, String password);
}
