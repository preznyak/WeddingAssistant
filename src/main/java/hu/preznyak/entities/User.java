package hu.preznyak.entities;

import hu.preznyak.enums.Roles;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "wa_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String roles;

    public User(String username, String password, String firstName, String email, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.roles = this.getRoles() + Roles.USER.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User() {
    }
}
