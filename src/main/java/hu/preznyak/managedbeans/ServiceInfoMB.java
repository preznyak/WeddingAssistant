package hu.preznyak.managedbeans;

import hu.preznyak.entities.Service;
import hu.preznyak.services.ServiceService;
import org.primefaces.event.RateEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.awt.image.BufferedImage;

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

    private ServiceService serviceService;

    /**
     * A {@link Service} object.
     */
    private Service serviceInfo;

    private BufferedImage image;

    private int newRating;

    @PostConstruct
    public void init(){
        serviceService = new ServiceService();
        newRating = 0;

    }

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

    public void onRate(RateEvent rateEvent){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate event","You rated" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    public void rateService(){
        Service ratedService = serviceService.getServiceById(serviceInfo.getId());
        serviceService.rateService(ratedService, newRating);
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getNewRating() {
        return newRating;
    }

    public void setNewRating(int newRating) {
        this.newRating = newRating;
    }
}
