package hu.preznyak.daos.impls;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
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
        try {
            em.getTransaction().begin();
            service = em.find(Service.class, id);
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return service;
    }


    @Override
    public List<Service> getAllServices() {
        List<Service> serviceList;
        try {
            em.getTransaction().begin();
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
        try{
            Service oldService = em.find(Service.class, service.getId());
            em.getTransaction().begin();
            oldService.setDescription(service.getDescription());
            oldService.setServiceName(service.getServiceName());
            oldService.setWebsite(service.getWebsite());
            oldService.getAddress().setCountry(service.getAddress().getCountry());
            oldService.getAddress().setCity(service.getAddress().getCity());
            oldService.getAddress().setHouseNumber(service.getAddress().getHouseNumber());
            oldService.getAddress().setStreet(service.getAddress().getStreet());
            oldService.getAddress().setPostCode(service.getAddress().getPostCode());
            em.persist(oldService);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }


}
