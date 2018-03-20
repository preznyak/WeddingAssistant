package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.services.OfferService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "OfferMB")
@SessionScoped
public class OfferMB {

    private Offer actualOffer;

    private OfferService offerService;

    @PostConstruct
    public void init(){
        offerService = new OfferService();
    }

    public Offer getActualOffer() {
        return actualOffer;
    }

    public String setActualOffer(Offer offer){
        actualOffer = offer;
        return "/offerInfo";
    }

    public void acceptOffer(Offer offer){
        offer.setAccepted(true);
        offerService.updateOffer(offer);
    }

}
