package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public Menu findMenuByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.name like :name ");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    public Menu findMenuById(Long id) {
        Session session  = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.id = :id");
        query.setParameter("id", id);
        return (Menu) query.uniqueResult();
    }

    @Override
    public void saveNewMenu(Menu menu) {
        Session session = sessionFactory.getCurrentSession();
        session.save(menu);

    }

    @Override
    public void updateMenu(Menu menu) {

        Session session = sessionFactory.getCurrentSession();
        session.update(menu);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
