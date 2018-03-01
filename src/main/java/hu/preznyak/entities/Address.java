package hu.preznyak.entities;

import javax.persistence.*;

/**
 * <h1>Address Entity Class</h1>
 * This is an entity class for adresses.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name = "address")
public class Address {

    /**
     * The id of the {@link Address}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The country of the {@link Address}
     */
    @Column(nullable = false)
    private String country;

    /**
     * The city of the {@link Address}
     */
    @Column(nullable = false)
    private String city;

    /**
     * The post code of the {@link Address}
     */
    @Column
    private String postCode;

    /**
     * The street of the {@link Address}
     */
    @Column
    private String street;

    /**
     * The house number of the {@link Address}
     */
    @Column
    private String houseNumber;

    /**
     * No-arg constructor for {@link Address}
     */
    public Address() {
    }

    /**
     * Constructor for Address with instance variables.
     * @param country the country of the {@link Address}
     * @param city the city of the {@link Address}
     * @param postCode the psotcode of the {@link Address}
     * @param street the street of the {@link Address}
     * @param houseNumber the house number of the {@link Address}
     */
    public Address(String country, String city, String postCode, String street, String houseNumber) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    /**
     * Getter for the id.
     * @return id the id of the {@link Address}
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id.
     * @param id the id of the {@link Address}
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter fot the country of the {@link Address}
     * @return country the country of the {@link Address}
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter fot the country of the {@link Address}
     * @param country the country of the {@link Address}
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter fot the city of the {@link Address}
     * @return city the city of the {@link Address}
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter fot the city of the {@link Address}
     * @param city the city of the {@link Address}
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for postcode of the {@link Address}
     * @return postCode the postcode of the {@link Address}
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Setter for postcode of the {@link Address}
     * @param postCode the postcode of the {@link Address}
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Getter for the street of the {@link Address}
     * @return street the street of the {@link Address}
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for the street of the {@link Address}
     * @param street the street of the {@link Address}
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for the houseNumber of the {@link Address}
     * @return houseNumber the houseNumber of the {@link Address}
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setter for the houseNumber of the {@link Address}
     * @param houseNumber the house number of the {@link Address}
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * ToString method for the {@link Address} entity class.
     * @return String format of an {@link Address} object.
     */
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
