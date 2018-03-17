package hu.preznyak.entities;

import javax.persistence.*;


@Table
@Entity(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = WeddingEvent.class, fetch = FetchType.EAGER)
    private WeddingEvent weddingEvent;

    @OneToOne(targetEntity = Service.class, fetch = FetchType.EAGER)
    private  Service service;

    @Column
    private String note;

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
