package hu.preznyak.managedbeans;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.Address;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.enums.ServiceType;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "CreateServicesMB")
@RequestScoped
public class CreateServiceMB {

    private Service newService;
    private Address newAddress;
    private String description;
    private String type;
    private String website;
    private String serviceName;

    @PostConstruct
    public void init(){
        newAddress=new Address();
    }

    public String createService(){
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = SessionUtils.getSession();
        User user = userDAO.getUserById((Integer)session.getAttribute("userid"));
        newService=new Service(user,ServiceType.valueOf(type),description, newAddress, website,serviceName);
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

    public Address getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(Address newAddress) {
        this.newAddress = newAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
