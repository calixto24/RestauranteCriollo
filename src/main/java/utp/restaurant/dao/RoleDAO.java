package utp.restaurant.dao;


import utp.restaurant.Interface.DAO;
import java.util.ArrayList;
import utp.restaurant.model.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class RoleDAO implements DAO<Role> {

    private String query;
    private ArrayList<Role> roleList;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("utp_restaurant_jar_1.0-SNAPSHOTPU");
    private EntityManager em = emf.createEntityManager();

    //constructor vacio
    public RoleDAO() {
        
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
