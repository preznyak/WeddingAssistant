package hu.preznyak.managedbeans;

import javax.faces.bean.ManagedBean;

/**
 * <h1>NavigationMB ManagedBean class.</h1>
 * A class for navigation.
 *
 * @author Preznyák László
 * @version 1.0
 */

@ManagedBean(name = "NavigationMB")
public class NavigationMB {

    /**
     * Method for sending the application to the home page.
     * @return String address of the home page.
     */
    public String goHome(){
        return "/home";
    }

    /**
     * Method for sending the application to the index page.
     * @return String address of the index page.
     */
    public String goToIndex(){
        return "/index";
    }

    /**
     * Method for sending the application to the myServices page.
     * @return String address of the myServices page.
     */
    public String goToMyServices(){
        return "/myServices";
    }

    /**
     * Method for sending the application to the services page.
     * @return String address of the services page.
     */
    public String goToAllServices(){
        return "/services";
    }

    /**
     * Method for sending the application to the createService page.
     * @return String address of the createService page.
     */
    public String goToCreateService(){
        return "/createService";
    }

    /**
     * Method for sending the application to the login page.
     * @return String address of the login page.
     */
    public String goToLogin(){
        return "/login";
    }

    /**
     * Method for sending the application to the createWedding page.
     * @return String address of the createWedding page.
     */
    public String goToCreateWedding(){ return "/createWedding"; }

    /**
     * Method for sending the application to the createRequest page.
     * @return String address of the createRequest page.
     */
    public String goToCreateRequest(){ return "/createRequest"; }

    //Method for sending the application to the myWedding page.
    public String goToMyWedding(){ return "/myWedding"; }

    //Method for sending the application to the myOffers page.
    public String goToMyOffers(){ return "/myOffers"; }
}
