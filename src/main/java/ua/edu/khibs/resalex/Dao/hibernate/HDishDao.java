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
    public void updateDish(Long id, Dish newDish) {
        Session session = sessionFactory.getCurrentSession();
        Dish dish = session.get(Dish.class, id);
        session.update(dish);
    }

    @Override
    public Dish setInformation(String name, Integer weight, Integer price) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setWeight(weight);
        dish.setPrice(price);
        return dish;
    }
    @Override
    public Dish findDishById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select d from Dish d where d.id = :id");
        query.setParameter("id", id);
        return (Dish) query.uniqueResult();
    }
    @Override
    public void saveDish(Dish dish) {
    }

    @Override
    public void removeDish(Dish dish) {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
