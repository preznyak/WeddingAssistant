package hu.preznyak.daos.impls;

import hu.preznyak.daos.WeddingDao;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.utils.SingletonEMFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

public class WeddingDaoImpl implements WeddingDao {

    /**
     * EntityManager for entity operations.
     */
    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();

    /**
     * getWeddingEventById implementation from {@link WeddingDao} interface.
     * @param id the id of the {@link WeddingEvent}.
     * @return WeddingEvent the found {@link WeddingEvent} object.
     */
    @Override
    public WeddingEvent getWeddingEventById(int id) {
        WeddingEvent weddingEvent;
        try {
            em.getTransaction().begin();
            weddingEvent = em.find(WeddingEvent.class,id);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return weddingEvent;
    }

    /**
     * getAllWeddingEvents implementation from {@link WeddingDao} interface.
     * @return List all of {@link WeddingEvent} objects from the database.
     */
    @Override
    public List<WeddingEvent> getAllWeddingEvents() {
        List<WeddingEvent> weddingEvents;
        try {
            em.getTransaction().begin();
            weddingEvents = em.createQuery("SELECT w FROM wedding w")
                    .getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return weddingEvents;
    }

    /**
     * updateWedding implementation from {@link WeddingDao} interface.
     * @param weddingEvent the {@link WeddingEvent} which will be updated.
     * @return boolean a boolean value which shows if the operation was successful, or not.
     */
    @Override
    public boolean updateWedding(WeddingEvent weddingEvent) {
        try {
            WeddingEvent oldWeddingEvent = em.find(WeddingEvent.class, weddingEvent.getId());
            em.getTransaction().begin();
            oldWeddingEvent.setDescription(weddingEvent.getDescription());
            oldWeddingEvent.setEventName(weddingEvent.getEventName());
            em.persist(oldWeddingEvent);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }
}
