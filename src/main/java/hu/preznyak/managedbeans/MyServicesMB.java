package hu.preznyak.managedbeans;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean(name = "MyServices")
@ViewScoped
public class MyServicesMB {

    private List<Service> myServicesList;

    @PostConstruct
    public void init(){
        HttpSession session = SessionUtils.getSession();
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserById((Integer)session.getAttribute("userid"));
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        myServicesList = serviceDAO.getServicesByUser(user);
    }

    public MyServicesMB() {
    }

    public List<Service> getMyServicesList() {
        return myServicesList;
    }

    public void setMyServicesList(List<Service> myServicesList) {
        this.myServicesList = myServicesList;
    }
}
