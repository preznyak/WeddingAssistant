package hu.preznyak.daos;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;

import java.util.List;

/**
 * <h1>OfferDAO interface.</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

public interface OfferDAO {

    /**
     * getAllOffers method for getting all the {@link Offer} objects from the db.
     * @return List a List of {@link Offer} objects.
     */
    List<Offer> getAllOffers();

    /**
     * getOffersByService method for getting {@link Offer} objects by {@link Service}.
     * @param service the {@link Service} which is linked to the Offer.
     * @return List a List of {@link Offer} objects.
     */
    List<Offer> getOffersByService(Service service);

    /**
     * getOffersByWeddingEvent method for getting {@link Offer} objects by {@link WeddingEvent}.
     * @param weddingEvent the {@link WeddingEvent} which is linked to the Offer.
     * @return List a List of {@link Offer} objects.
     */
    List<Offer> getOffersByWeddingEvent(WeddingEvent weddingEvent);

    /**
     * deleteOffer method for deleting {@link Offer} objects from the db.
     * @param offer the {@link Offer} which will be deleted.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean deleteOffer(Offer offer);

    /**
     * createOffer method for creating {@link Offer} objects.
     * @param offer the {@link Offer} which will be created.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean createOffer(Offer offer);

    /**
     * updateOffer method for updating an {@link Offer}.
     * @param offer the {@link Offer} which will be updated.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean updateOffer(Offer offer);
}
