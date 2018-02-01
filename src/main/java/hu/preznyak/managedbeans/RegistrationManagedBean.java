package hu.preznyak.managedbeans;

import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "RegistrationMB")
@RequestScoped
public class RegistrationManagedBean {
    User user = new User();

    public String register(){
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.addUser(user)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Successful",
                            "Welcome"));
            return "/index";
        } else {
            return "/index";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
