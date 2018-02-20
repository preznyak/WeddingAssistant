package hu.preznyak.managedbeans;

import hu.preznyak.entities.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ServiceInfoMB")
@SessionScoped
public class ServiceInfoMB {

    private Service serviceInfo;

    public ServiceInfoMB() {
    }

    public ServiceInfoMB(Service service) {
        this.serviceInfo = service;
    }

    public String selectServiceForInfo(Service service){
        serviceInfo = service;
        return "/serviceInfo";
    }

    public Service getService() {
        return serviceInfo;
    }

    public void setService(Service service) {
        this.serviceInfo = service;
    }
}
