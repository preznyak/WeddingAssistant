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
    @Override
    public List<Service> getMyServices(User user) {
        List<Service> serviceList;
        try {
            em.getTransaction().begin();
            serviceList =  user.getServiceList();
        } catch (PersistenceException e){
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return serviceList;
    }
}
