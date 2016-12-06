package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.edu.khibs.resalex.Dao.RestaurantDao;
import ua.edu.khibs.resalex.model.Restaurant;

public class HRestaurantDao implements RestaurantDao {

    private SessionFactory sessionFactory;

    @Override
    public Restaurant allInformation() {
        Session session = sessionFactory.getCurrentSession();
        return (Restaurant) session.createQuery("select r from Restaurant r");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}