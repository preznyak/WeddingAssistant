package hu.preznyak.daos.impls;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.entities.User;


import javax.persistence.*;


public class UserDAOImpl implements UserDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("waunit");
    private EntityManager em;

    @Override
    public User getUserById(int id) {
        em = emf.createEntityManager();
        User user;
        em.getTransaction().begin();
        try{
            user = (User) em.find(User.class, id);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        em.close();
        return user;
    }

    @Override
    public User getUser(String username, String password) {
        em = emf.createEntityManager();
        User user;
        em.getTransaction().begin();
        try {
            user = (User) em
                    .createQuery("SELECT u FROM wa_user u WHERE u.username = :username and u.password = :pw")
                    .setParameter("username", username)
                    .setParameter("pw", password)
                    .getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
        return user;

    }

    @Override
    public boolean addUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(user);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
            em.close();
        }
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.remove(getUserById(id));
            em.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        em = emf.createEntityManager();
        User user;
        try {
            em.getTransaction().begin();
            user = (User) em.createQuery("SELECT u FROM wa_user u WHERE u.username = :username")
                    .setParameter("username",username)
                    .getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return user;
    }

}
