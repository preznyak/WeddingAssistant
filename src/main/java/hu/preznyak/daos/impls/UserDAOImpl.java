package hu.preznyak.daos.impls;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.WeddingDao;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.utils.SingletonEMFactory;
import javax.persistence.*;
import java.util.List;

/**
 * <h1>UserDAOImpl class.</h1>
 * This is a class that implements the {@link UserDAO} interface.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class UserDAOImpl implements UserDAO {

    /**
     * EntityManager for entity operations.
     */
    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();

    /**
     * getUserById method implementation from {@link UserDAO} interface.
     * @param id the id of the user.
     * @return User a {@link User} object.
     */
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

    /**
     * getUser method implementation from {@link UserDAO} interface.
     * @param username the username of the {@link User}
     * @param password the password of the {@link User}
     * @return User a {@link User} object from the database.
     */
    @Override
    public User getUser(String username, String password) {
        User user;
        try {
            em.getTransaction().begin();
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

    /**
     * addUser method implementation from {@link UserDAO} interface.
     * @param user a {@link User} to be added.
     * @return boolean a boolean value. True if it was successful, false otherwise.
     */
    @Override
    public boolean addUser(User user) {
        try{
            em.getTransaction().begin();
            em.persist(user);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    /**
     * addServiceToUser method implementation from {@link UserDAO} interface.
     * @param user {@link User} object.
     * @param service {@link Service} object.
     * @return boolean a boolean value. It's true if the operation was successful, false otherwise.
     */
    @Override
    public boolean addServiceToUser(User user, Service service) {
        try {
            em.getTransaction().begin();
            List<Service> serviceList = user.getServiceList();
            serviceList.add(service);
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

    /**
     * removeMyService method implementation from {@link UserDAO} interface.
     * @param user {@link User} object.
     * @param id id of a {@link Service} object.
     * @return boolean a boolean value. It's true if the operation was successful, false otherwise.
     */
    @Override
    public boolean removeMyService(User user,int id) {
        Service service;
        try {
            em.getTransaction().begin();
            List<Service> myServices = user.getServiceList();
            service = em.find(Service.class, id);
            myServices.remove(service);
            user.setServiceList(myServices);
            em.persist(user);
            em.remove(service);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    /**
     * getMyServices method implementation from {@link UserDAO} interface.
     * @param user a {@link User} object.
     * @return List a List of {@link Service} object.
     */
    @Override
    public List<Service> getMyServices(User user) {
        List<Service> serviceList;
        serviceList =  user.getServiceList();
        return serviceList;
    }

    /**
     * addWeddingToUser implementation from {@link WeddingDao} interface.
     * @param user the user who created the wedding
     * @param weddingEvent the new wedding event.
     * @return boolean a boolean value which show if the operation was successful or not.
     */
    @Override
    public boolean addWeddingToUser(User user, WeddingEvent weddingEvent) {
        try {
            em.getTransaction().begin();
            user.setWeddingEvent(weddingEvent);
            em.persist(user);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    /**
     * removeMyWedding implementation from {@link WeddingDao} interface.
     * @param user the user who removes his / her wedding.
     * @return boolean a boolean value which show if the operation was successful or not.
     */
    @Override
    public boolean removeMyWedding(User user) {
        try {
            em.getTransaction().begin();
            user.setWeddingEvent(null);
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
