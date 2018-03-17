package hu.preznyak.entities;

import javax.persistence.*;

/**
 * <h1>Request class</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */


@Table
@Entity(name = "request")
public class Request {

    /**
     * The id of the Request.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The {@link WeddingEvent} which needs the {@link Service}.
     */
    @OneToOne(targetEntity = WeddingEvent.class, fetch = FetchType.EAGER)
    private WeddingEvent weddingEvent;

    /**
     * The {@link Service} which is needed by the {@link WeddingEvent}.
     */
    @OneToOne(targetEntity = Service.class, fetch = FetchType.EAGER)
    private  Service service;

    /**
     * Additional note.
     */
    @Column
    private String note;

    /**
     * A boolean value, which shows if the Request is active or not anymore.
     */
    private boolean active;

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeddingEvent getWeddingEvent() {
        return weddingEvent;
    }

    public void setWeddingEvent(WeddingEvent weddingEvent) {
        this.weddingEvent = weddingEvent;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
