package hu.preznyak.daos.impls;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.entities.Service;
import hu.preznyak.utils.SingletonEMFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {

    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();

    @Override
    public Service getServiceById(int id) {
        Service service;
        em.getTransaction().begin();
        try {
            service = em.find(Service.class, id);
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
        return service;
    }

    @Override
    public boolean removeService(int id) {
        Service service;
        em.getTransaction().begin();
        try {
            service = em.find(Service.class, id);
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
    public List<Service> getAllServices() {
        em.getTransaction().begin();
        List<Service> serviceList;
        try {
            serviceList = em.createQuery("SELECT s FROM service s")
                    .getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return serviceList;
    }

    @Override
    public boolean updateService(Service service) {
        return false;
    }
}
