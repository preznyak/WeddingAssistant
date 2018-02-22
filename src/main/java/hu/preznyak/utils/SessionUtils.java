package hu.preznyak.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * <h1>SessionUtils class.</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

public class SessionUtils {

    /**
     * getSession method for providing a session.
     * @return A HttpSession object.
     */
    public static HttpSession getSession(){
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
}
