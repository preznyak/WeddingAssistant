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

/**
 * <h1>CreateServiceMB ManagedBean class.</h1>
 * This class is a managed bean for creating services.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "CreateServicesMB")
@RequestScoped
public class CreateServiceMB {

    /**
     * A new service.
     */
    private Service newService;

    /**
     * The new address of the new service.
     */
    private Address newAddress;

    /**
     * The type of the new service.
     */
    private String type;

    /**
     * Init method for initializing the managed bean.
     */
    @PostConstruct
    public void init() {
        newService = new Service();
        newAddress = new Address();
    }

    /**
     * Create Service method for creating a new service.
     * @return String the name of a page.
     */
    public String createService() {
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = SessionUtils.getSession();
        User user = userDAO.getUserById((Integer) session.getAttribute("userid"));
        newService.setServiceType(ServiceType.valueOf(type));
        newService.setAddress(newAddress);
        if (userDAO.addServiceToUser(user, newService)) {
            return "/services";
        } else {
            return "/home";
        }
    }

    /**
     * Getter method for the newService.
     * @return Service the new {@link Service}.
     */
    public Service getNewService() {
        return newService;
    }

    /**
     * Setter for the newService.
     * @param newService the new {@link Service}.
     */
    public void setNewService(Service newService) {
        this.newService = newService;
    }

    /**
     * Getter method for the type.
     * @return type the type of the new {@link Service}.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for the type.
     * @param type the type of the new {@link Service}.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the newAddress.
     * @return newAddress the new {@link Address} object.
     */
    public Address getNewAddress() {
        return newAddress;
    }

    /**
     * Setter for the newAddress.
     * @param newAddress the new {@link Address} object.
     */
    public void setNewAddress(Address newAddress) {
        this.newAddress = newAddress;
    }
}
