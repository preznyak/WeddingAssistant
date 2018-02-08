package hu.preznyak.managedbeans;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.enums.ServiceType;
import hu.preznyak.utils.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "CreateServicesMB")
@RequestScoped
public class CreateServiceMB {

    private Service newService;
    private String description;
    private String type;

    public String createService(){
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = SessionUtils.getSession();
        User user = userDAO.getUserById((Integer)session.getAttribute("userid"));
        newService=new Service(user,ServiceType.valueOf(type),description);
        System.out.println(session.getAttribute("userid"));
        if(userDAO.addServiceToUser(user,newService)){
            return "/services";
        } else {
            return "/home";
        }
    }

    public Service getNewService() {
        return newService;
    }

    public void setNewService(Service newService) {
        this.newService = newService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
