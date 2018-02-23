package hu.preznyak.managedbeans;

import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.User;
import hu.preznyak.utils.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * <h1>LoginManagedBean ManagedBean class.</h1>
 * This is a managed bean class for login method.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name="LoginMB")
@SessionScoped
public class LoginManagedBean implements Serializable{

    /**
     * A boolean value which stores that a user is logged in or not.
     */
    private boolean loggedIn;

    /**
     * A {@link User} object.
     */
    private User user = new User();

    /**
     * Login method for logging in the application.
     * @return String a String for navigation.
     */
    public String login(){
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getUser(user.getUsername(), user.getPassword());
        if(user == null){
            user = new User();
            FacesContext.getCurrentInstance().addMessage(
                    "login",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "user not found",
                            "Login error."));
            return "/login";
        } else {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("userid",user.getId());
            loggedIn=true;
            return "/home";
        }
    }

    /**
     * Logout method for logging out of the application.
     * @return String a String for navigation.
     */
    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        loggedIn=false;
        return "/index";
    }

    /**
     * Getter method for the user.
     * @return user a {@link User} object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for the user.
     * @param user a {@link User} object.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter method for the loggedIn variable.
     * @return loggedIn a boolean value.
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Setter method for the loggedIn variable.
     * @param loggedIn a boolean value.
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * No-arg constructor for the {@link LoginManagedBean} class.
     */
    public LoginManagedBean() {
    }
}
