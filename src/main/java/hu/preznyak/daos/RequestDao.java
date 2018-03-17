package hu.preznyak.daos;

import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;

import java.util.List;

/**
 * <h1>RequestDAO interface.</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

public interface RequestDao {

    /**
     * createRequest method for creating a new {@link Request}.
     * @param request the new {@link Request}.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean createRequest(Request request);

    /**
     * deleteRequest method for deleting a {@link Request}.
     * @param request the {@link Request} which will be deleted.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean deleteRequest(Request request);

    /**
     * getAllRequests method for getting all {@link Request} objects from the db.
     * @return List a List of {@link Request} objects.
     */
    List<Request> getAllRequests();

    /**
     * updateRequest method for updating a {@link Request} object in the db.
     * @param request the {@link Request} which will be updated.
     * @return boolean a boolean value to show the operation's successfulness.
     */
    boolean updateRequest(Request request);

    /**
     * getRequestsByService method for getting {@link Request} object by Service.
     * @param service the {@link Service} which is linked to the {@link Request}.
     * @return List a List of {@link Request} objects.
     */
    List<Request> getRequestsByService(Service service);
}
