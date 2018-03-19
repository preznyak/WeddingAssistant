package hu.preznyak.services;

import hu.preznyak.daos.OfferDAO;
import hu.preznyak.daos.impls.OfferDAOImpl;
import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>OfferService class.</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

public class OfferService {

    /**
     * OfferDAO object.
     */
    private OfferDAO offerDAO = new OfferDAOImpl();

    /**
     * getAllOffers method for getting all the {@link Offer} objects from the db.
     * @return List a List of {@link Offer} objects.
     */
    public List<Offer> getAllOffers(){
        return offerDAO.getAllOffers();
    }

    /**
     * getOffersByService method for getting {@link Offer} objects by {@link Service}.
     * @param service the {@link Service} which is linked to the Offer.
     * @return List a List of {@link Offer} objects.
     */
    public List<Offer> getOffersByService(Service service){
        return offerDAO.getOffersByService(service);
    }

    /**
     * getOffersByWeddingEvent method for getting {@link Offer} objects by {@link WeddingEvent}.
     * @param weddingEvent the {@link WeddingEvent} which is linked to the Offer.
     * @return List a List of {@link Offer} objects.
     */
    public List<Offer> getOffersByWeddingEvent(WeddingEvent weddingEvent){
        return offerDAO.getOffersByWeddingEvent(weddingEvent);
    }

    /**
     * deleteOffer method for deleting {@link Offer} objects from the db.
     * @param offer the {@link Offer} which will be deleted.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    public boolean deleteOffer(Offer offer){
        return offerDAO.deleteOffer(offer);
    }

    /**
     * createOffer method for creating {@link Offer} objects.
     * @param offer the {@link Offer} which will be created.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    public boolean createOffer(Offer offer){
        return offerDAO.createOffer(offer);
    }

    /**
     * updateOffer method for updating an {@link Offer}.
     * @param offer the {@link Offer} which will be updated.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    public boolean updateOffer(Offer offer){
        return offerDAO.updateOffer(offer);
    }

    public List<Offer> getMyOffers(List<Service> services){
        List<Offer> myOffers = new ArrayList<>();
        for(Service service : services){
            myOffers.addAll(getOffersByService(service));
        }
        return myOffers;
    }

    public List<Offer> getMyAcceptedOffers(List<Service> services){
        List<Offer> acceptedOffers = getMyOffers(services)
                .stream()
                .filter(offer -> offer.isAccepted())
                .collect(Collectors.toList());
        return acceptedOffers;
    }

    public List<Offer> getMyNotAcceptedOffers(List<Service> services){
        List<Offer> acceptedOffers = getMyOffers(services)
                .stream()
                .filter(offer -> !offer.isAccepted())
                .collect(Collectors.toList());
        return acceptedOffers;
    }

    public List<Offer> getAcceptedOffersByWeddingEvent(WeddingEvent weddingEvent){
        List<Offer> acceptedOffers = getOffersByWeddingEvent(weddingEvent)
                .stream()
                .filter(offer -> offer.isAccepted())
                .collect(Collectors.toList());
        return acceptedOffers;
    }

    public List<Offer> getNotAcceptedOffersByWeddingEvent(WeddingEvent weddingEvent){
        List<Offer> acceptedOffers = getOffersByWeddingEvent(weddingEvent)
                .stream()
                .filter(offer -> !offer.isAccepted())
                .collect(Collectors.toList());
        return acceptedOffers;
    }

}
