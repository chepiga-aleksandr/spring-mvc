package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.edu.khibs.resalex.Dao.EmployeeDao;
import ua.edu.khibs.resalex.model.Employee;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    public void saveNewEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public Employee loadEmployee(Long id) {
        Employee result = sessionFactory.getCurrentSession().load(Employee.class, id);
        if (result == null) {
            throw new RuntimeException("Cannot find Employee by id: " + id);
        }
        return result;
    }

    @Override
    public List findAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();
    }

    @Override
    public List findEmployeeByPosition(String position) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.position like :position");
        query.setParameter("position", position);
        return query.getResultList();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.id = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();
    }

    @Override
    public void updateEmployee(Long id, Employee newEmployee) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        employee.setName(newEmployee.getName());
        employee.setSurname(newEmployee.getSurname());
        employee.setPosition(newEmployee.getPosition());
        employee.setSalary(newEmployee.getSalary());

        session.update(employee);
    }

    @Override
    public Employee setInformation(String name, String surname, String position, Float salary) {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPosition(position);
        employee.setSalary(salary);

        return employee;
    }

    @Override
    public void removeEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
