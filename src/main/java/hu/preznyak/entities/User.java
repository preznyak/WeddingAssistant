package hu.preznyak.entities;

import javax.persistence.*;
import java.util.List;

/**
 * <h1>User Entity Class</h1>
 * This is an entity class for User objects.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name = "wa_user")
public class User {

    /**
     * The id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private int id;

    /**
     * The username of the user.
     * It is not nullable, and it should be unique.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * The password of the user.
     * It is not nullable.
     */
    @Column(nullable = false)
    private String password;

    /**
     * The first name of the user.
     * It is not nullable.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * The email address of the user.
     * It is not nullable, and it should be unique.
     */
    @Column(nullable = false,unique = true)
    private String email;

    /**
     * The last name of the user.
     * It is not nullable.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * The address of the user.
     */
    @Column(nullable = false)
    private String address;

    /**
     * List of the user's registered services in the application.
     */
    @OneToMany(targetEntity = Service.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Service> serviceList;

    /**
     * User constructor with all instance variables.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param firstName The first name of the user.
     * @param email The email address of the user.
     * @param lastName The last name of the user.
     * @param serviceList Sevice list of the user.
     * @param address The address of the user.
     */
    public User(String username, String password, String firstName, String email, String lastName, List<Service> serviceList, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.serviceList = serviceList;
        this.address = address;
    }

    /**
     * Getter for id variable.
     * @return id the id of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id variable.
     * @param id the id of the user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for username.
     * @return username the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username.
     * @param username the username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for password.
     * @return password the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for first name of the user.
     * @return firstName the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name of the user.
     * @param firstName the first name of the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for email address of the user.
     * @return email the email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email address.
     * @param email the email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the last name.
     * @return lastName the last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name.
     * @param lastName the last name of the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for the address.
     * @return address the address of the user.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for the address.
     * @param address the address of the user.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for the service list.
     * @return serviceList the service list of the user.
     */
    public List getServiceList() {
        return serviceList;
    }

    /**
     * Setter for the service list.
     * @param serviceList the service list of the user.
     */
    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    /**
     * Constructor without parameters.
     */
    public User() {
    }

    /**
     * toString method of the user class.
     * @return The String format of an User object.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", serviceList=" + serviceList +
                '}';
    }
}
