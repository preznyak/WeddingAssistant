package hu.preznyak.managedbeans;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.services.ServiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * <h1>ListALlServicesMB ManagedBean class.</h1>
 * This is a managed bean for listing all the registered services from the database.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "ServicesListMB")
@ViewScoped
public class ListAllServicesMB {

    /**
     * The {@link Service} list.
     */
    private List<Service> serviceList;

    private ServiceService serviceService;

    @PostConstruct
    public void init(){
        serviceService = new ServiceService();
        serviceList = serviceService.getAllServices();
    }

    /**
     * No-arg constructor for {@link ListAllServicesMB} class.
     */
    public ListAllServicesMB() {
    }

    /**
     * Getter method for the serviceList.
     * @return serviceList the list of services.
     */
    public List<Service> getServiceList() {
        return serviceList;
    }

    /**
     * Setter method for the serviceList.
     * @param serviceList the service list.
     */
    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
