package ua.edu.khibs.resalex.Dao.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.edu.khibs.resalex.Dao.IngredientDao;
import ua.edu.khibs.resalex.model.Ingredient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HIngredientDao implements IngredientDao {
    private SessionFactory sessionFactory;

    @Override
    public Set<Ingredient> findAllIngredient() {
//        List<Ingredient> ingredientList = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        return new HashSet<>(session.createQuery("select i from Ingredient i", Ingredient.class).list());
    }

    @Override
    public Ingredient findIngredientByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.name = :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();
    }

    @Override
    public void addNewIngredient(Ingredient ingredient) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ingredient);
    }

    @Override
    public Ingredient findIngredientById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.id = :id");
        query.setParameter("id", id);
        return (Ingredient) query.uniqueResult();
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(ingredient);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}