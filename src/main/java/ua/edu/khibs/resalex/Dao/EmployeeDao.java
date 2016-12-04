package ua.edu.khibs.resalex.Dao;

import ua.edu.khibs.resalex.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List findAll();

    void remove(Employee employee);

    Employee findByName(String name);
}
