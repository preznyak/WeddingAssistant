package hu.preznyak.daos;

import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;

import java.util.List;


/**
 * <h1>UserDAO interface.</h1>
 * Interface class that has a few methods for {@link User} entity manipulation.
 *
 * @author Preznyák László
 * @version 1.0
 */

public interface UserDAO {

    /**
     * Getting a {@link User} from the database by id.
     * @param id the id of the user.
     * @return User A {@link User} from the database.
     */
    User getUserById(int id);

    /**
     * Getting a {@link User} from the database by username and password.
     * @param username the username of the {@link User}
     * @param password the password of the {@link User}
     * @return User a {@link User} from the database.
     */
    User getUser(String username, String password);

    /**
     * Adding a new {@link User} to the database.
     * @param user a {@link User} to be added.
     * @return boolean a boolean value. True if the operation was successful, false otherwise.
     */
    boolean addUser(User user);

    /**
     * Adding a new service to a user's servicesList
     * @param user {@link User} object.
     * @param service {@link Service} object.
     * @return boolean a boolean value. True if the operation was successful, false otherwise.
     */
    boolean addServiceToUser(User user, Service service);

    /**
     * A method for removing a user's service from the servicesList.
     * @param user {@link User} object.
     * @param id id of a {@link Service} object.
     * @return boolean a boolean value. True if the operation was successful, false otherwise.
     */
    boolean removeMyService(User user,int id);

    /**
     * A method for getting a user's servicesList from the database.
     * @param user a {@link User} object.
     * @return List a List of services.
     */
    List<Service> getMyServices(User user);

    /**
     * Adding a new Wedding event to a user's wedding list
     * @param user the user who created the wedding
     * @param weddingEvent the new wedding event.
     * @return boolean a boolean value. true if the operation was successful, false otherwise.
     */
    boolean addWeddingToUser(User user, WeddingEvent weddingEvent);

    /**
     * Removing a {@link WeddingEvent} from the wedding event list of a user.
     * @param user the user who removes his / her wedding.
     * @param id the id of the {@link WeddingEvent} which will be removed.
     * @return boolean a boolean value. true if the operation was successful, false otherwise.
     */
    boolean removeMyWedding(User user, int id);

    /**
     * A method for getting a user's weddingEventList from the database.
     * @param user the user who owns the {@link WeddingEvent} list.
     * @return List a list of {@link WeddingEvent} obejcts.
     */
    List<WeddingEvent> getMyWeddings(User user);
}
