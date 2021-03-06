package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.services.OfferService;
import hu.preznyak.services.RequestService;
import hu.preznyak.services.UserService;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <h1>MyServicesMB ManagedBean class.</h1>
 * This is a class for listing and manipulating a user's services.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "MyServices")
@RequestScoped
public class MyServicesMB {

    /**
     * A list of {@link Service} objects.
     */
    private List<Service> myServicesList;

    private UserService userService;

    private RequestService requestService;

    private List<Request> myRequests;

    private OfferService offerService;

    private List<Offer> myOffers;

    /**
     * Init method of the {@link MyServicesMB} class.
     */
    @PostConstruct
    public void init(){
        HttpSession session = SessionUtils.getSession();
        userService = new UserService();
        User user = userService.getUserById((Integer)session.getAttribute("userid"));
        myServicesList = user.getServiceList();
        requestService = new RequestService();
        myRequests = requestService.getMyRequests(myServicesList);
        offerService = new OfferService();
        myOffers = offerService.getMyOffers(myServicesList);
    }

    /**
     * removeMyService method for removing a {@link Service} from the myServicesList list.
     * @param id the id of a {@link Service} object.
     */
    public void removeMyService(int id){
        HttpSession session = SessionUtils.getSession();
        User user = userService.getUserById((Integer)session.getAttribute("userid"));
        userService.removeMyService(user,id);
        init();
    }

    /**
     * No-arg constructor for {@link MyServicesMB} class.
     */
    public MyServicesMB() {
    }

    /**
     * Getter method for the myServicesList.
     * @return myServicesList the list of services.
     */
    public List<Service> getMyServicesList() {
        return myServicesList;
    }

    /**
     * Setter method for the myServicesList.
     * @param myServicesList a list of {@link Service} objects.
     */
    public void setMyServicesList(List<Service> myServicesList) {
        this.myServicesList = myServicesList;
    }

    public List<Request> getMyRequests() {
        return myRequests;
    }

    public void setMyRequests(List<Request> myRequests) {
        this.myRequests = myRequests;
    }

    public List<Offer> getMyOffers() {
        return myOffers;
    }

    public void setMyOffers(List<Offer> myOffers) {
        this.myOffers = myOffers;
    }
}
