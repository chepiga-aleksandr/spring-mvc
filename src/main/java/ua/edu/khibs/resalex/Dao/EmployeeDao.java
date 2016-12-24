package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void saveNewEmployee(Employee employee);

    Employee loadEmployee(Long id);

    List<Employee> findAllEmployees();

    void removeEmployee(Employee employee);

    List<Employee> findEmployeeByPosition (String position);

    Employee findEmployeeById (Long id);

    void updateEmployee (Employee employee);
}
