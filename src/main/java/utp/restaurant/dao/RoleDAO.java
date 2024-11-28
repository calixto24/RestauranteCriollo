package utp.restaurant.dao;


import io.github.cdimascio.dotenv.Dotenv;
import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import utp.restaurant.model.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class RoleDAO implements DAO<Role> {

    private String query;
    
    private EntityManagerFactory emf;
    private EntityManager em;

    //constructor vacio
    public RoleDAO() {
        Dotenv dotenv = Dotenv.load();
        HashMap<String, String> properties = new HashMap<>();        
        properties.put("javax.persistence.jdbc.url", dotenv.get("DB_URL"));
        properties.put("javax.persistence.jdbc.user", dotenv.get("DB_USER"));
        properties.put("javax.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));
        
        emf = Persistence.createEntityManagerFactory("utp_restaurant_jar_1.0-SNAPSHOTPU", properties);
        em = emf.createEntityManager();
    }

    @Override
    public ArrayList<Role> getAll() {
        
        query = "SELECT r FROM Role r";
        
        return new ArrayList<>(em.createQuery(query, Role.class).getResultList());
    }

    @Override
    public Role get(long id) {

        return em.find(Role.class, id);
    }

    @Override
    public void add(Role role) {

        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();

    }

    @Override
    public void update(Role rolee) {

        em.getTransaction().begin();
        Role role = em.find(Role.class, rolee.getId());
        if (role != null) {
            role.setName(rolee.getName());
        }
        em.getTransaction().commit();

    }

    @Override
    public void delete(long id) {

        em.getTransaction().begin();
        Role role = em.find(Role.class, id);
        if (role != null) {
            em.remove(role);
        }
        em.getTransaction().commit();

    }

}
