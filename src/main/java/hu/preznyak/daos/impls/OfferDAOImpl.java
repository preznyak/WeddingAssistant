package hu.preznyak.daos.impls;

import hu.preznyak.daos.OfferDAO;
import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.utils.SingletonEMFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * <h1>OfferDAOImpl class.</h1>
 * This is a class which implements the {@link OfferDAO} interface.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class OfferDAOImpl implements OfferDAO {

    private EntityManager em = SingletonEMFactory.getFactory().createEntityManager();


    @Override
    public List<Offer> getAllOffers() {
        List<Offer> offers;
        try {
            em.getTransaction().begin();
            offers = em.createQuery("select o from offer o")
                    .getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return offers;
    }

    @Override
    public List<Offer> getOffersByService(Service service) {
        List<Offer> offers;
        try {
            em.getTransaction().begin();
            offers = em.createQuery("select o from offer o where o.service = :service")
                    .setParameter("service",service)
                    .getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return offers;
    }

    @Override
    public List<Offer> getOffersByWeddingEvent(WeddingEvent weddingEvent) {
        List<Offer> offers;
        try {
            em.getTransaction().begin();
            offers = em.createQuery("select o from offer o where o.weddingEvent = :wedding")
                    .setParameter("wedding",weddingEvent)
                    .getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.getTransaction().commit();
        }
        return offers;
    }

    @Override
    public boolean deleteOffer(Offer offer) {
        try {
            em.getTransaction().begin();
            em.remove(offer);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
            System.out.println("Offer deleted.");
        }
        return true;
    }

    @Override
    public boolean createOffer(Offer offer) {
        try {
            em.getTransaction().begin();
            em.persist(offer);
        } catch (PersistenceException e){
            e.printStackTrace();
            System.out.println("Offer creation failed");
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean updateOffer(Offer offer) {
        try {
            Offer dbOffer = em.find(Offer.class, offer.getId());
            em.getTransaction().begin();
            dbOffer.setAccepted(offer.isAccepted());
            em.persist(dbOffer);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        } finally {
            em.getTransaction().commit();
        }
        return true;
    }
}
