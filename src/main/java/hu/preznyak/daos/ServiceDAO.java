package hu.preznyak.daos;

import hu.preznyak.entities.Service;
import java.util.List;

/**
 * <h1>ServiceDAO interface.</h1>
 * Interface class that has methods for manipulating {@link Service} entities.
 *
 * @author Preznyák László
 * @version 1.0
 */
public interface ServiceDAO {

    /**
     * Getter method. Gets a {@link Service} object from the database by id.
     * @param id the id of the {@link Service} object.
     * @return Service a {@link Service} object.
     */
    Service getServiceById(int id);

    /**
     * Method for updating {@link Service} entities in the database.
     * @param service the {@link Service} object which will be updated.
     * @return boolean a boolean value. True if the operation was successful, false otherwise.
     */
    boolean updateService(Service service);

    /**
     * Method for getting all the service entities from the database.
     * @return List the list of services.
     */
    List<Service> getAllServices();
}
