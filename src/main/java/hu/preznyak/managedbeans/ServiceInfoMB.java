package hu.preznyak.managedbeans;

import hu.preznyak.entities.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <h1>ServiceInfoMB ManagedBean class.</h1>
 * This is a class for showing information about a {@link Service} object.
 *
 * @author Prenyák László
 * @version 1.0
 */

@ManagedBean(name = "ServiceInfoMB")
@SessionScoped
public class ServiceInfoMB {

    /**
     * A {@link Service} object.
     */
    private Service serviceInfo;

    /**
     * No-arg constructor for the {@link ServiceInfoMB} class.
     */
    public ServiceInfoMB() {
    }

    /**
     * Constructor for the {@link ServiceInfoMB} class.
     * @param service a {@link Service} object.
     */
    public ServiceInfoMB(Service service) {
        this.serviceInfo = service;
    }

    /**
     * selectServiceForInfo method for selecting a service.
     * The selected service will be stored in the service object.
     * @param service a {@link Service} object.
     * @return String a navigation String.
     */
    public String selectServiceForInfo(Service service){
        serviceInfo = service;
        return "/serviceInfo";
    }

    /**
     * Getter method for serviceInfo.
     * @return serviceInfo the {@link Service} object.
     */
    public Service getService() {
        return serviceInfo;
    }

    /**
     * Setter method for the serviceInfo.
     * @param service a {@link Service} object.
     */
    public void setService(Service service) {
        this.serviceInfo = service;
    }
}
