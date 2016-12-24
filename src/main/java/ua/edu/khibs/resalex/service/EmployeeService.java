package ua.edu.khibs.resalex.service;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.EmployeeDao;
import ua.edu.khibs.resalex.model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public List<Employee> getEmployeeByPosition(String position) {
        return employeeDao.findEmployeeByPosition(position);
    }

    @Transactional
    public void updateEmployeeInfo(Long id, String name, String surname, String position, Float salary, String login, String password, String role) {
        Employee employee = employeeDao.findEmployeeById(id);
        employee.setInfo(name, surname, position, salary, login, password, role);
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee (Employee employee) {
        employeeDao.removeEmployee(employee);
    }

    @Transactional
    public void addNewEmployee(String name, String surname, String position, Float salary, String login, String password, String role) {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setLogin(login);
        employee.setPassword(password);
        employee.setRole(role);
        employeeDao.saveNewEmployee(employee);
    }

    @Transactional
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}
