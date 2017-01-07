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
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public String authenticationUser(String login, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e.role from Employee e where e.login like :login and e.password like :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (String) query.uniqueResult();
    }

    @Override
    public void removeEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
