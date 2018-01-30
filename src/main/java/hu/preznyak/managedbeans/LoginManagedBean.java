package hu.preznyak.managedbeans;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="LoginMB")
@ViewScoped
public class LoginManagedBean {

    private User user = new User();

    public String login(){
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getUser(user.getUsername(), user.getPassword());
        if(user == null){
            user = new User();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "user not found",
                            "Login error."));
            return "/login";
        } else {
            return "/home";
        }
        /*
        if(user.getUsername().equals("preznyak") && user.getPassword().equals("preznyakpw")){
            return "/home";
        } else {
            return "/login";
        }
        */
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginManagedBean() {
    }
}
