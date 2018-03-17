package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.services.OfferService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "CreateOfferMB")
@SessionScoped
public class CreateOfferMB {

    private OfferService offerService;

    private Offer newOffer = new Offer();

    @PostConstruct
    public void init(){
        offerService = new OfferService();
    }

    public String createOffer(){
        newOffer.setAccepted(false);
        offerService.createOffer(newOffer);
        return "/home";
    }

    public String setWeddingEventAndServiceToOffer(WeddingEvent weddingEvent, Service service){
        newOffer.setWeddingEvent(weddingEvent);
        newOffer.setService(service);
        return "/createOffer";
    }

    public Offer getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(Offer newOffer) {
        this.newOffer = newOffer;
    }
}
