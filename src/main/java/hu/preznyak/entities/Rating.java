package hu.preznyak.entities;

import javax.persistence.*;

/**
 * <h1>Rating class</h1>
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name = "rating")
public class Rating {

    /**
     * The id of the Rating.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Rating value.
     */
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
