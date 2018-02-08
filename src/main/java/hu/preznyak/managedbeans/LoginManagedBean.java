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

@ManagedBean(name="LoginMB")
@SessionScoped
public class LoginManagedBean implements Serializable{

    private boolean loggedIn;

    private User user = new User();

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

    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        loggedIn=false;
        return "/index";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LoginManagedBean() {
    }
}
