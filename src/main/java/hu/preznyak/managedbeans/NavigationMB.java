package hu.preznyak.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "NavigationMB")
public class NavigationMB {
    public String goHome(){
        return "/home";
    }

    public String goToIndex(){
        return "/index";
    }

    public String goToMyServices(){
        return "/myServices";
    }

    public String goToAllServices(){
        return "/services";
    }
    public String goToCreateService(){
        return "/createService";
    }

    public String goToLogin(){
        return "/login";
    }
}
