package hu.preznyak.managedbeans;

import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;
import hu.preznyak.services.RequestService;
import hu.preznyak.services.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

@ManagedBean(name = "CreateRequestMB")
@SessionScoped
public class CreateRequestMB {

    private RequestService requestService;
    private UserService userService;

    private Request newRequest;

    @PostConstruct
    public void init(){
        requestService = new RequestService();
        userService = new UserService();
    }

    public String setServiceToRequest(Service service){
        newRequest.setService(service);
        return "/createRequest";
    }

    public void createRequest(){
        requestService.createRequest(newRequest);
    }

    public Request getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(Request newRequest) {
        this.newRequest = newRequest;
    }
}
