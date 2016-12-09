package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.edu.khibs.resalex.Dao.DishDao;
import ua.edu.khibs.resalex.model.Dish;

import java.util.List;

public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    public List findAllDishes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select d from Dish d").list();
    }

    @Override
    public Dish findDishByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void saveDish(Dish dish) {
    }

    @Override
    public Dish loadDish(Long id) {
        return null;
    }

    @Override
    public void removeDish(Dish dish) {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
