package hu.preznyak.daos.impls;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.entities.Service;
import hu.preznyak.enums.ServiceType;
import hu.preznyak.utils.SingletonEMFactory;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>ServiceDAOImpl class.</h1>
 * This class implements the {@link ServiceDAO} interface.
 * It implements all the methods from the interface.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class ServiceDAOImpl implements ServiceDAO {

    /**
     * EntityManager for entity operations.
     */
    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();

    /**
     * getServiceById method implementation from {@link ServiceDAO} inteface.
     * @param id the id of the {@link Service} object.
     * @return Service a {@link Service} object.
     */
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

    /**
     * getAllServices method implementation from {@link ServiceDAO} interface.
     * @return List the service list.
     */
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

    /**
     * updateService method implementation from {@link ServiceDAO} interface.
     * @param service the {@link Service} object which will be updated.
     * @return boolean a boolean value.
     */
    @Override
    public boolean updateService(Service service) {
        try{
            Service oldService = em.find(Service.class, service.getId());
            em.getTransaction().begin();
            oldService.setDescription(service.getDescription());
            oldService.setServiceName(service.getServiceName());
            oldService.setWebsite(service.getWebsite());
            oldService.setAddress(service.getAddress());
            em.persist(oldService);
        } catch (PersistenceException e){
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    /**
     * getServicesByServiceTypes method implementation.
     * @param serviceTypes List of services type.
     * @return List of {@link Service} entities.
     */
    @Override
    public List<Service> getServicesByServiceTypes(List<ServiceType> serviceTypes) {
        List<Service> serviceList = new ArrayList<>();
        try {
            em.getTransaction().begin();
            for(ServiceType serviceType : serviceTypes) {
                serviceList.addAll(em.createQuery("SELECT s FROM service s where s.serviceType = :servicetype")
                        .setParameter("servicetype",serviceType)
                        .getResultList());
            }
        } catch (PersistenceException e){
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return serviceList;
    }
}
