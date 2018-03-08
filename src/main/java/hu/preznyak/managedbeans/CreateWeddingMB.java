package hu.preznyak.managedbeans;

import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;
import hu.preznyak.services.UserService;
import hu.preznyak.services.WeddingService;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import java.time.ZoneId;
import java.util.Date;

@ManagedBean(name = "CreateWeddingMB")
@RequestScoped
public class CreateWeddingMB {

    private WeddingEvent weddingEvent;

    private UserService userService;

    private Date eventDate;

    @PostConstruct
    public void init(){
        userService = new UserService();
        weddingEvent = new WeddingEvent();
    }

    public String createWedding(){
        HttpSession session = SessionUtils.getSession();
        User user = userService.getUserById((Integer) session.getAttribute("userid"));
        weddingEvent.setEventDate(eventDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if(userService.addWeddingToUser(user, weddingEvent)){
            return "/home";
        } else {
            return "/createWedding";
        }
    }

    public WeddingEvent getWeddingEvent() {
        return weddingEvent;
    }

    public void setWeddingEvent(WeddingEvent weddingEvent) {
        this.weddingEvent = weddingEvent;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
