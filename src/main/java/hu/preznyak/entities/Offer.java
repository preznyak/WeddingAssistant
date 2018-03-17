package hu.preznyak.entities;

import javax.persistence.*;

/**
 * <h1>Offer class</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name ="offer")
public class Offer {

    /**
     * The id of the Offer.
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
     * The {@link Service} which is ordered by a {@link WeddingEvent}.
     */
    @OneToOne(targetEntity = Service.class, fetch = FetchType.EAGER)
    private  Service service;

    /**
     * Note.
     */
    @Column(nullable = false)
    private String note;

    /**
     * The price of the {@link Service}.
     */
    @Column
    private double price;

    /**
     * A boolean value which shows, if the Offer was accepted by the {@link WeddingEvent} owner, or not.
     */
    @Column
    private boolean accepted;

    public Offer() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", weddingEvent=" + weddingEvent +
                ", service=" + service +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", accepted=" + accepted +
                '}';
    }
}
