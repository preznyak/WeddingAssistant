package hu.preznyak.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * <h1>WedddingEvent class</h1>
 * This is a class for wedding events.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name = "wedding")
public class WeddingEvent {

    /**
     * The id of the wedding.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The name of the wedding event.
     */
    @Column
    private String eventName;

    /**
     * The date of the wedding.
     */
    @Column(nullable = false)
    private LocalDate eventDate;

    /**
     * The description of the wedding.
     */
    @Column(length = 1000)
    private String description;

    /**
     * The list of booked services.
     */
    @OneToMany(targetEntity = Service.class)
    private List<Service> bookedServices;

    @Column
    private String location;

    /**
     * No-arg constructor for WeddingEvent.
     */
    public WeddingEvent() {
    }

    /**
     * Constructor for {@link WeddingEvent} with parameters.
     * @param eventName the name of the event
     * @param eventDate the date of the event
     * @param description the description of the event
     */
    public WeddingEvent(String eventName, LocalDate eventDate, String description, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.description = description;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Service> getBookedServices() {
        return bookedServices;
    }

    public void setBookedServices(List<Service> bookedServices) {
        this.bookedServices = bookedServices;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
