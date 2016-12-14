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
    public List<Employee> getEmployeeByPosition (String position) {
        return employeeDao.findEmployeeByPosition(position);
    }

    @Transactional
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
