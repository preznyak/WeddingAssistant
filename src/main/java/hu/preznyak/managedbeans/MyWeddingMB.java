package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.services.OfferService;
import hu.preznyak.services.UserService;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <h1>MyWeddingsMB ManagedBean class.</h1>
 * This is a class for listing and manipulating a user's weddings.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "MyWeddingMB")
@RequestScoped
public class MyWeddingMB {

    /**
     * A {@link WeddingEvent} object.
     */
    private WeddingEvent myWedding;

    private UserService userService;

    private OfferService offerService;

    private List<Offer> offers;

    /**
     * Init method of the {@link MyWeddingMB} class.
     */
    @PostConstruct
    public void init(){
        HttpSession session = SessionUtils.getSession();
        userService = new UserService();
        offerService = new OfferService();
        User user = userService.getUserById((Integer)session.getAttribute("userid"));
        myWedding = user.getWeddingEvent();
        if(myWedding!=null){
            offers = offerService.getOffersByWeddingEvent(myWedding);
        }
    }


    /**
     * No-arg constructor for {@link MyWeddingMB} class.
     */
    public MyWeddingMB() {
    }

    /**
     * Getter method for user's wedding.
     * @return WeddingEvent a {@link WeddingEvent} object
     */
    public WeddingEvent getMyWedding() {
        return myWedding;
    }

    /**
     * Setter method for user's wedding.
     * @param myWedding the {@link WeddingEvent} of the user.
     */
    public void setMyWedding(WeddingEvent myWedding) {
        this.myWedding = myWedding;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
