package hu.preznyak.daos;

import hu.preznyak.entities.WeddingEvent;

import java.util.List;

/**
 * <h1>WeddingDao interface.</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

public interface WeddingDao {

    /**
     * Getter method, which gets a {@link WeddingEvent} object from the database by id, if exists.
     * @param id the id of the {@link WeddingEvent}.
     * @return WeddingEvent a {@link WeddingEvent} object from the database.
     */
    WeddingEvent getWeddingEventById(int id);

    /**
     * Getter method for getting all the registered {@link WeddingEvent} objects from the database.
     * @return List a {@link List<WeddingEvent>}.
     */
    List<WeddingEvent> getAllWeddingEvents();

    /**
     * Update method for {@link WeddingEvent} objects.
     * @param weddingEvent the {@link WeddingEvent} which will be updated.
     * @return boolean a boolean value. true if the operation was successful, false otherwise.
     */
    boolean updateWedding(WeddingEvent weddingEvent);

}
