package hu.preznyak.managedbeans;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.utils.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean(name = "MyServices")
@RequestScoped
public class MyServicesMB {

    private List<Service> myServicesList;

    @PostConstruct
    public void init(){
        HttpSession session = SessionUtils.getSession();
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserById((Integer)session.getAttribute("userid"));
        myServicesList = user.getServiceList();
    }

    public void removeMyService(int id){
        HttpSession session = SessionUtils.getSession();
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserById((Integer)session.getAttribute("userid"));
        userDAO.removeMyService(user,id);
        init();
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
