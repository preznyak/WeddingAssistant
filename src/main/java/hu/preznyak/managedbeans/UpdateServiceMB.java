package hu.preznyak.managedbeans;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.services.ServiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <h1>UpdateServiceMB ManagedBean class.</h1>
 * This is a managed bean class for updating services.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "UpdateServiceMB")
@SessionScoped
public class UpdateServiceMB {

    /**
     * A {@link Service} object can be updated.
     */
    private Service updatableService;

    private ServiceService serviceService;

    @PostConstruct
    public void init(){
        serviceService = new ServiceService();
    }

    /**
     * selectServiceForUpdate method for selecting a {@link Service} for update.
     * @param service a {@link Service} object.
     * @return String a navigation String
     */
    public String selectServiceForUpdate(Service service){
        updatableService = service;
        return "/updateMyService";
    }

    /**
     * updateService method for updating the updatableService object.
     * @return String a navigation string.
     */
    public String updateService(){
        serviceService.updateService(updatableService);
        return "/myServices";
    }

    /**
     * No-arg constructor for {@link UpdateServiceMB} class.
     */
    public UpdateServiceMB() {
    }

    /**
     * Getter method for updatableService.
     * @return updatableService a {@link Service} object.
     */
    public Service getUpdatableService() {
        return updatableService;
    }

    /**
     * Setter method for updatableService.
     * @param updatableService a {@link Service} object.
     */
    public void setUpdatableService(Service updatableService) {
        this.updatableService = updatableService;
    }
}
