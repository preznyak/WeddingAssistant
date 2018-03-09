package hu.preznyak.daos.impls;

import hu.preznyak.daos.RequestDao;
import hu.preznyak.entities.Request;
import hu.preznyak.utils.SingletonEMFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();
//    private final static Logger LOGGER = LoggerFactory.getLogger(RequestDaoImpl.class);

    @Override
    public boolean createRequest(Request request) {
        try {
            em.getTransaction().begin();
            em.persist(request);
   //         LOGGER.info("Request persisted.");
        } catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("Request creation failed");
      //      LOGGER.error("Request persisting failed.");
            return false;
        } finally {
            em.getTransaction().commit();
      //      LOGGER.info("Transaction committed.");
        }
        return true;
    }

    @Override
    public boolean deleteRequest(Request request) {
        try {
            em.getTransaction().begin();
            em.remove(request);
     //       LOGGER.info("Request removed.");
        } catch (PersistenceException e) {
            e.printStackTrace();
      //      LOGGER.error("Request deleting failed");
            return false;
        } finally {
            em.getTransaction().commit();
       //     LOGGER.info("Transaction committed.");
        }
        return true;
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> requests;
        try {
            em.getTransaction().begin();
            requests = em.createQuery("select r from request r")
                    .getResultList();
       //     LOGGER.info("Request list got.");
        } catch (PersistenceException e) {
       //     LOGGER.error("Getting request list failed.");
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
       //     LOGGER.info("Transaction committed.");
        }
        return requests;
    }
}
