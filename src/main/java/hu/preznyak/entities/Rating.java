package hu.preznyak.entities;

import javax.persistence.*;

@Table
@Entity(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int ratingValue;

    public Rating() {
    }

    public Rating(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }
}
