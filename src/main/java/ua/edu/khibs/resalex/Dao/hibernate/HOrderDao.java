package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.SessionFactory;
import ua.edu.khibs.resalex.Dao.OrderDao;
import ua.edu.khibs.resalex.model.Order;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {

        sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
