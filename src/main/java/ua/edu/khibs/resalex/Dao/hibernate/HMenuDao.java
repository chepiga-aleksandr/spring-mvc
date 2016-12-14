package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.edu.khibs.resalex.Dao.MenuDao;
import ua.edu.khibs.resalex.model.Menu;

import java.util.List;

public class HMenuDao implements MenuDao {

    private SessionFactory sessionFactory;

    @Override
    public List<Menu> findAllMenu() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Menu m", Menu.class).list();
    }

    @Override
    public List findMenuByType(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Menu m where m.name like :name ").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
