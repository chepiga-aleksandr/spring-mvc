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
    public List<Dish> findAllDishes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select d from Dish d", Dish.class).list();
    }

    @Override
    public Dish findDishByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.name like :name");
        query.setParameter("name", name);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void updateDish(Dish dish) {
        Session session = sessionFactory.getCurrentSession();
        session.update(dish);
    }

    @Override
    public Dish findDishById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.id = :id");
        query.setParameter("id", id);
        return (Dish) query.uniqueResult();
    }

    @Override
    public void saveNewDish(Dish dish) {
        Session session = sessionFactory.getCurrentSession();
        session.save(dish);
    }

    @Override
    public void removeDish(Long id) {
//        sessionFactory.getCurrentSession().delete(dish);
           Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Dish d where d.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
