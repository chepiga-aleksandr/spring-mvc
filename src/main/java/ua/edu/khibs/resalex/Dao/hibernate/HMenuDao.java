package ua.edu.khibs.resalex.Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.edu.khibs.resalex.Dao.MenuDao;

import java.util.List;

public class HMenuDao implements MenuDao {

    SessionFactory sessionFactory;

    @Override
    public List findAllMenu() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery ("select m from Menu m").list();
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


//"select e from Employee e where e.name like :name");