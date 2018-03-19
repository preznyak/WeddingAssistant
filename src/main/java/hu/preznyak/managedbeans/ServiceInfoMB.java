package hu.preznyak.managedbeans;

import hu.preznyak.entities.Offer;
import hu.preznyak.entities.Service;
import hu.preznyak.services.OfferService;
import hu.preznyak.services.ServiceService;
import org.primefaces.event.RateEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

    private OfferService offerService;

    private ScheduleModel scheduleModel;

    /**
     * A {@link Service} object.
     */
    private Service serviceInfo;

    private BufferedImage image;

    private int newRating;

    List<Offer> offerList;

    @PostConstruct
    public void init(){
        serviceService = new ServiceService();
        offerService = new OfferService();
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
        initSchedule(serviceInfo);
        return "/serviceInfo";
    }

    public void initSchedule(Service service){
        offerList = offerService.getOffersByService(service);
        scheduleModel = new DefaultScheduleModel();
        for(Offer offer : offerList){
            if(offer.isAccepted()) {
                scheduleModel.addEvent(new DefaultScheduleEvent(offer.getWeddingEvent().getEventName(),
                        asDate(offer.getWeddingEvent().getEventDate()), asDate(offer.getWeddingEvent().getEventDate())));
            }
        }
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
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

    public Service getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(Service serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public ScheduleModel getScheduleModel() {
        return scheduleModel;
    }

    public void setScheduleModel(ScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    }
}
