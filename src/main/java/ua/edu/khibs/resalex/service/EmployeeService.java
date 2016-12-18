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
    public void updateEmployeeInfo(Long id, Employee newEmployee) {
        employeeDao.updateEmployee(id, newEmployee);
    }

    @Transactional
    public Employee setInformationUpdateEmployee (String name, String surname, String position, double salary){
        return employeeDao.setInformation(name, surname, position, salary );
    }

    @Transactional
    public void deleteEmployee (Employee employee) {
        employeeDao.removeEmployee(employee);
    }

    @Transactional
    public void addNewEmployee(String name, String surname, String position, Float salary) {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPosition(position);
        employee.setSalary(salary);

        employeeDao.saveNewEmployee(employee);
    }

    @Transactional
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}
