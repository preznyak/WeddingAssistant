package hu.preznyak.entities;

import javax.persistence.*;


@Table
@Entity(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = WeddingEvent.class)
    private WeddingEvent weddingEvent;

    @OneToOne(targetEntity = Service.class)
    private  Service service;

    @Column
    private String note;

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
}
