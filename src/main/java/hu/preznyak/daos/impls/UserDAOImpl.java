package hu.preznyak.daos.impls;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.utils.SingletonEMFactory;


import javax.persistence.*;
import java.util.List;


public class UserDAOImpl implements UserDAO {

    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();

    @Override
    public User getUserById(int id) {
        User user;
        try{
            user =  em.find(User.class, id);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public User getUser(String username, String password) {
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
        }
        return user;

    }

    @Override
    public boolean addUser(User user) {
        try{
            em.persist(user);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        em.getTransaction().begin();
        try{
            em.remove(getUserById(id));
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
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
            em.getTransaction().commit();
        }
        return user;
    }

    @Override
    public boolean addServiceToUser(User user, Service service) {
        em.getTransaction().begin();
        try {
            List<Service> serviceList = user.getServiceList();
            serviceList.add(service);
            if(serviceList.isEmpty()){
                System.out.println("Empty");
            } else{
                System.out.println(serviceList);
                System.out.println(user.getUsername());
            }
            user.setServiceList(serviceList);
            em.persist(user);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }
}
