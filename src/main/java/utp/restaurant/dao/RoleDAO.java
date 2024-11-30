package utp.restaurant.dao;


import io.github.cdimascio.dotenv.Dotenv;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utp.restaurant.model.*;

public class RoleDAO implements DAO<Role> {
    private SessionFactory factory;
    private Session session;

    public RoleDAO() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    @Override
    public ArrayList<Role> getAll() {
        return new ArrayList<>(session.createQuery("FROM Role", Role.class).list());
    }

    @Override
    public Role get(long id) {
        return session.get(Role.class, id);
    }

    @Override
    public void add(Role role) {
        session.beginTransaction();
        session.save(role);
        session.getTransaction().commit();
    }

    @Override
    public void update(Role role) {
        session.beginTransaction();
        session.update(role);
        session.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        session.beginTransaction();
        Role role = session.get(Role.class, id);
        session.delete(role);
        session.getTransaction().commit();
    }
}
