package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.services.OfferService;
import hu.preznyak.services.RequestService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "CreateOfferMB")
@SessionScoped
public class CreateOfferMB {

    private OfferService offerService;

    private RequestService requestService;

    private Offer newOffer = new Offer();

    private Request activeRequest;

    @PostConstruct
    public void init(){
        offerService = new OfferService();
        requestService = new RequestService();
    }

    public String createOffer(){
        newOffer.setAccepted(false);
        offerService.createOffer(newOffer);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Create Offer","Offer created successfully!");
        FacesContext.getCurrentInstance().addMessage(null,message);
        activeRequest.setActive(false);
        requestService.updateRequest(activeRequest);
        return "/home";
    }

    public String setWeddingEventAndServiceToOffer(Request request){
        newOffer.setWeddingEvent(request.getWeddingEvent());
        newOffer.setService(request.getService());
        activeRequest = request;
        return "/createOffer";
    }

    public Offer getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(Offer newOffer) {
        this.newOffer = newOffer;
    }
}
