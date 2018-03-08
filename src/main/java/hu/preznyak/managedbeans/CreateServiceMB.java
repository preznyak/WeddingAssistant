package hu.preznyak.managedbeans;

import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.enums.ServiceType;
import hu.preznyak.services.UserService;
import hu.preznyak.utils.SessionUtils;
import org.primefaces.model.UploadedFile;

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
     * The type of the new service.
     */
    private String type;

    private UserService userService;

    private UploadedFile uploadedFile;

    /**
     * Init method for initializing the managed bean.
     */
    @PostConstruct
    public void init() {
        newService = new Service();
        userService = new UserService();
    }

    /**
     * Create Service method for creating a new service.
     * @return String the name of a page.
     */
    public String createService() {
        HttpSession session = SessionUtils.getSession();
        User user = userService.getUserById((Integer) session.getAttribute("userid"));
        newService.setServiceType(ServiceType.valueOf(type));
        if(uploadedFile!=null) {
            newService.setImage(uploadedFile.getContents());
        }
        if (userService.addServiceToUser(user, newService)) {
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

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
