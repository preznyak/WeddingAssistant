package hu.preznyak.managedbeans;

import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.services.RequestService;
import hu.preznyak.services.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "CreateRequestMB")
@SessionScoped
public class CreateRequestMB {

    private RequestService requestService;
    private UserService userService;

    private Request newRequest;

    @PostConstruct
    public void init(){
        newRequest = new Request();
        requestService = new RequestService();
        userService = new UserService();
    }

    public String setWeddingToRequest(WeddingEvent weddingEvent){
        newRequest.setWeddingEvent(weddingEvent);
        return "/createRequest";
    }

    public String createRequest(){
        requestService.createRequest(newRequest);
        return "/home";
    }

    public Request getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(Request newRequest) {
        this.newRequest = newRequest;
    }
}
