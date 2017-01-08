package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.edu.khibs.resalex.Dao.OrdersDao;
import ua.edu.khibs.resalex.model.Orders;

import java.util.List;

public class HOrdersDao implements OrdersDao {

    private SessionFactory sessionFactory;

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o", Orders.class).list();
    }

    @Override
    public Orders findOrdersById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Orders o where o.id = :id", Orders.class);
        query.setParameter("id", id);
        return (Orders) query.uniqueResult();
    }

    @Override
    public void updateOrders(Orders orders) {
        Session session = sessionFactory.getCurrentSession();
        session.update(orders);
    }

    @Override
    public void saveNewOrders(Orders orders) {
        Session session = sessionFactory.getCurrentSession();
        session.save(orders);
    }

    @Override
    public void deleteOrders(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Orders o where o.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public Orders findOrdersByNameWaiters(String name) {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
