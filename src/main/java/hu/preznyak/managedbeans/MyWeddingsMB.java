package hu.preznyak.managedbeans;

import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;
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

@ManagedBean(name = "MyWeddingsMB")
@RequestScoped
public class MyWeddingsMB {

    /**
     * A list of {@link Service} objects.
     */
    private List<WeddingEvent> myWeddingsList;

    private UserService userService;

    /**
     * Init method of the {@link MyWeddingsMB} class.
     */
    @PostConstruct
    public void init(){
        HttpSession session = SessionUtils.getSession();
        userService = new UserService();
        User user = userService.getUserById((Integer)session.getAttribute("userid"));
        myWeddingsList = user.getWeddingEventList();
    }


    /**
     * No-arg constructor for {@link MyWeddingsMB} class.
     */
    public MyWeddingsMB() {
    }

    /**
     * Getter method for user's wedding list.
     * @return List a List of {@link WeddingEvent} object.
     */
    public List<WeddingEvent> getMyWeddingsList() {
        return myWeddingsList;
    }

    /**
     * Setter method for user's wedding list.
     * @param myWeddingsList the {@link WeddingEvent} List of the user.
     */
    public void setMyWeddingsList(List<WeddingEvent> myWeddingsList) {
        this.myWeddingsList = myWeddingsList;
    }
}
