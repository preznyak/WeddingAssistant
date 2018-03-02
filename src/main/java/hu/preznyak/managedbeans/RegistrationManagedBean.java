package hu.preznyak.managedbeans;

import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * <h1>RegistrationManagedBean class.</h1>
 * This is a managed bean class for registration.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "RegistrationMB")
@RequestScoped
public class RegistrationManagedBean {
    /**
     * A {@link User} object. In this object will be stored the data from the registration.
     */
    User user = new User();

    /**
     * register method for registration.
     * @return String a navigation String.
     */
    public String register(){
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.addUser(user)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Successful",
                            "Welcome"));
            return "/login";
        } else {
            return "/index";
        }
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
}
